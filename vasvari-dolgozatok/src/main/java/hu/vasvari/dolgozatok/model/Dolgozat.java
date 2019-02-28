package hu.vasvari.dolgozatok.model;

import java.time.LocalDate;

public class Dolgozat {
	private String id;
	private String nev;
	private String leiras;
	private boolean megirva;
	private LocalDate letrehozasDatuma;
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
