package bank.Controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
@Controller
public class CustomerController {
	RestTemplate rest=new RestTemplate();
	
	@GetMapping("/customer")
	public String customercategory(Model model)
	{
		List<Customer> listcustomer=Arrays.asList(rest.getForObject("http://localhost:8080/customer/recent", Customer[].class));
		model.addAttribute("listcustomer",listcustomer);
		return "customer";
	}
	@GetMapping("/addcustomer")
	public String addCustomer(Model model)
	{
		
		model.addAttribute("customer",new Customer());
		return "CustomerCreateUpdate";
	}
	@PostMapping("/createupdatecustomer")
	public String addCustomer(Customer customer, HttpServletRequest req)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dob = req.getParameter("dob");
		try {
			customer.setDateOfBirth(simpleDateFormat.parse(dob));
		} catch (ParseException e) {

			System.out.println(e);
		}
		System.out.println(customer);
		rest.postForObject("http://localhost:8080/customer/add", customer, Customer.class);
		return "redirect:/customer";
	}
	@GetMapping("/updatecustomer/{id}")
	public String updateCustomer(@PathVariable("id") int id,Model model)
	{	
		Customer customer =rest.getForObject("http://localhost:8080/customer/findcustomerbyid/{id}",Customer.class,id);
		model.addAttribute("customer",customer);
		return "CustomerCreateUpdate";
	}
	@GetMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int id,Model model)
	{	
		rest.getForObject("http://localhost:8080/customer/deletecustomer/{id}",Boolean.class,id);
		return "redirect:/customer";
	}
}
