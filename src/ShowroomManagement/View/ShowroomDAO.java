package ShowroomManagement.View;

import java.sql.*;

import ShowroomManagement.DatabaseConnection;
import ShowroomManagement.model.Showroom;
public class ShowroomDAO {
    public void addShowroom(Showroom showroom) {
        try {
        	Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO showroom (showroom_name, showroom_address, total_employees, manager_name) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, showroom.getShowroom_name());
            preparedStatement.setString(2, showroom.getShowroom_address());
            preparedStatement.setInt(3, showroom.getTotal_employees());
            preparedStatement.setString(4, showroom.getManager_name());
            preparedStatement.execute();
            System.out.println("Showroom added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateShowroom(Showroom showroom) {
        try {
        	Connection connection = DatabaseConnection.getConnection();
            String query = "UPDATE showroom SET showroom_address = ?, total_employees = ?, manager_name = ? WHERE showroom_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, showroom.getShowroom_address());
            preparedStatement.setInt(2, showroom.getTotal_employees());
            preparedStatement.setString(3, showroom.getManager_name());
            preparedStatement.setString(4, showroom.getShowroom_name());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Showroom updated successfully.");
            } else {
                System.out.println("Showroom not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteShowroom(String showroomName) {
        try{
        	Connection connection = DatabaseConnection.getConnection();
            String query = "DELETE FROM showroom WHERE showroom_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, showroomName);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Showroom deleted successfully.");
            } else {
                System.out.println("Showroom not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void displayShowroom() throws SQLException {
    	  Connection connection = DatabaseConnection.getConnection();
          String query = "SELECT * FROM showroom";
          PreparedStatement preparedStatement = connection.prepareStatement(query);
              ResultSet resultSet = preparedStatement.executeQuery();
              while (resultSet.next()) {
              	System.out.println("Showroom Name: " + resultSet.getString("showroom_name"));
                  System.out.println("Showroom Address: " + resultSet.getString("showroom_address"));
                  System.out.println("Total Employees: " + resultSet.getInt("total_employees"));
                  System.out.println("Manager Name: " + resultSet.getString("manager_name"));
                  System.out.println("-----------------------------------------");
              }
    	}

}

