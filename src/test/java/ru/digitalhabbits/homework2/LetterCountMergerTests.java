package ru.digitalhabbits.homework2;

import org.junit.jupiter.api.Test;
import ru.digitalhabbits.homework2.impl.NumericMapMergerImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterCountMergerTests {

    @Test
    public void should_merge_two_maps_summing() {
        var map1 = new HashMap<>(Map.of('a', 3L, 'b', 4L));
        var map2 = new HashMap<>(Map.of('a', 3L, 'b', 1L, 'c', 7L));
        new NumericMapMergerImpl().merge(map1, map2);
        var expected = Map.of('a', 6L, 'b', 5L, 'c', 7L);
        assertEquals(expected, map1);
    }

    @Test
    public void should_merge_two_maps_summing2() {
        Map<Character, Long> map1 = Map.of('a', 3L, 'b', 4L);
        Map<Character, Long> map2 = Collections.emptyMap();
        Map<Character, Long> actual = new NumericMapMergerImpl().merge(map1, map2);
        Map<Character, Long> expected = Map.of('a', 3L, 'b', 4L);
        assertEquals(expected, actual);
    }

    @Test
    public void should_merge_two_maps_summing3() {
        Map<Character, Long> map1 = Collections.emptyMap();
        Map<Character, Long> map2 = Collections.emptyMap();
        Map<Character, Long> actual = new NumericMapMergerImpl().merge(map1, map2);
        Map<Character, Long> expected = Collections.emptyMap();
        assertEquals(expected, actual);
    }
}
