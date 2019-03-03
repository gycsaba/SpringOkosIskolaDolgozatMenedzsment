package hu.vasvari.dolgozatok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hu.vasvari.dolgozatok.model.Dolgozat;
import hu.vasvari.dolgozatok.service.DolgozatokSzolgaltatas;

@RestController
public class MegirtNemmegirtDolgozatokListaja {
	
	@Autowired 
	private DolgozatokSzolgaltatas dolgozatSzolgaltatas;
	
	@GetMapping("/api/dolgozatlista/megirt")
	public List<Dolgozat> megirtDolgozatokListaja() {
		
		List<Dolgozat> valsztottDolgozatok;
		valsztottDolgozatok=dolgozatSzolgaltatas.visszaadMegirtakat();
		return valsztottDolgozatok;				
	}
	
	@GetMapping("/api/dolgozatlista/nemmegirt")
	public List<Dolgozat> nemMegirtDolgozatokListaja() {
		
		List<Dolgozat> valsztottDolgozatok;
		valsztottDolgozatok=dolgozatSzolgaltatas.visszadNemMegirtakat();
		return valsztottDolgozatok;				
	}

}
