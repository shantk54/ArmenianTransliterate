package shant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileProcessor {

    public void processFiles() {
        String resourcesDirPath = "src/main/resources";
        Path resourcesDir = Paths.get(resourcesDirPath);

        try {
            validateResourcesDirectory(resourcesDir);

            List<Path> inputFiles = getInputFiles(resourcesDir);
            if (inputFiles.isEmpty()) {
                throw new IOException("No valid .txt files found in resources directory");
            }

            Transliterate transliterate = new Transliterate();
            for (Path inputFile : inputFiles) {
                Path outputFile = getOutputFilePath(inputFile);
                processFile(inputFile, outputFile, transliterate);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void validateResourcesDirectory(Path resourcesDir) throws IOException {
        if (!Files.isDirectory(resourcesDir)) {
            throw new IOException("Resources directory does not exist or is not a directory");
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

    private Path getOutputFilePath(Path inputFile) {
        String inputFileName = inputFile.getFileName().toString();
        String outputFileName = inputFileName.replace(".txt", "_output.txt");
        return inputFile.getParent().resolve(outputFileName);
    }

    private void processFile(Path inputFile, Path outputFile, Transliterate transliterate) throws IOException {
        String content = Files.readString(inputFile);

        if (content.isBlank()) {
            System.err.println("Skipping empty file: " + inputFile);
            return;
        }

        String cleanedContent = content.replaceAll("(?<=\\p{L})[^\\p{L}\\s]+(?=\\p{L})", "");
        String transliteratedContent = transliterate.transliterate(cleanedContent);

        Files.writeString(outputFile, transliteratedContent, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        System.out.println("Processed file: " + inputFile.getFileName());
    }
}
