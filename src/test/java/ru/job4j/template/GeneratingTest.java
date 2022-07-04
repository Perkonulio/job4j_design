package ru.job4j.template;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GeneratingTest {

    @Test
    public void whenGeneratorIsWork() {
        String expected = "";
        String temp = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        Generator generator = new Generating(temp, map);
        assertThat(generator.produce(temp, map), is(expected));
    }

    @Test(expected = NotFoundException.class)
    public void whenGeneratorNotFindKeyInsideMap() throws NotFoundException {
        String temp = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        Generator generator = new Generating(temp, map);
        generator.consistOf();
    }

    @Test(expected = UnhandledKeysException.class)
    public void whenGeneratorInsideMapOutKeys() throws UnhandledKeysException {
        String temp = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        Generator generator = new Generating(temp, map);
        generator.impossibleKey();
    }
}