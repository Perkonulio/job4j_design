package ru.job4j.inputoutput;

import java.io.*;

public class Dir {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Professional\\IdeaProjects\\job4j_design");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %S", " " + (file.getTotalSpace()) / 1024) + "Kb");
        for (File subfile : file.listFiles()) {
            System.out.println("name : " + subfile.getAbsoluteFile().getName()
                    + " size : " + subfile.getAbsoluteFile().length() / 1024 + "Kb");
        }
    }
}
