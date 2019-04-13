package model.mutation;

import model.entity.Individual;

public interface Mutation {

	public Individual apply(Individual source);
}
