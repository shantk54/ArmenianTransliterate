package shant.transliteration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileProcessor {

    private static final String RESOURCES_DIR = "src/main/resources";
    private static final String OUTPUT_DIR = RESOURCES_DIR + "/output";

    public void processFiles() {
        try {
            Path resourcesDir = Paths.get(RESOURCES_DIR);
            Path outputDir = Paths.get(OUTPUT_DIR);

            validateDirectory(resourcesDir);
            createOutputDirectory(outputDir);

            List<Path> inputFiles = getInputFiles(resourcesDir);
            if (inputFiles.isEmpty()) {
                System.err.println("No valid .txt files found in resources directory.");
                return;
            }

            Transliteration transliteration = new Transliteration();
            for (Path inputFile : inputFiles) {
                Path outputFile = getOutputFilePath(inputFile, outputDir);
                processFile(inputFile, outputFile, transliteration);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void validateDirectory(Path directory) throws IOException {
        if (!Files.isDirectory(directory)) {
            throw new IOException("Directory does not exist or is not a directory: " + directory);
        }
    }

    private void createOutputDirectory(Path outputDir) throws IOException {
        if (!Files.exists(outputDir)) {
            Files.createDirectories(outputDir);
        }
    }

    private List<Path> getInputFiles(Path resourcesDir) throws IOException {
        try (var files = Files.list(resourcesDir)) {
            return files
                    .filter(path -> path.toString().endsWith(".txt"))
                    .filter(path -> !path.getFileName().toString().endsWith("_output.txt"))
                    .toList();
        }
    }

    private Path getOutputFilePath(Path inputFile, Path outputDir) {
        String inputFileName = inputFile.getFileName().toString();
        String outputFileName = inputFileName.replace(".txt", "_output.txt");
        return outputDir.resolve(outputFileName);
    }

    private void processFile(Path inputFile, Path outputFile, Transliteration transliteration) throws IOException {
        String content = Files.readString(inputFile);

        if (content.isBlank()) {
            System.err.println("Skipping empty file: " + inputFile);
            return;
        }

        String cleanedContent = content.replaceAll("(?<=\\p{L})[^\\p{L}\\s]+(?=\\p{L})", "");
        String transliteratedContent = transliteration.transliterate(cleanedContent);

        Files.writeString(outputFile, transliteratedContent, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        System.out.println("Processed file: " + inputFile.getFileName());
    }
}
