package model.cross;

import model.entity.Individual;
/**
 * Basic interface for building crossover operators
 * @author razvan
 *
 */
public interface Cross {

	public void apply(Individual first, Individual second);
	public String toString();
}
