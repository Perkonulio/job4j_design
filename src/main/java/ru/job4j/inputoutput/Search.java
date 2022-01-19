package ru.job4j.inputoutput;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Search implements Predicate<Path> {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("./src");
        Predicate<Path> pred = new Search();
        search(start, pred);
    }

    public static List<Path> search(Path root, Predicate<Path> cond) throws IOException {
        PrintFiles print = new PrintFiles(cond);
        Files.walkFileTree(root, print);
        return print.list;
    }

    @Override
    public boolean test(Path path) {
        return path.getFileName().endsWith(".js");
    }
}
