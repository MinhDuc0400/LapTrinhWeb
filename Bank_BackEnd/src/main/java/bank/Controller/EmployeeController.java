package bank.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.entiry.Customer;
import bank.entiry.Employee;
import bank.repositories.EmployeeRepository;


@RestController
@RequestMapping(path = "/employee", produces = "application/json")
public class EmployeeController {
	private EmployeeRepository EmployeeRepo;

	public EmployeeController(EmployeeRepository employeeRepo) {
		
		EmployeeRepo = employeeRepo;
	}
	@GetMapping("/recent")
	public List<Employee> findAll()
	{
		return EmployeeRepo.findAll();
	}
	
	@PostMapping("/login")
	public Employee login(@RequestBody Employee employee)
	{
		return EmployeeRepo.findByUserNameAndPassWord(employee.getUserName(), employee.getPassWord());
	}
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return EmployeeRepo.save(employee);
	}
	@GetMapping("/findemployeebyid/{id}")
	public Employee findEmployeeById(@PathVariable("id") int id)
	{
		return EmployeeRepo.findById(id).get();
	}
	@GetMapping("/deleteemployee/{id}")
	public boolean deleteemployee(@PathVariable("id") int id)
	{
		EmployeeRepo.deleteById(id);
		 return true;
	}
}	
