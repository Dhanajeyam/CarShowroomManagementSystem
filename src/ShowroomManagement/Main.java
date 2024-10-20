package ShowroomManagement;
import java.sql.SQLException;

import ShowroomManagement.controller.MainController;

public class Main {
    public static void main(String[] args) throws SQLException {
        MainController mainController = new MainController();
        mainController.start();
        DatabaseConnection.closeConnection();
    }
}
