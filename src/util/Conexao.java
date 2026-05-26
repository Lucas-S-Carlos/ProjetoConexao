package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "root";
        String password = "your_password";

        try {
            // Load the driver (optional in modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            // Connect to database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");

            // Example Query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table_name");
            
            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}