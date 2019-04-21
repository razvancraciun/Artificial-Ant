package model.entity;

import java.util.ArrayList;
import java.util.List;

public class Elite {

	private List<Individual> _elite;
	
	public Elite(Population population,double elitism) {
		if(elitism<=0) {
			return;
		}
		_elite=new ArrayList<Individual>();
		population.sort();
		for(int i=0;i<population.length()*elitism;i++) {
			_elite.add(new Individual(population.getIndividual(i)));
		}
	}

	public void replaceWorst(Population population) {
		population.sort();
		for(int i=0;i<_elite.size();i++) {
			population.setIndividual(population.length()-i-1, _elite.get(i));
		}
	}
	
	public String toString() {
		String result="";
		for(Individual ind : _elite) {
			result+=ind;
		}
		return result;
	}
	
}
