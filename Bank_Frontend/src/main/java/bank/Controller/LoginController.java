package bank.Controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import bank.entiry.Employee;

@Controller
public class LoginController {
	RestTemplate rest=new RestTemplate();
	@GetMapping("/")
	public String main(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		return "login";
	}
@PostMapping("/login")
	public String postlogin(HttpServletRequest request)
	{
		 String username=request.getParameter("Username");
		 String	password=request.getParameter("Password");
		 Employee employee=new Employee();
		 employee.setUserName(username);
		 employee.setPassWord(password);
		 employee=rest.postForObject("http://localhost:8080/employee/login", employee, Employee.class);
		 System.out.println(employee);
		 if(employee==null)
		 {
			return "redirect:/";
		 }
		 else 
		 {	
			 request.getSession().setAttribute("employeeLogin", employee);
			 return "redirect:/home";
		 } 
	}	
	@GetMapping("/home")
	public String homePage(HttpServletRequest request)
	{	if(request.getSession().getAttribute("employeeLogin")==null) return "redirect:/";
		return "home";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request)
	{	
		if(request.getSession().getAttribute("employeeLogin")!=null) 
			request.getSession().removeAttribute("employeeLogin");
		return "redirect:/";
	}
}
