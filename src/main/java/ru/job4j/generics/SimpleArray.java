package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T>{
    private final T[] data;
    private int index = 0;

    public SimpleArray(int length) {
        this.data = (T[]) new Object[length];
    }


    public void add(T model) {
        data[index] = model;
        index++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, this.index + 1);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, this.index + 1);
        System.arraycopy(data, index + 1, data, index, this.index - index);
        this.index--;
    }

    public T get (int index) {
        Objects.checkIndex(index, this.index + 1);
        return data[index];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<>() {

            private int indexIter = 0;

            @Override
            public boolean hasNext() {
                return indexIter < index;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data[indexIter++];
            }
        };
        return it;
    }
}
