package ru.job4j.generics;

public interface ListForArray<T> extends Iterable<T> {
    T remove(int index);

    T get(int index);

    int size();

    void add(T element);

    T set(int index, T element);
}
