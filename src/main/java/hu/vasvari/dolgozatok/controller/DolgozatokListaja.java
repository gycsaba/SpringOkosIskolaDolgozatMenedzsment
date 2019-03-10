package hu.vasvari.dolgozatok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import hu.vasvari.dolgozatok.model.Dolgozat;
import hu.vasvari.dolgozatok.service.DolgozatokSzolgaltatas;

@Controller
public class DolgozatokListaja {
	
	@Autowired
	DolgozatokSzolgaltatas dolgozatSzolgaltatas;
	
	@GetMapping("/osszesdolgozat")
	public ModelAndView osszesDolgozatListaja() {
		
		List<Dolgozat> osszesDolgozat=dolgozatSzolgaltatas.dolgozatok();
		
		ModelAndView mav=new ModelAndView("osszes-dolgozat-listaja");
		mav.addObject("osszesDolgozatLista",osszesDolgozat);
		
		return mav;
	}

}
