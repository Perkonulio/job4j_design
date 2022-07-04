package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public interface Cinema {
    void add();

    void add(Session session);
    Ticket buy(Account account, int number, int number2, Calendar date);
    List<Session> find(Predicate<Session> predicate);
}
