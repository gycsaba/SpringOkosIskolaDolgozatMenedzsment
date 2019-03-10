package hu.vasvari.dolgozatok.repository;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.vasvari.dolgozatok.model.Dolgozat;

@Repository
public class DolgozatokAdatraktar {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DolgozatRekordDolgozatObjektumraLekepezo dolgozatLekepezo;
	
	public List<Dolgozat> getDolgozatok() {
		return jdbcTemplate.query("SELECT * FROM dolgozatok", new Object[] {} , dolgozatLekepezo);
	}
	
	public List<Dolgozat> getDolgozatok(boolean megirva) {
		return jdbcTemplate.query("SELECT * FROM dolgozatok WHERE megirva=?", new Object[]  {megirva}, dolgozatLekepezo);
	}

	public Dolgozat lekerDolgozatIdAlapjan(@NotBlank String id) {
		// TODO Auto-generated method stub		
		Dolgozat d=jdbcTemplate.queryForObject("SELECT * FROM dolgozatok WHERE id=?", new Object[] {id}, dolgozatLekepezo);
		
		if (d==null)
			throw new EmptyResultDataAccessException(1);		
		
		return d;
	}

	public void modositDolgozat(@NotNull @Valid Dolgozat d) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("UPDATE dolgozatok SET nev=?, leiras=?, megirva=?, letrehozasdatuma=?, dolgozatirasdatuma=? WHERE id=?", 
				d.getNev(),d.getLeiras(),d.isMegirva(),d.getLetrehozasDatuma(),d.getDolgozatirasDatuma(),d.getId());
		
	}
	
}
