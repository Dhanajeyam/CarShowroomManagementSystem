package ShowroomManagement.View;

import java.sql.*;

import ShowroomManagement.DatabaseConnection;
	
public class ManagerDAO {
    public boolean login(String username, String password) {
        try {
        	Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM manager WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean signup(String username, String password) {
        try {
        	Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO manager (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

