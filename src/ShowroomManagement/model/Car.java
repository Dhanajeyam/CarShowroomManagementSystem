package ShowroomManagement.model;

public class Car {
	private int carId;
    private String carName;
    private String carColor;
    private String carFuelType;
    private int carPrice;
    private String carType;
    private String carTransmission;

    public Car(int carId, String carName, String carColor, String carFuelType, int carPrice, String carType, String carTransmission) {
    	this.carId = carId;
        this.carName = carName;
        this.carColor = carColor;
        this.carFuelType = carFuelType;
        this.carPrice = carPrice;
        this.carType = carType;
        this.carTransmission = carTransmission;
    }
    
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarFuelType() {
        return carFuelType;
    }

    public void setCarFuelType(String carFuelType) {
        this.carFuelType = carFuelType;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarTransmission() {
        return carTransmission;
    }

    public void setCarTransmission(String carTransmission) {
        this.carTransmission = carTransmission;
    }

    @Override
    public String toString() {
        return "Car{" +
        		"carId=" + carId +
                "carName='" + carName + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carFuelType='" + carFuelType + '\'' +
                ", carPrice=" + carPrice +
                ", carType='" + carType + '\'' +
                ", carTransmission='" + carTransmission + '\'' +
                '}';
    }
}

