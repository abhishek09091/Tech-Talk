package pojos;

public class Employee {
	String employeeEmail;
	String employeeName;
	String password;
	
	
	public Employee() {
		
	}
	
	
	public Employee(String employeeEmail, String employeeName, String password) {
		super();
		this.employeeEmail = employeeEmail;
		this.employeeName = employeeName;
		this.password = password;
	}


	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
