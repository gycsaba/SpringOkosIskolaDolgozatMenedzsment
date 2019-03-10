package hu.vasvari.dolgozatok.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import hu.vasvari.dolgozatok.model.Dolgozat;

@Component
public class DolgozatRekordDolgozatObjektumraLekepezo implements RowMapper<Dolgozat> {

	@Override
	public Dolgozat mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Dolgozat d=new Dolgozat();
		
		d.setId(rs.getString("id"));
		d.setNev(rs.getString("nev"));
		d.setLeiras(rs.getString("leiras"));
		d.setMegirva(rs.getBoolean("megirva"));
		d.setLetrehozasDatuma(rs.getDate("letrehozasDatuma").toLocalDate());
		d.setDolgozatirasDatuma(rs.getDate("dolgozatirasDatuma").toLocalDate());		
		
		return d;
	}

}
