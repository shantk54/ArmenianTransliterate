package shant;

import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        // Define the resources directory path relative to the project root
        Path resourcesDir = Paths.get("src/main/resources");
        Path inputFile;

        try {
            // Ensure the resources directory exists
            if (!Files.exists(resourcesDir) || !Files.isDirectory(resourcesDir)) {
                throw new IOException("Resources directory does not exist or is not a directory");
            }

            // Find the first .txt file in the resources directory
            inputFile = Files.list(resourcesDir)
                    .filter(path -> path.toString().endsWith(".txt"))
                    .findFirst()
                    .orElseThrow(() -> new IOException("No .txt file found in resources directory"));

            // Check if the input file is named output.txt
            if ("output.txt".equals(inputFile.getFileName().toString())) {
                throw new IOException("Input file cannot be named output.txt");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }

        // Define the output file path in the resources directory
        Path outputFile = resourcesDir.resolve("output.txt");

        Transliterate transliterate = new Transliterate();

        try {
            String content = Files.readString(inputFile);

            String transliteratedContent = transliterate.transliterate(content);

            // Write the output file to the resources directory
            Files.writeString(outputFile, transliteratedContent);

            System.out.println("Transliteration complete. Output written to: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }
}
