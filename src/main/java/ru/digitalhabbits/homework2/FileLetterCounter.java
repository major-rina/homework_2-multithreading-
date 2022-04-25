package ru.digitalhabbits.homework2;

import java.nio.file.Path;
import java.util.Map;

/**
 * Counter characters in given file
 */
public interface FileLetterCounter {

    Map<Character, Long> count(Path filePath);

}
