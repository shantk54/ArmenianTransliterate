package shant;

import shant.transliteration.FileProcessor;

public class Main {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.processFiles();
        System.out.println("\nTransliteration complete.");
    }
}
