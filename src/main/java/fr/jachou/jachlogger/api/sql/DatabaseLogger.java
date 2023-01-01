package fr.jachou.jachlogger.api.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseLogger {

    private String database;
    private String username;
    private String password;
    private String url;
    private DatabaseType databaseType;
    private int port;
    private boolean isActivate = false;
    private Connection connection;

    public DatabaseLogger(String database, String username, String password, String url, int port, DatabaseType databaseType) {
        this.database = database;
        this.username = username;
        this.password = password;
        this.url = url;
        this.port = port;
        this.databaseType = databaseType;

        // Conection
        if (dbConnection()) {
            isActivate = true;
        } else { isActivate = false; }
    }

    private boolean dbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String str;

            switch (databaseType) {
                case MariaDB:
                    str = "mariadb";
                    break;
                case MySQL:
                    str = "mysql";
                    break;
                case PostgreSQL:
                    str = "postgresql";
                    break;
                default:
                    str = null;
            }

             connection = DriverManager.getConnection(
                    "jdbc:"+str+"://"+url+":"+port+"/"+database+", "+username+", "+password+"");

            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
