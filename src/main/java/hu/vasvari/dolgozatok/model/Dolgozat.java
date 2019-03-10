package hu.vasvari.dolgozatok.model;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

public class Dolgozat {
	
	private String id;
	
	@NotBlank(message="A dolgozatnak kell legyen neve!")
	private String nev;	
	@NotBlank(message="A dolgozatnak kell legyen leírása!")
	private String leiras;
	private boolean megirva;
	@PastOrPresent(message="A dolgozat létrehozásának dátuma nem lehet a múltban!")
	private LocalDate letrehozasDatuma;
	@FutureOrPresent(message="A dolgozat írásának dátuma nem lehet a múltban!")
	private LocalDate dolgozatirasDatuma;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	public String getLeiras() {
		return leiras;
	}
	public void setLeiras(String leiras) {
		this.leiras = leiras;
	}
	public boolean isMegirva() {
		return megirva;
	}
	public void setMegirva(boolean megirva) {
		this.megirva = megirva;
	}
	public LocalDate getLetrehozasDatuma() {
		return letrehozasDatuma;
	}
	public void setLetrehozasDatuma(LocalDate letrehozasDatuma) {
		this.letrehozasDatuma = letrehozasDatuma;
	}
	public LocalDate getDolgozatirasDatuma() {
		return dolgozatirasDatuma;
	}
	public void setDolgozatirasDatuma(LocalDate dolgozatirasDatuma) {
		this.dolgozatirasDatuma = dolgozatirasDatuma;
	}
	@Override
	public String toString() {
		return "Dolgozat [id=" + id + ", nev=" + nev + ", leiras=" + leiras + ", megirva=" + megirva
				+ ", letrehozasDatuma=" + letrehozasDatuma + ", dolgozatirasDatuma=" + dolgozatirasDatuma + "]";
	}
	
}
