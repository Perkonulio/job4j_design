package ru.job4j.inputoutput;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("even.txt")){
            StringBuilder stringBuilder = new StringBuilder();
            int read;
            while((read = fileInputStream.read()) != -1) {
                stringBuilder.append((char) read);
            }
            String[] list = stringBuilder.toString().split(System.lineSeparator());
            for (String element: list) {
                System.out.println(Integer.parseInt(element) % 2 == 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
