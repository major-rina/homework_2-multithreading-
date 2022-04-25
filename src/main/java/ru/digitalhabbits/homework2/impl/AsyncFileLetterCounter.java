package ru.digitalhabbits.homework2.impl;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;

import ru.digitalhabbits.homework2.FileLetterCounter;
import ru.digitalhabbits.homework2.FileReader;
import ru.digitalhabbits.homework2.LetterCountMerger;
import ru.digitalhabbits.homework2.LetterCounter;

public class AsyncFileLetterCounter implements FileLetterCounter {
    private final Map<Character, Long> symbolCounts;
    private final FileReader content;
    private final LetterCounter letterCounter;
    private final LetterCountMerger letterCountMerger;

    public AsyncFileLetterCounter(FileReader content, LetterCounter letterCounter, LetterCountMerger letterCountMerger) {
        this.symbolCounts = new ConcurrentHashMap<>();
        this.content = content;
        this.letterCounter = letterCounter;
        this.letterCountMerger = letterCountMerger;
    }

    @Override
    public Map<Character, Long> count(Path filePath) {
        content.readLines(filePath)
                .filter(Objects::nonNull)
                .filter(Predicate.not(String::isBlank))
                .forEach(line -> {
                    try {
                        symbolCounts.putAll(
                                CompletableFuture
                                        .supplyAsync(() -> letterCounter.count(line))
                                        .thenApply(map -> letterCountMerger.merge(map, symbolCounts))
                                        .get());
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });
        return symbolCounts;
    }
}
