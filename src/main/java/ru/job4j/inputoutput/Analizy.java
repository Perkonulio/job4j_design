package ru.job4j.inputoutput;

import java.io.*;

public class Analizy {
    public void unavailable(String path, String target) {
        try (BufferedReader buff = new BufferedReader(new FileReader(path));
             PrintWriter print = new PrintWriter(new FileOutputStream(target))) {
            boolean flag = false;
            for (String txt = buff.readLine(); txt != null; txt = buff.readLine()) {
                String[] text = txt.split(" ");
                if (!flag && (text[0].equals("400") || text[0].equals("500"))) {
                    flag = true;
                    print.write(text[1] + ";");
                } else if (flag && !(text[0].equals("400") || text[0].equals("500"))) {
                    flag = false;
                    print.write(text[1] + ";" + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
