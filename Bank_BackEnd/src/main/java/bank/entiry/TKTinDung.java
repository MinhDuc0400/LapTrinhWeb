package bank.entiry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class TKTinDung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private int currentBalance;
	private int minimumBalance;
	private float interest;
	private int firstSend;
	
	
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
	
	public TKTinDung(int id, int currentBalance, int minimumBalance, float interest, int firstSend, Employee employee, Customer customer) {
		this.id = id;
		this.currentBalance = currentBalance;
		this.minimumBalance = minimumBalance;
		this.interest = interest;
		this.firstSend = firstSend;
		this.employee = employee;
		this.customer = customer;
	}
	
	public TKTinDung() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCurrentBalance() {
		return currentBalance;
	}
	
	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	public int getMinimumBalance() {
		return minimumBalance;
	}
	
	public void setMinimumBalance(int minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
	public float getInterest() {
		return interest;
	}
	
	public void setInterest(float interest) {
		this.interest = interest;
	}
	
	public int getFirstSend() {
		return firstSend;
	}
	
	public void setFirstSend(int firstSend) {
		this.firstSend = firstSend;
	}
}
