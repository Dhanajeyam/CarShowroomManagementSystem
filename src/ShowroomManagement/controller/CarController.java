package ShowroomManagement.controller;

import java.sql.SQLException;
import java.util.*;

import ShowroomManagement.View.CarDAO;
import ShowroomManagement.model.Car;

public class CarController {
    private CarDAO carDAO;

    public CarController() {
        this.carDAO = new CarDAO();
    }

    public void displayMenu() throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("\nCar Management Menu");
			    System.out.println("1. Add Car");
			    System.out.println("2. Update Car");
			    System.out.println("3. Delete Car");
			    System.out.println("4. Display Cars"); 
			    System.out.println("5. Back to Main Menu");
			    System.out.print("Enter your choice: ");
			    int choice = scanner.nextInt();
			    scanner.nextLine(); 

			    switch (choice) {
			        case 1:
			        	System.out.print("Enter car ID: ");
			            int carId= scanner.nextInt();
			            scanner.nextLine();
			            System.out.print("Enter car name: ");
			            String carName = scanner.nextLine();
			            System.out.print("Enter car color: ");
			            String carColor = scanner.nextLine();
			            System.out.print("Enter car fuel type (Petrol - Diesel - Electric): ");
			            String carFuelType = scanner.nextLine();
			            System.out.print("Enter car price: ");
			            int carPrice = scanner.nextInt();
			            scanner.nextLine();
			            System.out.print("Enter car type (Sedan - Hatchbag - Suv): ");
			            String carType = scanner.nextLine();
			            System.out.print("Enter car transmission (Manual - Automatic): ");
			            String carTransmission = scanner.nextLine();
			            Car newCar = new Car(carId, carName, carColor, carFuelType, carPrice, carType, carTransmission);
			            carDAO.addCar(newCar);
			            break;
			        case 2:
			        	System.out.print("Enter car ID: ");
			            int updateEmpId = scanner.nextInt();
			            scanner.nextLine(); 
			            System.out.print("Enter new car name : ");
			            String updateCarName = scanner.nextLine();
			            System.out.print("Enter new car color: ");
			            String updateCarColor = scanner.nextLine();
			            System.out.print("Enter new car fuel type (Petrol - Diesel - Electric): ");
			            String updateCarFuelType = scanner.nextLine();
			            System.out.print("Enter new car price: ");
			            int updateCarPrice = scanner.nextInt();
			            scanner.nextLine();
			            System.out.print("Enter new car type (Sedan - Hatchbag - Suv): ");
			            String updateCarType = scanner.nextLine();
			            System.out.print("Enter new car transmission (Manual - Automatic): ");
			            String updateCarTransmission = scanner.nextLine();
			            Car updatedCar = new Car(updateEmpId, updateCarName, updateCarColor, updateCarFuelType, updateCarPrice, updateCarType, updateCarTransmission);
			            carDAO.updateCar(updatedCar);
			            break;
			        case 3:
			            System.out.print("Enter car id to delete: ");
			            int deleteCarId = scanner.nextInt();
			            carDAO.deleteCar(deleteCarId);
			            break;
			        case 4:
			        	carDAO.DisplayCars();
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
