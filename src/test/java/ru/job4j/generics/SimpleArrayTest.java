package ru.job4j.generics;

import org.junit.Test;

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
        assertNull(arr.get(0));
    }

    @Test
    public void whenSetModel() {
        SimpleArray<String> arr = new SimpleArray<>(5);
        arr.add("Pedro");
        arr.set(0, "Hulio");
        assertThat(arr.get(0), is("Hulio"));
    }
}