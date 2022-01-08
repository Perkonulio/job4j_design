package ru.job4j.inputoutput;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenResultisNotEmpty() throws IOException {
        File input = folder.newFile("input.log");
        File output = folder.newFile("output.txt");
        try (PrintWriter print = new PrintWriter(input)) {
            print.println("200 10:56:01\n" +
                    "200 10:57:01\n" +
                    "400 10:58:01\n" +
                    "200 10:59:01\n" +
                    "500 11:01:02\n" +
                    "200 11:02:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(input.toString(), output.toString());
        StringBuilder string = new StringBuilder();
        try (BufferedReader buff = new BufferedReader(new FileReader(output))) {
            string.append(buff.readLine()).append("\n");
            string.append(buff.readLine());
        }
        assertThat(string.toString(), is("10:58:01;10:59:01;\n" +
                "11:01:02;11:02:02;"));
    }

    @Test
    public void whenResultisEmpty() throws IOException {
        File input = folder.newFile("input.log");
        File output = folder.newFile("output.txt");
        try (PrintWriter print = new PrintWriter(input)) {
            print.println("200 10:56:01\n" +
                    "200 10:57:01\n" +
                    "\n" +
                    "200 10:59:01\n" +
                    "500 11:01:02\n" +
                    "200 11:02:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(input.toString(), output.toString());
        StringBuilder string = new StringBuilder();
        try (BufferedReader buff = new BufferedReader(new FileReader(output))) {
            string.append(buff.readLine());
        }
        assertThat(string.toString(), is("11:01:02;11:02:02;"));
    }
}