import Service.GameService;
import clients.RawgApiClient;
import entities.CSVExporter;
import entities.VideoGame;
import java.io.IOException;
import java.util.List;

public class Main {

    private static final GameService gameService = new GameService();
    private static final RawgApiClient rawgApiClient = new RawgApiClient();

    public static void main(String[] args) throws IOException, InterruptedException {

        List<VideoGame> games = rawgApiClient.getVideoGaames();

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