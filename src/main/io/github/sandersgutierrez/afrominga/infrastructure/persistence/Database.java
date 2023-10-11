package io.github.sandersgutierrez.afrominga.infrastructure.persistence;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    public static Connection connect() throws SQLException {
        return DataSource.getConnection();
    }
}
