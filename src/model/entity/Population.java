package model.entity;

import java.util.ArrayList;
import java.util.List;

public class Population {

	private List<Individual> _population;
	
	public Population(int size, int maxDepth) {
		_population=new ArrayList<Individual>();
		for(int group=0;group<(maxDepth-1);group++) {
			for(int i=group*size/(maxDepth-1);i<(group+1)*size/(maxDepth-1);i++) {
				if(i%2==0)
					_population.add(new Individual(2+group,true));
				else
					_population.add(new Individual(2+group,false));
			}
		}
	}
	
	public void evaluate() {
		for(Individual i : _population) {
			i.evaluate();
		}
	}
	
	public String toString() {
		String result="";
		for(Individual i : _population) {
			result+=i+"\n";
		}
		return result;
	}
}
