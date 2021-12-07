package bank.entiry;

import java.util.Date;


public class Customer {
	private int id ;
	private String idNumber;
	private String name;
	private Date dateOfBirth;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer(int id, String idNumber, String name, Date dateOfBirth, String address) {
		
		this.id = id;
		this.idNumber = idNumber;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}
	public Customer() {
		
	}
	
	
	
	
}
