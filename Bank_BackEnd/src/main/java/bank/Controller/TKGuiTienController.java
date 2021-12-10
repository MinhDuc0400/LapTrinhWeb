package bank.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.entiry.GiaoDich;
import bank.entiry.TKGuiTien;
import bank.entiry.TKTinDung;
import bank.repositories.GiaoDichRepository;
import bank.repositories.TKGuiTienRepository;
import bank.repositories.TKTinDungRepository;

@RestController
@RequestMapping(path = "/tkguitien", produces = "application/json")
public class TKGuiTienController {
	private TKGuiTienRepository TKGuiTienRepo;
	private TKTinDungRepository TKTinDungRepo;
	private GiaoDichRepository GiaoDichRepo;
	

	public TKGuiTienController(TKGuiTienRepository tKGuiTienRepo, TKTinDungRepository tKTinDungRepo,
			GiaoDichRepository giaoDichRepo) {
		
		TKGuiTienRepo = tKGuiTienRepo;
		TKTinDungRepo = tKTinDungRepo;
		GiaoDichRepo = giaoDichRepo;
	}

	@GetMapping("/findbycustomer/{id}")
	public TKGuiTien findbycustomer(@PathVariable("id") int id) {
		return TKGuiTienRepo.getTKGuiTienbyCustomer(id);
	}

	@GetMapping("/detail/{id}")
	public TKGuiTien detailtkguitien(@PathVariable("id") String id) {
		return TKGuiTienRepo.findById(id).get();
	}

	@PostMapping("/add")
	public TKGuiTien addTKGuiTien(@RequestBody TKGuiTien tkguitien) {
		return TKGuiTienRepo.save(tkguitien);
	}

	@GetMapping("/delete/{id}")
	public boolean delete(@PathVariable("id") String id) {
		TKGuiTienRepo.deleteById(id);
		return true;
	}

	@PostMapping("/chuyentien")

	public int addGiaodich(@RequestBody GiaoDich giaodich) {
		TKGuiTien tkguitien=TKGuiTienRepo.findById(giaodich.getTkguitien().getIdCardNumber()).get();
		Optional<TKTinDung> tktindungop=TKTinDungRepo.findById(giaodich.getTktindung().getIdCardNumber());
		if(tktindungop.isEmpty())
			return 0;
		
		
		if(tkguitien.getCurrentBalance()-giaodich.getExchange()<tkguitien.getMiniumBalance())
		{
			return 1;
		}
		TKTinDung tktindung=TKTinDungRepo.findById(giaodich.getTktindung().getIdCardNumber()).get();
		tktindung.setDept(tktindung.getDept()-giaodich.getExchange());
		tkguitien.setCurrentBalance(tkguitien.getCurrentBalance()-giaodich.getExchange());
		TKGuiTienRepo.save(tkguitien);
		TKTinDungRepo.save(tktindung);
		giaodich.setTkguitien(tkguitien);
		giaodich.setTktindung(tktindung);
		GiaoDichRepo.save(giaodich);
		return 2;
	}

}
