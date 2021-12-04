package ru.job4j.generics;

import java.util.*;
import java.util.function.Consumer;

public class SimpleLinkedList<T> implements List<T> {
    private T[] array;
    private int index = 0;
    private int size = 5;
    private static int modCount = 0;
    Node<T> first;
    Node<T> last;

    public SimpleLinkedList() {
        this.array = (T[]) new Object[size];
    }

    public SimpleLinkedList(int length) {
        size = length;
        this.array = (T[]) new Object[size];
    }

    public void linkLast(T element) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        array[index] = element;
        size++;
        modCount++;
    }

    @Override
    public void add(T object) {
        linkLast(object);
        index++;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iter = new Iterator<>() {
            private int indexIter = 0;
            private int counter = modCount;

            @Override
            public boolean hasNext() {
                return indexIter < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (counter != modCount) {
                    throw new ConcurrentModificationException();
                }
                return array[indexIter++];
            }
        };
        return iter;
    }
}
