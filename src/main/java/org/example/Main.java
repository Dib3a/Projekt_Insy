package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    private static final String url = "jdbc:postgresql://aws-0-eu-central-1.pooler.supabase.com:5432/postgres";
    private static final String user = "postgres.quumbrmumjrkybgyvvgq";
    private static final String password = "Passwordprdatabase123!";

    public static void main(String[] args) {

        String query = "SELECT title, description, published_at FROM books ORDER BY title";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("Books   title:");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("title"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    }




