package ru.job4j.jdbc;

import org.h2.table.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {


    private Connection connection;
    private Statement statement;
    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            statement.close();
            connection.close();
        }
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password"));
        statement = connection.createStatement();
    }

    public void createTable(String tableName) throws SQLException {
        statement.executeUpdate("create table " + tableName);
    }

    public void dropTable(String tableName) throws SQLException {
        statement.executeUpdate("drop table " + tableName);
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        statement.executeUpdate("alter table " + tableName + " add  " + columnName + "  " + type);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        statement.executeUpdate("alter table " + tableName + "drop column " + columnName);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        statement.executeUpdate("alter table" + tableName + " rename column " + columnName + " to " + newColumnName);
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }
}
