package shant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Path resourcesDir = Paths.get("src/main/resources");
        Path outputFile = resourcesDir.resolve("output.txt");

        Path inputFile;
        try {
            if (!Files.isDirectory(resourcesDir)) {
                throw new IOException("Resources directory does not exist or is not a directory");
            }

            try (var files = Files.list(resourcesDir)) {
                Optional<Path> optionalInput = files
                        .filter(path -> path.toString().endsWith(".txt"))
                        .filter(path -> !"output.txt".equals(path.getFileName().toString()))
                        .findFirst();

                inputFile = optionalInput.orElseThrow(() -> new IOException("No valid .txt file found in resources directory"));
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }

        Transliterate transliterate = new Transliterate();
        try {
            String content = Files.readString(inputFile);

            String cleanedContent = content.replaceAll("(?<=\\p{L})[^\\p{L}\\s]+(?=\\p{L})", "");

            String transliteratedContent = transliterate.transliterate(cleanedContent);

            Files.writeString(outputFile, transliteratedContent);

            System.out.println("Transliteration complete. Output written to: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }
}
