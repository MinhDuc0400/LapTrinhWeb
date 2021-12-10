package bank.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import bank.entiry.TKGuiTien;
import bank.repositories.TKGuiTienRepository;

@RestController
@RequestMapping(path = "/tkguitien", produces = "application/json")
public class TKGuiTienController {
	private TKGuiTienRepository TKGuiTienRepo;

	public TKGuiTienController(TKGuiTienRepository tKGuiTienRepo) {
		
		TKGuiTienRepo = tKGuiTienRepo;
	}
	
	@GetMapping("/findbycustomer/{id}")
	public TKGuiTien findbycustomer(@PathVariable("id") int id)
	{
		return TKGuiTienRepo.getTKGuiTienbyCustomer(id);
	}
	@GetMapping("/detail/{id}")
	public TKGuiTien detailtkguitien(@PathVariable("id") String id)
	{
		return TKGuiTienRepo.findById(id).get();
	}
	@PostMapping("/add")
	public TKGuiTien addTKGuiTien(@RequestBody TKGuiTien tkguitien)
	{
		return  TKGuiTienRepo.save(tkguitien);
	}
	@GetMapping("/delete/{id}")
	public boolean delete(@PathVariable("id") String id)
	{
		TKGuiTienRepo.deleteById(id);
		 return true;
	}
}
