package ru.job4j.inputoutput;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFile {
    public static List<String> filter(String list) {
        List<String> result = new ArrayList<>();
        try (BufferedReader buff = new BufferedReader(new FileReader(list))) {
            String text;
            for (text = buff.readLine(); text != null; text = buff.readLine()) {
                if (text.contains("404")) {
                    result.add(text);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String element : log) {
                out.write(element);
                out.write(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
        save(log, "404.txt");

    }
}
