package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {
    @Override
    public Stream<String> readLines(Path filePath) {
        try {
            return Files.lines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }
}
