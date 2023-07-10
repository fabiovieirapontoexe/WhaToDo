package util;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnector {
//_____________________________________________________________________

    public static final String DRIVER = "com.mysql.jdbc.Driver";

    public static final String URL = "jdbc:mysql://localhost:3306/db";
    
    public static final String USER = "root";

    public static final String PASS = "";

//_____________________________________________________________________
    
    
    
    
    
    
    
    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return (Connection) DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException error_cause) {
            throw new RuntimeException("Erro na conexão com o banco de dados", error_cause);
        }
    }

    public static void closeConnection(Connection connection) {

        try {
            if (connection != null) {

                connection.close();
            }

        } catch (SQLException error_cause) {
            throw new RuntimeException("Erro ao fechar a  conexão com o banco de dados", error_cause);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {

        try {
            if (connection != null) {

                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

        } catch (SQLException error_cause) {
            throw new RuntimeException("Erro ao fechar a  conexão com o banco de dados", error_cause);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {

        try {
            if (connection != null) {

                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }

        } catch (SQLException error_cause) {
            throw new RuntimeException("Erro ao fechar a  conexão com o banco de dados", error_cause);
        }
    }

}
