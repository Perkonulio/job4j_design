package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAddModel() {
        SimpleArray<Integer> arr = new SimpleArray<>(5);
        arr.add(5);
        assertThat(arr.get(0), is(5));
    }

    @Test
    public void whenRemoveModel() {
        SimpleArray<String> arr = new SimpleArray<>(5);
        arr.add("Pedro");
        arr.remove(0);
        assertTrue(arr.isEmpty());
    }

    @Test
    public void whenSetModel() {
        SimpleArray<String> arr = new SimpleArray<>(5);
        arr.add("Pedro");
        arr.set(0, "Hulio");
        assertThat(arr.get(0), is("Hulio"));
    }

    @Test
    public void whenIteratorActivate() {
        SimpleArray<String> arr = new SimpleArray<>(5);
        arr.add("Pedro");
        arr.add("Hulio");
        Iterator<String> iterator = arr.iterator();
        assertThat(iterator.next(), is("Pedro"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Hulio"));
        assertThat(iterator.hasNext(), is(false));
    }
}