package shant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Path resourcesDir = Paths.get("src/main/resources");
        Path outputFile = resourcesDir.resolve("output.txt");

        try {
            if (!Files.isDirectory(resourcesDir)) {
                throw new IOException("Resources directory does not exist or is not a directory");
            }

            Files.writeString(outputFile, "", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            List<Path> inputFiles;
            try (var files = Files.list(resourcesDir)) {
                inputFiles = files
                        .filter(path -> path.toString().endsWith(".txt"))
                        .filter(path -> !"output.txt".equals(path.getFileName().toString()))
                        .toList();
            }

            if (inputFiles.isEmpty()) {
                throw new IOException("No valid .txt files found in resources directory");
            }

            Transliterate transliterate = new Transliterate();

            for (Path inputFile : inputFiles) {
                String content = Files.readString(inputFile);

                if (content.isBlank()) {
                    System.err.println("Skipping empty file: " + inputFile);
                    continue;
                }

                String cleanedContent = content.replaceAll("(?<=\\p{L})[^\\p{L}\\s]+(?=\\p{L})", "");
                String transliteratedContent = transliterate.transliterate(cleanedContent);

                Files.writeString(outputFile, transliteratedContent + System.lineSeparator(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                System.out.println("Processed file: " + inputFile);
            }

            System.out.println("Transliteration complete. Output written to: " + outputFile);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
