package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    public <T> T maxMin(List<T> list, Comparator<T> comparator) {
        MaxMin maxMin = new MaxMin();
        BiPredicate<T, T> pred = (o1, o2) -> {
            return comparator.compare(o1, o2) > 0;
        };
        return maxMin.logic(list, pred);

    }

    public <T> T logic(List<T> list, BiPredicate<T, T> predicate) {
        T maximum = null;
        for (T t : list) {
            if (predicate.test(t, maximum)) {
                maximum = t;
            }
        }
        return maximum;
    }

}
