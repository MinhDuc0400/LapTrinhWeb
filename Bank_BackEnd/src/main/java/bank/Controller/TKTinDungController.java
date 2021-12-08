package bank.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.entiry.TKGuiTien;
import bank.entiry.TKTinDung;

import bank.repositories.TKTinDungRepository;

@RestController
@RequestMapping(path = "/tktindung", produces = "application/json")
public class TKTinDungController {
	private TKTinDungRepository TKTinDungRepo;

	
	public TKTinDungController(TKTinDungRepository tKTinDungRepo) {
		
		TKTinDungRepo = tKTinDungRepo;
	}


	@GetMapping("/findbycustomer/{id}")
	public TKTinDung findbycustomer(@PathVariable("id") int id)
	{
		return TKTinDungRepo. getTkTinDungbyCustomer(id);
	}
	
	@GetMapping("/detail/{id}")
	public TKTinDung detailtktindung(@PathVariable("id") String id)
	{
		return TKTinDungRepo.findById(id).get();
	}
	@PostMapping("/add")
	public TKTinDung addTKTinDung(@RequestBody TKTinDung tktindung)
	{
		return  TKTinDungRepo.save(tktindung);
	}
	@GetMapping("/delete/{id}")
	public boolean delete(@PathVariable("id") String id)
	{
		TKTinDungRepo.deleteById(id);
		 return true;
	}
}
