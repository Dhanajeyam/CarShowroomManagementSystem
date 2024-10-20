package ShowroomManagement.model;

public class Employee {
    private int emp_id;
    private String emp_name;
    private int emp_age;
    private String emp_department;
    private String showroom_name;

    public Employee(int empId, String empName, int empAge, String empDepartment, String showroomName) {
		this.emp_id = empId;
		this.emp_name = empName;
		this.emp_age = empAge;
		this.emp_department = empDepartment;
		this.showroom_name = showroomName;
	}

	public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_department() {
        return emp_department;
    }

    public void setEmp_department(String emp_department) {
        this.emp_department = emp_department;
    }

    public String getShowroom_name() {
        return showroom_name;
    }

    public void setShowroom_name(String showroom_name) {
        this.showroom_name = showroom_name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_age=" + emp_age +
                ", emp_department='" + emp_department + '\'' +
                ", showroom_name='" + showroom_name + '\'' +
                '}';
    }
}
