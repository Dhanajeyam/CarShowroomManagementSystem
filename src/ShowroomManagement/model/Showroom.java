package ShowroomManagement.model;
public class Showroom {
    private String showroom_name;
    private String showroom_address;
    private int total_employees;
    private String manager_name;

    public Showroom(String showroomName, String showroomAddress, int totalEmployees, String managerName) {
		this.showroom_name = showroomName;
		this.showroom_address = showroomAddress;
		this.total_employees = totalEmployees;
		this.manager_name = managerName;
	}

	public String getShowroom_name() {
        return showroom_name;
    }

    public void setShowroom_name(String showroom_name) {
        this.showroom_name = showroom_name;
    }

    public String getShowroom_address() {
        return showroom_address;
    }

    public void setShowroom_address(String showroom_address) {
        this.showroom_address = showroom_address;
    }

    public int getTotal_employees() {
        return total_employees;
    }

    public void setTotal_employees(int total_employees) {
        this.total_employees = total_employees;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    @Override
    public String toString() {
        return "Showroom{" +
                "showroom_name='" + showroom_name + '\'' +
                ", showroom_address='" + showroom_address + '\'' +
                ", total_employees=" + total_employees +
                ", manager_name='" + manager_name + '\'' +
                '}';
    }
}
