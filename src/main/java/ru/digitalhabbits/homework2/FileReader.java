package ru.digitalhabbits.homework2;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Sequential file reader
 */
public interface FileReader {

    Stream<String> readLines(Path filePath);

}
