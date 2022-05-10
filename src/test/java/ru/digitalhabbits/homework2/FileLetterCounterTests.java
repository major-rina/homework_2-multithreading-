package ru.digitalhabbits.homework2;

import org.junit.jupiter.api.Test;
import ru.digitalhabbits.homework2.impl.LetterCounterImpl;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileLetterCounterTests {

    @Test
    public void should_count_symbols_from_string() {
        var source = "HerhTaaaEA";
        var actual = new LetterCounterImpl().count(source);
        var expected = Map.of('h', 2L, 'e', 2L, 'r', 1L, 't', 1L, 'a', 4L);
        assertEquals(expected, actual);
    }
}
