package ru.job4j.tdd;

import junit.framework.TestCase;
import org.junit.Test;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CinemaTest  {

    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test(expected = SessionnNotFoundException.class)
    public void whenNotFound() throws NullPointerException {
        Cinema cinema = new Cinema3D();
        cinema.add();
        List<Session> sessions = cinema.find(session -> false);
    }

    @Test(expected = AccountNotFoundException.class)
    public void whenAccountNotFound() {
        Account account = new AccountCinemaAnonym();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
    }

}