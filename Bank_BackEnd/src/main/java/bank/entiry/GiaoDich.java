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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class GiaoDich {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private int exchange;
	private Date TransactionDate;
	@ManyToOne
	@JoinColumn(name = "idTKGuiTien")
	@OnDelete(action = OnDeleteAction.CASCADE)
	TKGuiTien tkguitien;
	@ManyToOne
	@JoinColumn(name = "idTKTinDung")
	@OnDelete(action = OnDeleteAction.CASCADE)
	TKTinDung tktindung;
	@ManyToOne
	@JoinColumn(name="idEmployee")
	@OnDelete(action = OnDeleteAction.CASCADE)
	Employee employee;
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
		return TransactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		TransactionDate = transactionDate;
	}
	public TKGuiTien getTkguitien() {
		return tkguitien;
	}
	public void setTkguitien(TKGuiTien tkguitien) {
		this.tkguitien = tkguitien;
	}
	public TKTinDung getTktindung() {
		return tktindung;
	}
	public void setTktindung(TKTinDung tktindung) {
		this.tktindung = tktindung;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public GiaoDich(int id, int exchange, Date transactionDate, TKGuiTien tkguitien, TKTinDung tktindung,
			Employee employee) {
		
		this.id = id;
		this.exchange = exchange;
		TransactionDate = transactionDate;
		this.tkguitien = tkguitien;
		this.tktindung = tktindung;
		this.employee = employee;
	}
	public GiaoDich() {
		// TODO Auto-generated constructor stub
	}
	
}
	