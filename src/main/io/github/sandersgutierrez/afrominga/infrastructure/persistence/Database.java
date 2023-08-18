package io.github.sandersgutierrez.afrominga.infrastructure.persistence;

import io.github.sandersgutierrez.afrominga.infrastructure.Configuration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String TEMPLATE_URL = "jdbc:%s://%s:%s/%s";

    public static Connection connect() throws IOException, SQLException {
        final String DRIVER = Configuration.get("database.db-driver");
        final String DB_HOST = Configuration.get("database.db-host");
        final String DB_PORT = Configuration.get("database.db-port");
        final String DB_USER = Configuration.get("database.db-user");
        final String DB_PASS = Configuration.get("database.db-pass");
        final String DB_NAME = Configuration.get("database.db-name");
        final String URL = String.format(TEMPLATE_URL, DRIVER, DB_HOST, DB_PORT, DB_NAME);

        return DriverManager.getConnection(URL, DB_USER, DB_PASS);
    }
}
