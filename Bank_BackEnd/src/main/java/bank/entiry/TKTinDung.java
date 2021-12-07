package bank.entiry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class TKTinDung {
	@Id
	private String idCardNumber;
	private Date createDate;
	private double dept;
	private double maxiumDept;
	@OneToOne(targetEntity=Customer.class)
	@JoinColumn(name = "idCustomer")
	private Customer customer;
	@ManyToOne(targetEntity=Employee.class)
	@JoinColumn(name = "idEmployeee")
	private Employee employee;
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
	public double getDept() {
		return dept;
	}
	public void setDept(double dept) {
		this.dept = dept;
	}
	public double getMaxiumDept() {
		return maxiumDept;
	}
	public void setMaxiumDept(double maxiumDept) {
		this.maxiumDept = maxiumDept;
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
	public TKTinDung() {
		// TODO Auto-generated constructor stub
	}
	public TKTinDung(String idCardNumber, Date createDate, double dept, double maxiumDept, Customer customer,
			Employee employee) {
		super();
		this.idCardNumber = idCardNumber;
		this.createDate = createDate;
		this.dept = dept;
		this.maxiumDept = maxiumDept;
		this.customer = customer;
		this.employee = employee;
	}
	
}
