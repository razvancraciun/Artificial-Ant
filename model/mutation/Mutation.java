package model.mutation;

import model.entity.Individual;

public interface Mutation {

	public void apply(Individual source);
}
