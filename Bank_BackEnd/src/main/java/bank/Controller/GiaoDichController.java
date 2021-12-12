package bank.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.entiry.Customer;
import bank.entiry.GiaoDich;
import bank.repositories.GiaoDichRepository;


@RestController
@RequestMapping(path = "/giaodich", produces = "application/json")
public class GiaoDichController {
	private GiaoDichRepository GiaoDichRepo;
	
	public GiaoDichController(GiaoDichRepository giaodichRepo) {
		super();
		GiaoDichRepo = giaodichRepo;
	}

	@GetMapping("/recent")
	public List<GiaoDich> findAll()
	{
		return GiaoDichRepo.findAll();
	}
	
}
