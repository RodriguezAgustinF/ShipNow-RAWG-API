import Service.GameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.APIResponse;
import entities.CSVExporter;
import entities.VideoGame;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {

    private static final String API_KEY = System.getenv("API_KEY");
    private static final String URL_ENDPOINT = "https://api.rawg.io/api/games?key=" + API_KEY + "&page_size=5";
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final GameService gameService = new GameService();

    public static void main(String[] args) throws IOException, InterruptedException {

        if (API_KEY == null) {
            throw new RuntimeException("Debes configurar la variable de entorno API_KEY");
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_ENDPOINT))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.out.println("Error al llamar a la API. Código: " + response.statusCode());

            if (response.statusCode() == 401 || response.statusCode() == 403) {
                System.out.println("API Key inválida o sin permisos.");
            }

            return;
        }

        APIResponse res = MAPPER.readValue(response.body(), APIResponse.class);

        List<VideoGame> games = res.getResults();

        if (games == null || games.isEmpty()) {
            System.out.println("No se recibieron juegos desde la API.");
            return;
        }
        gameService.filterPC(games);

        gameService.parseHTML(games);

        gameService.sortGames(games);

        CSVExporter.export(games);
    }
}