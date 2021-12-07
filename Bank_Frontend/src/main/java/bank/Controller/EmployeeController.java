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


import bank.entiry.Employee;
@Controller
public class EmployeeController {
RestTemplate rest=new RestTemplate();
	
	@GetMapping("/employee")
	public String employeecategory(Model model)
	{
		List<Employee> listemployee=Arrays.asList(rest.getForObject("http://localhost:8080/employee/recent", Employee[].class));
		model.addAttribute("listemployee",listemployee);
		return "employee";
	}
	@GetMapping("/addemployee")
	public String addEmployee(Model model)
	{
		
		model.addAttribute("employee",new Employee());
		return "EmployeeCreateUpdate";
	}
	@PostMapping("/createupdateemployee")
	public String addEmployee(Employee employee, HttpServletRequest req)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dob = req.getParameter("dob");
		String jd=req.getParameter("jd");
		try {
			employee.setDateOfBirth(simpleDateFormat.parse(dob));
			employee.setJoinDate(simpleDateFormat.parse(jd));
		} catch (ParseException e) {

			System.out.println(e);
		}
		
		rest.postForObject("http://localhost:8080/employee/add", employee, Employee.class);
		return "redirect:/employee";
	}
	@GetMapping("/updateemployee/{id}")
	public String updateEmployee(@PathVariable("id") int id,Model model)
	{	
		Employee employee =rest.getForObject("http://localhost:8080/employee/findemployeebyid/{id}",Employee.class,id);
		model.addAttribute("employee",employee);
		return "EmployeeCreateUpdate";
	}
	@GetMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id,Model model)
	{	
		rest.getForObject("http://localhost:8080/employee/deleteemployee/{id}",Boolean.class,id);
		return "redirect:/employee";
	}
}
