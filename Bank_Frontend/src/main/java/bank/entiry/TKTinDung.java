package bank.entiry;

import java.util.Date;


public class TKTinDung {
	
	private String idCardNumber;
	private Date createDate;
	private double dept;
	private double maxiumDept;
	

	private Customer customer;
	
	
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
