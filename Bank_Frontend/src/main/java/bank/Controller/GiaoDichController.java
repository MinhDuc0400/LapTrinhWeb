package bank.Controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
import bank.entiry.GiaoDich;
import bank.entiry.TKGuiTien;
import bank.entiry.TKTinDung;
@Controller
public class GiaoDichController {
	RestTemplate rest=new RestTemplate();
	
	@GetMapping("/giaodich")
	public String customercategory(Model model)
	{
		List<GiaoDich> listgiaodich=Arrays.asList(rest.getForObject("http://localhost:8080/giaodich/recent", GiaoDich[].class));
		
		model.addAttribute("listgiaodich",listgiaodich);
		return "giaodich";
	}
	
}
