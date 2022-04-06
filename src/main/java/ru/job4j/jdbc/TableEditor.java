package ru.job4j.jdbc;

import org.h2.table.Table;

import java.sql.Connection;
import java.util.Properties;

public class TableEditor {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        connection = null;
    }

    public void createTable(String tableName) {

    }

    public void dropTable() {

    }

    public void addColumn(String tableName, String columnName, String type) {

    }
}
