package com.jcourse.gaas.wordcounter.estimation.streamusage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSolution {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get(ClassLoader
                .getSystemClassLoader()
                .getResource("in.txt").toURI()));
             PrintWriter writer = new PrintWriter("out.txt")) {
            AtomicInteger counter = new AtomicInteger(0);
            lines //Stream строк файла
                    .flatMap((String line) -> {
                        String[] words = line.split("[^\\pL\\pN]+");
                        System.out.println("words=" + Arrays.toString(words));
                        return Arrays.stream(words);
                    })//Stream<String> слов
                    .filter(word -> !word.isEmpty())
                    .peek(word -> counter.incrementAndGet())
                    .collect(Collectors.toMap(Function.identity(), w -> 1, (freq1, freq2) -> freq1 + freq2))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed())
                    .forEach(entry -> writer.printf("%s;%d;%.2f%n", entry.getKey(), entry.getValue(),
                            (double) entry.getValue() / counter.get()));
        } catch (IOException | URISyntaxException e) {
        }
    }
}