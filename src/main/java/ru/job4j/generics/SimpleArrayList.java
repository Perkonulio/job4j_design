package ru.job4j.generics;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;

public class SimpleArrayList<T> implements ListForArray<T> {
    private T[] array;
    private int index = 0;
    private int size = 10;
    private int modCount = 0;

    public SimpleArrayList() {
        array = (T[]) new Object[size];
    }

    public SimpleArrayList(int length) {
        size = length;
        array = (T[]) new Object[size];
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, this.index);
        T obj = array[index];
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array[array.length - 1] = null;
        return obj;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return array[index];
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public void add(T element) {
        if (index == size) {
            array = Arrays.copyOf(array, size * 2);
        }
        array[index] = element;
        index++;
        modCount++;
    }

    @Override
    public T set(int index, T element) {
        Objects.checkIndex(index, this.index);
        return array[index] = element;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<>() {

            private int indexIter = 0;
            private int mod = modCount;

            @Override
            public boolean hasNext() {
                return indexIter < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (mod != modCount) {
                    throw new ConcurrentModificationException();
                }
                return array[indexIter++];
            }
        };
        return iterator;
    }
}
