package org.example.db;

public class DbConfig {

    // JDBC URL prisijungimui prie MySQL
    // allowPublicKeyRetrieval=true reikalinga MySQL 8+ versijoms
    public static final String URL =
            "jdbc:mysql://localhost:3306/komunalines_paslaugos"
                    + "?useSSL=false"
                    + "&serverTimezone=UTC"
                    + "&allowPublicKeyRetrieval=true";

    // MySQL vartotojas
    public static final String USER = "root";

    // MySQL slaptažodis
    public static final String PASSWORD = "pi24sn";
}
