package model.selection;

import java.util.ArrayList;
import java.util.List;

import model.entity.Individual;
import model.entity.Population;

public class RouletteSelection implements Selection {

	@Override
	public void apply(Population source) {
		Population copy=new Population(source);
		List<Double> relativeFitness = new ArrayList<Double>();
		double sum=0;
		for(int i=0;i<source.length();i++) {
			relativeFitness.add((double) source.getIndividual(i).getFitness());
			sum+=source.getIndividual(i).getFitness();
		}
		for(int i=0;i<relativeFitness.size();i++) {
			relativeFitness.set(i, relativeFitness.get(i)/sum);
		}
		
		for(int i=0;i<source.length();i++) {
			source.setIndividual(i,pickOne(copy,relativeFitness));
		}
		
	}

	private Individual pickOne(Population copy, List<Double> relativeFitness) {
		double target= Math.random();
		double sum=0.0;
		for(int i=0;i<copy.length();i++) {
			sum+=relativeFitness.get(i);
			if(target<sum) {
				return new Individual(copy.getIndividual(i));
			}
		}
		throw new IllegalArgumentException("Relative Fitness does not add up to 1");
	}

	public String toString() {
		return "Roulette";
	}
	
}
