package hu.vasvari.dolgozatok.service;

import java.util.List;

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
	
}
