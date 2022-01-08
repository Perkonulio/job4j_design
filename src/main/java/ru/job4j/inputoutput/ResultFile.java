package ru.job4j.inputoutput;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class ResultFile {
    public static void main(String[] args) {
        try(FileOutputStream file = new FileOutputStream("result.txt")) {
            Matrix matrix = new Matrix();
            file.write(Arrays.deepToString(matrix.multiple(10)).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
