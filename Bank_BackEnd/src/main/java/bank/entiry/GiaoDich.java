package bank.entiry;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class GiaoDich {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private int exchange;
	
	@ManyToOne(targetEntity=Employee.class)
	private Employee employee;
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@ManyToOne(targetEntity=TKTinDung.class)
	private TKTinDung tkTinDung;


	public TKTinDung getTkTinDung() {
		return tkTinDung;
	}

	public void setTkTinDung(TKTinDung tkTinDung) {
		this.tkTinDung = tkTinDung;
	}
	
	@ManyToOne(targetEntity=TKGuiTien.class)
	private TKGuiTien tkGuiTien;

	public TKGuiTien getTkGuiTien() {
		return tkGuiTien;
	}

	public void setTkGuiTien(TKGuiTien tkGuiTien) {
		this.tkGuiTien = tkGuiTien;
	}

	private Date transactionDate;
	@PrePersist
	void createdAt() {
	this.transactionDate = new Date();
	}
	
	
	public GiaoDich(int id, int exchange, Employee employee, TKTinDung tkTinDung, TKGuiTien tkGuiTien) {
		this.id = id;
		this.exchange = exchange;
		this.employee = employee;
		this.tkGuiTien= tkGuiTien;
		this.tkTinDung= tkTinDung;
	}
	
	public GiaoDich() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getExchange() {
		return exchange;
	}
	
	public void setExchange(int exchange) {
		this.exchange = exchange;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
}
	