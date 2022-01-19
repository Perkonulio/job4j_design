package ru.job4j.inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader buff = new BufferedReader(new FileReader(this.path))) {
            for (String txt = buff.readLine(); txt != null; txt = buff.readLine()) {
                if (!txt.contains("#") & txt.contains("=")) {
                    String[] splitText = txt.split("=");
                    if (splitText[0].equals("") || splitText[1].equals("")) {
                        throw new IllegalArgumentException();
                    } else {
                        values.put(splitText[0], splitText[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader buff = new BufferedReader(new FileReader(this.path))) {
            buff.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public String value(String key) {
        String text = null;
        if (values.containsKey(key)) {
            text = values.get(key);
        }
        return text;
    }
}
