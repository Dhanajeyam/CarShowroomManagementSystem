package ShowroomManagement.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ShowroomManagement.DatabaseConnection;
import ShowroomManagement.model.Car;

public class CarDAO {
    private static final String ADD_CAR_QUERY = "INSERT INTO car (car_name, car_color, car_fuel_type, car_price, car_type, car_transmission) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CAR_QUERY = "UPDATE car SET car_name = ?, car_color = ?, car_fuel_type = ?, car_price = ?, car_type = ?, car_transmission = ? WHERE car_id = ?";
    private static final String DELETE_CAR_QUERY = "DELETE FROM car WHERE car_id= ?";

    public void addCar(Car car) {
        try {
        	Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CAR_QUERY);
            preparedStatement.setString(1, car.getCarName());
            preparedStatement.setString(2, car.getCarColor());
            preparedStatement.setString(3, car.getCarFuelType());
            preparedStatement.setInt(4, car.getCarPrice());
            preparedStatement.setString(5, car.getCarType());
            preparedStatement.setString(6, car.getCarTransmission());
            preparedStatement.executeUpdate();
            System.out.println("Car added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCar(Car car) {
        try {
        	Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAR_QUERY);
            preparedStatement.setString(1, car.getCarName());
            preparedStatement.setString(2, car.getCarColor());
            preparedStatement.setString(3, car.getCarFuelType());
            preparedStatement.setInt(4, car.getCarPrice());
            preparedStatement.setString(5, car.getCarType());
            preparedStatement.setString(6, car.getCarTransmission());
            preparedStatement.setInt(7, car.getCarId());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Car updated successfully.");
            } else {
                System.out.println("Car not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(int deleteCarId) {
        try {
        	Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR_QUERY);
            preparedStatement.setInt(1, deleteCarId);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Car deleted successfully.");
            } else {
                System.out.println("Car not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void DisplayCars() throws SQLException {
  	  Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM car";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	System.out.println("Car Id: " + resultSet.getInt("car_id"));
            	System.out.println("Car Name: " + resultSet.getString("car_name"));
                System.out.println("Car Colour: " + resultSet.getString("car_color"));
                System.out.println("Car Fuel Type: " + resultSet.getString("car_fuel_type"));
                System.out.println("Car Price: " + resultSet.getInt("car_price"));
                System.out.println("Car Type: " + resultSet.getString("car_type"));
                System.out.println("Car Transmissione: " + resultSet.getString("car_transmission"));
                System.out.println("-----------------------------------------");
            }
  	}

    
}

