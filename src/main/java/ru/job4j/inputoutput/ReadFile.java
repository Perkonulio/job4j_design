package ru.job4j.inputoutput;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
