package ru.job4j.jdbc;

import org.h2.engine.Setting;
import ru.job4j.inputoutput.Config;
import ru.job4j.inputoutput.Settings;
import ru.job4j.set.Set;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.postgresql.Driver");
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        InputStream io = loader.getResourceAsStream("./app.properties");
        settings.load(io);
        try (Connection connection = DriverManager.getConnection(settings.getValue("url"),
                        settings.getValue("login"), settings.getValue("password"))) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
