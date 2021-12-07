package bank.entiry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class TKGuiTien{
	@Id
	private String idCardNumber;
	private Date createDate;
	private double currentBalance;
	private double miniumBalance;
	private double interset;
	private double firstSend;
	@OneToOne(targetEntity=Customer.class)
	@JoinColumn(name = "idCustomer")
	private Customer customer;
	@ManyToOne(targetEntity=Employee.class)
	@JoinColumn(name = "idEmployeee")
	private Employee employee;
	public TKGuiTien(String idCardNumber, Date createDate, double currentBalance, double miniumBalance, double interset,
			double firstSend, Customer customer, Employee employee) {
		super();
		this.idCardNumber = idCardNumber;
		this.createDate = createDate;
		this.currentBalance = currentBalance;
		this.miniumBalance = miniumBalance;
		this.interset = interset;
		this.firstSend = firstSend;
		this.customer = customer;
		this.employee = employee;
	}
	public TKGuiTien() {
		super();
	}
	public String getIdCardNumber() {
		return idCardNumber;
	}
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public double getMiniumBalance() {
		return miniumBalance;
	}
	public void setMiniumBalance(double miniumBalance) {
		this.miniumBalance = miniumBalance;
	}
	public double getInterset() {
		return interset;
	}
	public void setInterset(double interset) {
		this.interset = interset;
	}
	public double getFirstSend() {
		return firstSend;
	}
	public void setFirstSend(double firstSend) {
		this.firstSend = firstSend;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}