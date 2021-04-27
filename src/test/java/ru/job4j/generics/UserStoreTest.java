package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class UserStoreTest {

    @Test
    public void whenReplaceModel() {
        UserStore userStore = new UserStore();
        userStore.add(new User("123"));
        assertThat(userStore.replace("123", new User("345")), is(true));
    }

    @Test
    public void whenDeleteModel() {
        UserStore userStore = new UserStore();
        userStore.add(new User("123"));
        userStore.delete("123");
        assertNull(userStore.findById("123"));
    }
}