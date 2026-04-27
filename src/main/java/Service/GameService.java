package Service;
import entities.VideoGame;
import org.jsoup.Jsoup;
import java.util.Comparator;
import java.util.List;

public class GameService {

    public void filterPC(List<VideoGame> games) {
        games.forEach(v ->
                v.getPlatforms().removeIf(p ->
                        p.getPlatform() == null ||
                                !"PC".equalsIgnoreCase(p.getPlatform().getName())
                )
        );
    }

    public void parseHTML(List<VideoGame> games) {

        for (VideoGame game : games) {
            game.getPlatforms()
                    .getFirst()
                    .getRequirements_en()
                    .setMinimum(Jsoup.parse(game.getPlatforms().getFirst().getRequirements_en().getMinimum()).text());
        }
    }

    public void sortGames(List<VideoGame> games) {
        games.sort(Comparator.comparing(v ->
                v.getPlatforms().stream()
                        .findFirst()
                        .map(p -> p.getRequirements_en().getMinimum())
                        .orElse("")));
    }
}
