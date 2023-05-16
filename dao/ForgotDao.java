package example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import example.model.UserAccount;

public class ForgotDao {

    public String validate(UserAccount useraccount) throws ClassNotFoundException {
        String s = null;

	Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/users", "root", "mysql");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select password from useraccount where email = ? and secretcode = ? ")) {
            preparedStatement.setString(1, useraccount.getEmail());
            preparedStatement.setString(2, useraccount.getSecretcode());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
             {  
                 //String n = rs.getString("email");  
                 //String nm = rs.getString("secretcode");  
                 s = rs.getString("password");   
                // System.out.println("Password is:"+s); 
       
             } }
            catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        
        return s;

    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}