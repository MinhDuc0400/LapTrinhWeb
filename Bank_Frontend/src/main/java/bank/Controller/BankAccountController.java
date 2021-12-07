package bank.Controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import bank.entiry.Customer;
import bank.entiry.Employee;
import bank.entiry.TKGuiTien;
import bank.entiry.TKTinDung;
import bank.util.CustomerBankAccount;

@Controller
public class BankAccountController {
	RestTemplate rest = new RestTemplate();
	@GetMapping("/bankaccount")
	public String bankaccountcategory(Model model)
	{
		List<Customer> listcustomer=Arrays.asList(rest.getForObject("http://localhost:8080/customer/recent", Customer[].class));
		//List<TKGuiTien> listTKGuiTien=new ArrayList<>();
		//List<TKTinDung>  listTKTinDung=new ArrayList<>();
		List<CustomerBankAccount> listcustomerbankaccount=new ArrayList<>();
		for(int i=0;i<listcustomer.size();i++)
		{
			TKTinDung tkTindung=rest.getForObject("http://localhost:8080/tktindung/findbycustomer/{id}", TKTinDung.class,listcustomer.get(i).getId());
			TKGuiTien tkGuiTien=rest.getForObject("http://localhost:8080/tkguitien/findbycustomer/{id}", TKGuiTien.class,listcustomer.get(i).getId());
			CustomerBankAccount account=new CustomerBankAccount(listcustomer.get(i),tkGuiTien, tkTindung);
			 listcustomerbankaccount.add(account);
		}
		model.addAttribute("listaccount",listcustomerbankaccount);
		
		return "bankaccount";
	}
	@GetMapping("/detailtkguitien/{id}")
	public String detailtkguitien(@PathVariable("id") String id,Model model)
	{
		
		TKGuiTien TKGuiTien=rest.getForObject("http://localhost:8080/tkguitien/detail/{id}", TKGuiTien.class,id);
		model.addAttribute("tkguitien",TKGuiTien);
		return "tkguitiendetail";
	}
	@GetMapping("/createtkguitien/{id}")
	public String creatTKGuitien(@PathVariable("id") String idcustomer,Model model,HttpServletRequest req)
	{
		
		Customer customer=rest.getForObject("http://localhost:8080/customer/findcustomerbyid/{id}", Customer.class,idcustomer);
		req.getSession().setAttribute("customer", customer);
		TKGuiTien tkguitien=new TKGuiTien();
		model.addAttribute("tkguitien",tkguitien);
		return "TKGuiTienCreate";
	}
	@PostMapping("/createtkguitien")
	public String createTkGuiTien(TKGuiTien tkguitien,HttpServletRequest req)
	{
		Employee employee=(Employee) req.getSession().getAttribute("employeeLogin");
		Customer customer= (Customer) req.getSession().getAttribute("customer");
		tkguitien.setCustomer(customer);
		tkguitien.setEmployee(employee);
		tkguitien.setCreateDate(new Date());
		tkguitien.setCurrentBalance(tkguitien.getFirstSend());
		rest.postForObject("http://localhost:8080/tkguitien/add", tkguitien, TKGuiTien.class);
		return "redirect:/bankaccount";
	}
	@GetMapping("/edittkguitien/{id}")
	public String editTKGuitien(@PathVariable("id") String idCardNumber,Model model,HttpServletRequest req)
	{
		TKGuiTien tkguitien=rest.getForObject("http://localhost:8080/tkguitien/detail/{id}", TKGuiTien.class,idCardNumber);
		
		req.getSession().setAttribute("customer", tkguitien.getCustomer());
		req.getSession().setAttribute("employeecreateaccount", tkguitien.getEmployee());
		model.addAttribute("tkguitien",tkguitien);
		return "TKGuiTienUpdate";
	}
	@PostMapping("/edittkguitien")
	public String editTkGuiTien(TKGuiTien tkguitien,HttpServletRequest req)
	{
		Employee employee=(Employee) req.getSession().getAttribute("employeecreateaccount");
		Customer customer= (Customer) req.getSession().getAttribute("customer");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String cd = req.getParameter("cd");
		try {
			tkguitien.setCreateDate(simpleDateFormat.parse(cd));
		} catch (ParseException e) {

			System.out.println(e);
		}
		System.out.println(tkguitien.getCreateDate()+"alooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		tkguitien.setCustomer(customer);
		tkguitien.setEmployee(employee);
		rest.postForObject("http://localhost:8080/tkguitien/add", tkguitien, TKGuiTien.class);
		return "redirect:/bankaccount";
	}
	@GetMapping("/deletetkguitien/{id}")
	public String deleteCustomer(@PathVariable("id") String id,Model model)
	{	
		rest.getForObject("http://localhost:8080/tkguitien/delete/{id}",Boolean.class,id);
		return "redirect:/bankaccount";
	}
}
