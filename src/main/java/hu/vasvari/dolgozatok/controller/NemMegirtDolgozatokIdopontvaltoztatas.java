package hu.vasvari.dolgozatok.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import hu.vasvari.dolgozatok.model.Dolgozat;
import hu.vasvari.dolgozatok.service.DolgozatokSzolgaltatas;
import hu.vasvari.dolgozatok.service.RosszulMegadottDolgozatirasDatumException;

@Controller
public class NemMegirtDolgozatokIdopontvaltoztatas {
	
	@Autowired
	DolgozatokSzolgaltatas dolgozatokSzolgaltatas;
	
	@GetMapping("/idopontvaltoztatas")
	public ModelAndView nemmegirtDolgozatokListaja() {
		
		List<Dolgozat> nemMegirtDolgozatok=dolgozatokSzolgaltatas.visszadNemMegirtakat();
		
		ModelAndView mav=new ModelAndView("nemmegirt-dolgozatok-idopontvaltoztatas-listaja");
		mav.addObject("nemMegirtDolgozatokLista", nemMegirtDolgozatok);
		
		return mav;
	}
	
	@GetMapping("/dolgozat/{id}/")
	public ModelAndView dolgozatIdpontModositUrlapMegjelenit(@PathVariable String id) {
		
		Dolgozat d=dolgozatokSzolgaltatas.lekerDolgozatIdAlapjan(id);
		
		ModelAndView mav=new ModelAndView("tennivalo-idopont-szerkeszto");
		mav.addObject("dolgozat", d);
		
		return mav;
	}
	
	@PostMapping("/dolgozat-idopont-modosit/")
	public String dolgozatIdopontModosit(
			@Valid @ModelAttribute("dolgozat") Dolgozat d,
			BindingResult bindingResult,
			Model model) {
		
		System.out.println(d);
		if (bindingResult.hasErrors()) {
			List<ObjectError> oel=bindingResult.getAllErrors();
			for(ObjectError oe : oel) {
				System.out.println(oe.toString());
			}
			
			
			return "tennivalo-idopont-szerkeszto";
		}
		try {		
			dolgozatokSzolgaltatas.modositDolgozatirasDatumot(d);		
		}
		catch (RosszulMegadottDolgozatirasDatumException rmdde) {			
		}
		
		return "redirect:/idopontvaltoztatas";
	}
	
	  @ExceptionHandler
	  @ResponseStatus(value = HttpStatus.NOT_FOUND)
	  public String nincsMegADolgozatHibatLekezel(EmptyResultDataAccessException e) {
	    return "hiba-dolgozat-nem-talalhato";
	  }

}
