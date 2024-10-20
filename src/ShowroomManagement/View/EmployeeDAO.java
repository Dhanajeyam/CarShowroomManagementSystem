package ShowroomManagement.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ShowroomManagement.DatabaseConnection;
import ShowroomManagement.model.Employee;

public class EmployeeDAO {
    private static final String ADD_EMPLOYEE_QUERY = "INSERT INTO employees (emp_name, emp_age, emp_department, showroom_name) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_EMPLOYEE_QUERY = "UPDATE employees SET emp_name = ?, emp_age = ?, emp_department = ?, showroom_name = ? WHERE emp_id = ?";
    private static final String DELETE_EMPLOYEE_QUERY = "DELETE FROM employees WHERE emp_id = ?";

    public void addEmployee(Employee employee) {
        try{
        	Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_EMPLOYEE_QUERY);
            preparedStatement.setString(1, employee.getEmp_name());
            preparedStatement.setInt(2, employee.getEmp_age());
            preparedStatement.setString(3, employee.getEmp_department());
            preparedStatement.setString(4, employee.getShowroom_name());
            preparedStatement.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        try {
        	Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_QUERY);
            preparedStatement.setString(1, employee.getEmp_name());
            preparedStatement.setInt(2, employee.getEmp_age());
            preparedStatement.setString(3, employee.getEmp_department());
            preparedStatement.setString(4, employee.getShowroom_name());
            preparedStatement.setInt(5, employee.getEmp_id());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int deleteEmpId) {
        try {
        	Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_QUERY);
            preparedStatement.setInt(1, deleteEmpId);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    

	public void displayEmployee() throws SQLException {
  	  Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM employees";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	System.out.println("Employee ID: " + resultSet.getInt("emp_id"));
                System.out.println("Employee Name: " + resultSet.getString("emp_name"));
                System.out.println("Employee Age: " + resultSet.getInt("emp_age"));
                System.out.println("Employee Department: " + resultSet.getString("emp_department"));
                System.out.println("Showroom Name: " + resultSet.getString("showroom_name"));
                System.out.println("-----------------------------------------");
            }
  	}

	

}
