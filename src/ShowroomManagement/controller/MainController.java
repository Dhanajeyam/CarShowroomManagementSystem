package ShowroomManagement.controller;

import java.sql.SQLException;
import java.util.Scanner;

import ShowroomManagement.View.ManagerDAO;

public class MainController {
    private ManagerDAO managerDAO;
    private ShowroomController showroomController;
    private CarController carController;
    private EmployeeController employeeController;

    public MainController() {
        this.managerDAO = new ManagerDAO();
        this.showroomController = new ShowroomController();
        this.carController = new CarController();
        this.employeeController = new EmployeeController();
    }

    public void start() throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("1. Login");
			System.out.println("2. Sign up");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); 

			switch (choice) {
			    case 1:
			        System.out.print("Enter email: ");
			        String loginUsername = scanner.nextLine();
			        System.out.print("Enter password: ");
			        String loginPassword = scanner.nextLine();

			        if (managerDAO.login(loginUsername, loginPassword)) {
			            System.out.println("Login successful.");
			            System.out.println("_________________");
			            // Proceed with CRUD operations
			            displayMainMenu();
			        } else {
			            System.out.println("Login failed.");
			        }
			        break;
			    case 2:
			        System.out.print("Enter new email: ");
			        String signupUsername = scanner.nextLine();
			        System.out.print("Enter new password: ");
			        String signupPassword = scanner.nextLine();

			        if (managerDAO.signup(signupUsername, signupPassword)) {
			            System.out.println("Sign up successful. You can now login.");
			            System.out.println("______________________________________");
			            System.out.println();
			            displayMainMenu();
			        } else {
			            System.out.println("Sign up failed.");
			        }
			        break;
			    default:
			        System.out.println("Invalid choice. Exiting...");
			}
		}
    }

    private void displayMainMenu() throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("1. Manage Showrooms");
			    System.out.println("2. Manage Cars");
			    System.out.println("3. Manage Employees");
			    System.out.println("4. Exit");
			    System.out.print("Enter your choice: ");
			    int choice = scanner.nextInt();
			    scanner.nextLine();

			    switch (choice) {
			        case 1:
			            showroomController.displayMenu();
			            break;
			        case 2:
			            carController.displayMenu();
			            break;
			        case 3:
			            employeeController.displayMenu();
			            break;
			        case 4:
			            System.out.println("Exiting...");
			            return;
			        default:
			            System.out.println("Invalid choice. Please try again.");
			    }
			}
		}
    }
}
