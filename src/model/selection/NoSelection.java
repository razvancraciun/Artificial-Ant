package model.selection;

import model.entity.Population;

public class NoSelection implements Selection{

	@Override
	public void apply(Population source) {
		
	}
	
	public String toString() {
		return "No selection";
	}

}
