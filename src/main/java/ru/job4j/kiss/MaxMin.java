package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    public <T> T maxMin(List<T> list, Comparator<T> comparator) {
        return logic(list, (x, y) -> comparator.compare(x, y) > 0);
    }

    public <T> T logic(List<T> list, BiPredicate<T, T> predicate) {
        T maximum = list.get(0);
        for (T t : list) {
            if (predicate.test(t, maximum)) {
                maximum = t;
            }
        }
        return maximum;
    }

}
