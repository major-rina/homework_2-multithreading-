package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.NumericMapMerger;

import java.util.Map;

public class NumericMapMergerImpl implements NumericMapMerger {
    @Override
    public <T> Map<T, Long> merge(Map<T, Long> first, Map<T, Long> second) {
        second.forEach((key, value) -> first.merge(key, value, Long::sum));
        return first;
    }
}