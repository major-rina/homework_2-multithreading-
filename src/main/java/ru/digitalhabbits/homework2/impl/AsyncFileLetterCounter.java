package ru.digitalhabbits.homework2.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import ru.digitalhabbits.homework2.FileLetterCounter;
import ru.digitalhabbits.homework2.FileReader;
import ru.digitalhabbits.homework2.NumericMapMerger;
import ru.digitalhabbits.homework2.LetterCounter;

public class AsyncFileLetterCounter implements FileLetterCounter {
    private final FileReader fileReader;
    private final LetterCounter letterCounter;
    private final NumericMapMerger letterCountMerger;

    public AsyncFileLetterCounter(FileReader fileReader, LetterCounter letterCounter, NumericMapMerger numericMapMerger) {
        this.fileReader = fileReader;
        this.letterCounter = letterCounter;
        this.letterCountMerger = numericMapMerger;
    }

    @Override
    public Map<Character, Long> count(File file) {
        return fileReader.readLines(file)
                .map(it -> CompletableFuture
                                .supplyAsync(() -> letterCounter.count(it))
                )
                .map(CompletableFuture::join)
                .reduce(new HashMap<>(), letterCountMerger::merge);
    }
}
