package entities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {

    public static void export(List<VideoGame> games) {

        try (FileWriter fileWriter = new FileWriter("videojuegos.csv")) {

            fileWriter.append("Nombre,Rating,Fecha de salida, Requerimientos minimos\n");

            for (VideoGame game : games) {
                fileWriter.append(escape(game.getName())).append(",");
                fileWriter.append(escape(game.getRating())).append(",");
                fileWriter.append(escape(game.getReleased())).append(",");
                fileWriter.append(escape(game.getPlatforms().get(0).getRequirements_en().getMinimum())).append("\n");
            }

            System.out.println("Archivo generado exitosamente");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String escape(String valor) {
        if (valor == null) return "N/A";
        return "\"" + valor.replace("\"", "\"\"") + "\"";
    }
}
