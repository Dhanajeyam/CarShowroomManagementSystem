package ShowroomManagement.controller;

import java.sql.SQLException;
import java.util.Scanner;

import ShowroomManagement.View.ShowroomDAO;
import ShowroomManagement.model.Showroom;

public class ShowroomController {
    private ShowroomDAO showroomDAO;

    public ShowroomController() {
        this.showroomDAO = new ShowroomDAO();
    }

    public void displayMenu() throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("\nShowroom Management Menu");
			    System.out.println("1. Add Showroom");
			    System.out.println("2. Update Showroom");
			    System.out.println("3. Delete Showroom");
			    System.out.println("4. Display Showroom");
			    System.out.println("5. Back to Main Menu");
			    System.out.print("Enter your choice: ");
			    int choice = scanner.nextInt();
			    scanner.nextLine();

			    switch (choice) {
			        case 1:
			        	System.out.println();
			            System.out.print("Enter showroom name: ");
			            String showroomName = scanner.nextLine();
			            System.out.print("Enter showroom address: ");
			            String showroomAddress = scanner.nextLine();
			            System.out.print("Enter total employees: ");
			            int totalEmployees = scanner.nextInt();
			            scanner.nextLine();
			            System.out.print("Enter manager name: ");
			            String managerName = scanner.nextLine();
			            Showroom newShowroom = new Showroom(showroomName, showroomAddress, totalEmployees, managerName);
			            showroomDAO.addShowroom(newShowroom);
			            break;
			        case 2:
			        	System.out.println();
			            System.out.print("Enter showroom name to update: ");
			            String updateShowroomName = scanner.nextLine();
			            System.out.print("Enter new showroom address: ");
			            String updateShowroomAddress = scanner.nextLine();
			            System.out.print("Enter new total employees: ");
			            int updateTotalEmployees = scanner.nextInt();
			            scanner.nextLine();
			            System.out.print("Enter new manager name: ");
			            String updateManagerName = scanner.nextLine();
			            Showroom updatedShowroom = new Showroom(updateShowroomName, updateShowroomAddress, updateTotalEmployees, updateManagerName);
			            showroomDAO.updateShowroom(updatedShowroom);
			            break;
			        case 3:
			        	System.out.println();
			            System.out.print("Enter showroom name to delete: ");
			            String deleteShowroomName = scanner.nextLine();
			            showroomDAO.deleteShowroom(deleteShowroomName);
			            break;
			        case 4:
			        	System.out.println();
			        	showroomDAO.displayShowroom();
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
