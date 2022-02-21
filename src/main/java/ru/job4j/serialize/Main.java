package ru.job4j.serialize;

import java.io.*;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Contact contact = new Contact(333, "+3535");

        File tmp = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fileOutputStream = new FileOutputStream(tmp);
             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
            oos.writeObject(contact);
        }

        try (FileInputStream files = new FileInputStream(tmp);
             ObjectInputStream obj = new ObjectInputStream(files)) {
            Contact contacto = (Contact) obj.readObject();
            System.out.println(contacto);
        }

        System.out.println(contact);


    }
}
