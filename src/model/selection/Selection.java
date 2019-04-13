package model.selection;

import model.entity.Population;

public interface Selection {

	public void apply(Population source);
}
