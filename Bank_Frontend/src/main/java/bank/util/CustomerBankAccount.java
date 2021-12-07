package bank.util;

import bank.entiry.Customer;
import bank.entiry.TKGuiTien;
import bank.entiry.TKTinDung;

public class CustomerBankAccount {
	private Customer customer;
	private TKGuiTien tkguitien;
	private TKTinDung tktindung;
	public CustomerBankAccount(Customer customer, TKGuiTien tkguitien, TKTinDung tktindung) {
		
		this.customer = customer;
		this.tkguitien = tkguitien;
		this.tktindung = tktindung;
	}
	public CustomerBankAccount() {
		// TODO Auto-generated constructor stub
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	
}
