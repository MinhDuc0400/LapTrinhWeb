package bank.entiry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class TKGuiTien{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private int currentDept;
	private int maximumDept;
	
	@ManyToOne(targetEntity=Employee.class)
	private Employee employee;
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@ManyToOne(targetEntity=Customer.class)
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private Date creationDate;
	@PrePersist
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