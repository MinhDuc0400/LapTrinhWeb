package bank.entiry;

import java.util.Date;


public class TKGuiTien{
	private int id ;
	private int currentDept;
	private int maximumDept;
	
	private Employee employee;
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private Date creationDate;

	void createdAt() {
	this.creationDate = new Date();
	}
	
	public TKGuiTien(int id, int currentDept, int maximumDept, Employee employee, Customer customer) {
		this.id = id;
		this.currentDept = currentDept;
		this.maximumDept = maximumDept;
		this.employee = employee;
		this.customer = customer;
	}
	
	public TKGuiTien() {
		
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCurrentDept() {
		return currentDept;
	}
	
	public void setCurrentDept(int currentDept) {
		this.currentDept = currentDept;
	}
	
	public int getMaximumDept() {
		return maximumDept;
	}
	
	public void setMaximumDept(int maximumDept) {
		this.maximumDept = maximumDept;
	}
}