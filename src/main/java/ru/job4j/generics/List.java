package ru.job4j.generics;

public interface List<T> extends Iterable<T> {
    void add(T objects);
    T get(int index);
}
