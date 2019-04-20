package controller;

import model.cross.Cross;
import model.entity.AlgorithmObserver;
import model.entity.GeneticAlorithm;
import model.mutation.Mutation;
import model.selection.Selection;

public class Controller {

	private GeneticAlorithm _ga;
	
	public Controller(GeneticAlorithm ga) {
		_ga=ga;
	}
	
	public void init(int populationSize,int maxDepth,double crossChance,double mutationChance,
			Selection selection,Cross cross,Mutation mutation, double elitism) {
		_ga.init(populationSize, maxDepth, crossChance, mutationChance, selection, cross, mutation, elitism);
	}
	
	public void run(int generations) {
		_ga.run(generations);
	}
	
	public void addObserver(AlgorithmObserver ob) {
		_ga.addObserver(ob);
	}


	
}
