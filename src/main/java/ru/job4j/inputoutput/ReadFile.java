package ru.job4j.inputoutput;

import jdk.jshell.spi.ExecutionControlProvider;

import java.io.*;

public class ReadFile {
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
