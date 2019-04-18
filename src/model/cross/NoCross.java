package model.cross;

import model.entity.Pair;

public class NoCross implements Cross{

	@Override
	public Pair apply(Pair original) {
		return original;
	}

}
