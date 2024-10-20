package ShowroomManagement.controller;

import java.sql.SQLException;
import java.util.Scanner;

import ShowroomManagement.View.EmployeeDAO;
import ShowroomManagement.model.Employee;

public class EmployeeController {
    private EmployeeDAO employeeDAO;

    public EmployeeController() {
        this.employeeDAO = new EmployeeDAO();
    }

    public void displayMenu() throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("\nEmployee Management Menu");
			    System.out.println("1. Add Employee");
			    System.out.println("2. Update Employee");
			    System.out.println("3. Delete Employee");
			    System.out.println("4. Display Employee");
			    System.out.println("5. Back to Main Menu");
			    System.out.print("Enter your choice: ");
			    int choice = scanner.nextInt();
			    scanner.nextLine(); 

			    switch (choice) {
			        case 1:
			            System.out.print("Enter employee ID: ");
			            int empId = scanner.nextInt();
			            scanner.nextLine(); 
			            System.out.print("Enter employee name: ");
			            String empName = scanner.nextLine();
			            System.out.print("Enter employee age: ");
			            int empAge = scanner.nextInt();
			            scanner.nextLine(); 
			            System.out.print("Enter employee department: ");
			            String empDepartment = scanner.nextLine();
			            System.out.print("Enter showroom name: ");
			            String showroomName = scanner.nextLine();
			            Employee newEmployee = new Employee(empId, empName, empAge, empDepartment, showroomName);
			            employeeDAO.addEmployee(newEmployee);
			            break;
			        case 2:
			            System.out.print("Enter employee ID to update: ");
			            int updateEmpId = scanner.nextInt();
			            scanner.nextLine(); 
			            System.out.print("Enter new employee name: ");
			            String updateEmpName = scanner.nextLine();
			            System.out.print("Enter new employee age: ");
			            int updateEmpAge = scanner.nextInt();
			            scanner.nextLine(); 
			            System.out.print("Enter new employee department: ");
			            String updateEmpDepartment = scanner.nextLine();
			            System.out.print("Enter new showroom name: ");
			            String updateShowroomName = scanner.nextLine();
			            Employee updatedEmployee = new Employee(updateEmpId, updateEmpName, updateEmpAge, updateEmpDepartment, updateShowroomName);
			            employeeDAO.updateEmployee(updatedEmployee);
			            break;
			        case 3:
			            System.out.print("Enter employee ID to delete: ");
			            int deleteEmpId = scanner.nextInt();
			            scanner.nextLine();
			            employeeDAO.deleteEmployee(deleteEmpId);
			            break;
			        case 4:
			        	employeeDAO.displayEmployee();
			        	break;
			        case 5:
			            return;
			        default:
			            System.out.println("Invalid choice. Please try again.");
			    }
			}
		}
    }
}

