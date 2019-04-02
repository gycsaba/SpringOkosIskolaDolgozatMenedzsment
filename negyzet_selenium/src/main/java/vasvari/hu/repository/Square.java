package vasvari.hu.repository;

import vasvari.hu.exception.SquareException;

public class Square {
	
	private int side;

	public Square (String side) throws Exception {
		try
		{
			this.side=Integer.parseInt(side);
			if (this.side<=0)				
				throw new SquareException("A négyzet oldala nem lehet negatív vagy nulla!");
		}
		catch (NumberFormatException e)
		{
			throw new SquareException(side+", nem helyes négyzet oldal.");
		}
		
	}
	public int getArea() {
		return side*side;
	}
	
	

}
