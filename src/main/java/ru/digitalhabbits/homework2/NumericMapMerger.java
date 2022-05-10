package ru.digitalhabbits.homework2;

import java.util.Map;

/**
 * Optional
 *
 * Merger for 2 maps
 * Given ([a=3,b=4] , [a=3,b=1,c=7])
 * will return [a=6,b=5,c=7]
 */
public interface NumericMapMerger {

    <T> Map<T, Long> merge(Map<T, Long> first, Map<T, Long> second);

}
