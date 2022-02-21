package ru.job4j.inputoutput;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PrintFiles extends SimpleFileVisitor<Path> {
    Predicate<Path> pred;
    List<Path> list = new ArrayList<>();

    public PrintFiles(Predicate<Path> pred) {
        this.pred = pred;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (pred.test(file)) {
            list.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
}
