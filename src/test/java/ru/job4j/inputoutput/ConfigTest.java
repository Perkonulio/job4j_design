package ru.job4j.inputoutput;

import junit.framework.TestCase;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConfigTest{
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenPairIlleagalException() {
        String path = "./data/app2.properties";
        Config config = new Config(path);
        config.load();
    }
}