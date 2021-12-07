package bank.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.entiry.Customer;
import bank.repositories.CustomerRepository;


@RestController
@RequestMapping(path = "/customer", produces = "application/json")
public class CustomerController {
	private CustomerRepository CustomerRepo;

	public CustomerController(CustomerRepository customerRepo) {
		CustomerRepo = customerRepo;
	}
	@GetMapping("/recent")
	public List<Customer> findAll()
	{
		return CustomerRepo.findAll();
	}
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return CustomerRepo.save(customer);
	}
	@GetMapping("/findcustomerbyid/{id}")
	public Customer findCustomerById(@PathVariable("id") int id)
	{
		return CustomerRepo.findById(id).get();
	}
	@GetMapping("/deletecustomer/{id}")
	public boolean deleteCustomer(@PathVariable("id") int id)
	{
		 CustomerRepo.deleteById(id);
		 return true;
	}
}
