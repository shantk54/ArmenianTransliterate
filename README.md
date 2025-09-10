# Transliteration Tool

This project is a Java-based Western Armenian -> English transliteration tool that processes text files, applies transliteration rules, and outputs the results to a designated directory.

## Features
- Reads `.txt` files from the `src/main/resources` directory.
- Applies transliteration rules to the content of the files.
- Outputs the processed files to the `src/main/resources/output` directory.
- Skips empty files and ensures proper error handling.

## Prerequisites
- **Java**: Ensure you have Java 17 or higher installed.
- **Maven**: Ensure Maven is installed for dependency management and building the project.

## Project Structure

src/
├── main/
│   ├── java/
│   │   └── shant/
│   │       ├── Main.java
│   │       └── transliteration/
│   │           ├── FileProcessor.java
│   │           └── Transliteration.java
│   └── resources/
│       ├── input.txt
│       └── output/
