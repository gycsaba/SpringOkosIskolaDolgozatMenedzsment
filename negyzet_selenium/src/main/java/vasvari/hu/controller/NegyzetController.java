package vasvari.hu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vasvari.hu.exception.SquareException;
import vasvari.hu.repository.Square;

@Controller
public class NegyzetController {
	
	@GetMapping("/szamol")
	public ModelAndView computeArea(@RequestParam (defaultValue="1") String oldal) {
	
		try
		{
			Square n=new Square(oldal);
			ModelAndView mav=new ModelAndView();
			mav.addObject("oldal", oldal);
			mav.addObject("terulet", n.getArea());
			mav.setViewName("eredmeny");
			
			return mav;			
		}
		catch (SquareException se){
			return getErrorPage(se.getMessage());
		}
		catch (Exception e){
			return getErrorPage("Ismeretlen hiba történt!");
		}		
	}	
	@GetMapping("/hiba")
	public ModelAndView getErrorPage(String errorMessage) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("hibauzenet", errorMessage);
		mav.setViewName("hiba");
		return mav;
	}
}
