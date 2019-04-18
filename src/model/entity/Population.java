package model.entity;

//package model.entity;

import java.util.ArrayList;
import java.util.List;

import model.mutation.Mutation;

public class Population {

	private List<Individual> _population;
	private Individual _best;
	
	
	private List<PopulationObserver> _observers;
	
	public Population(int size, int maxDepth) {
		_observers=new ArrayList<PopulationObserver>();
		_population=new ArrayList<Individual>();
		for(int group=0;group<(maxDepth-1);group++) {
			for(int i=group*size/(maxDepth-1);i<(group+1)*size/(maxDepth-1);i++) {
				if(i%2==0)
					_population.add(new Individual(2+group,true));
				else
					_population.add(new Individual(2+group,false));
			}
		}
		for(Individual i : _population ) {
			i.getTree().computeDepths();
		}
		_best=new Individual(_population.get(0));
	}
	
	public Population(Population other) {
		_population=new ArrayList<Individual>();
		for(int i=0; i<other.length();i++) {
			_population.add(new Individual(other.getIndividual(i)));
		}
		_best=new Individual(_population.get(0));
	}
	
	public void evaluate() {
		for(Individual i : _population) {
			i.evaluate();
			if(i.getFitness()>_best.getFitness()) {
				//System.out.println("New best: Population. Observers: "+ _observers.size());
				_best=new Individual(i);
				for(PopulationObserver o : _observers) {
					o.onNewBest(_best);
				}
			}
		}
	}
	
	public void addObserver(PopulationObserver observer) {
		_observers.add(observer);
	}
	
	public int length() {
		return _population.size();
	}
	
	public Individual getIndividual(int index) {
		return _population.get(index);
	}
	
	public String toString() {
		String result="";
		for(Individual i : _population) {
			result+=i+"\n";
		}
		return result;
	}

	public void setIndividual(int i, Individual ind) {
		_population.set(i, ind);	
	}

	public void mutate(Mutation _mutation, double _mutationChance) {
		for(Individual ind : _population) {
			if(Math.random()<_mutationChance) {
				_mutation.apply(ind);
			}
		}
	}
}
