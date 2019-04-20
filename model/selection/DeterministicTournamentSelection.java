package model.selection;

import model.entity.Individual;
import model.entity.Population;

public class DeterministicTournamentSelection implements Selection {

	@Override
	public void apply(Population source) {
		Population copy= new Population(source);
		
		for(int i=0;i<source.length();i++) {
			Individual first =new Individual(copy.getIndividual((int)(Math.random()*copy.length())));
			Individual second =new Individual(copy.getIndividual((int)(Math.random()*copy.length())));
			if(first.getFitness()>second.getFitness()) {
				source.setIndividual(i, first);
			}
			else {
				source.setIndividual(i, second);
			}
		}
	}

	@Override
	public String toString() {
		return "Deterministic Tournament";
	}
	
}
