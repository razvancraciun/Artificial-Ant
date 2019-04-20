package model.mutation;

import model.entity.Individual;

public class NoMutation implements Mutation{

	@Override
	public void apply(Individual source) {
		return;
	}

}
