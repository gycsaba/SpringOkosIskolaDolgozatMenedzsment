package hu.vasvari.dolgozatok.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.vasvari.dolgozatok.model.Dolgozat;
import hu.vasvari.dolgozatok.repository.DolgozatokAdatraktar;

@Service
public class DolgozatokSzolgaltatas {
	
	@Autowired
	DolgozatokAdatraktar dolgozatRepo;
	
	public List<Dolgozat> dolgozatok() {
		return dolgozatRepo.getDolgozatok(); 
	}
	
	public List<Dolgozat> visszaadMegirtakat() {
		return dolgozatRepo.getDolgozatok(true);
	}
	
	public List<Dolgozat> visszadNemMegirtakat() {
		return dolgozatRepo.getDolgozatok(false);
	}

	public Dolgozat lekerDolgozatIdAlapjan(String id) {
		// TODO Auto-generated method stub
		return dolgozatRepo.lekerDolgozatIdAlapjan(id);
	}

	public void modositDolgozatirasDatumot(@NotNull @Valid Dolgozat d) throws RosszulMegadottDolgozatirasDatumException {
		// TODO Auto-generated method stub
		Dolgozat regiDatumuDolgozat=dolgozatRepo.lekerDolgozatIdAlapjan(d.getId());
		try {
			regiDatumuDolgozat.setDolgozatirasDatuma(d.getDolgozatirasDatuma());
			dolgozatRepo.modositDolgozat(regiDatumuDolgozat);
		}
		catch(Exception e) {
			throw new RosszulMegadottDolgozatirasDatumException("A megadott dátum formátuma nem helyes:"+regiDatumuDolgozat.getDolgozatirasDatuma());
		}
		
	}
	
}
