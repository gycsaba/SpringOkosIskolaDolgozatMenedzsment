package hu.vasvari.dolgozatok.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
}
