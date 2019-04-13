package model.entity;

import model.cross.Cross;
import model.mutation.Mutation;
import model.selection.Selection;

public class GeneticAlorithm {

	private Population _population;
	private int _maxDepth;
	private double _crossChance;
	private double _mutationChance;
	private Selection _selection;
	private Cross _cross;
	private Mutation _mutation;
	private double _elitism;
	
	public GeneticAlorithm(int populationSize,int maxDepth,double crossChance,double mutationChance,
			Selection selection,Cross cross,Mutation mutation, double elitism) {
		init(populationSize,maxDepth,crossChance,mutationChance,selection,cross,mutation,elitism);
	}
	
	
	public void init(int populationSize,int maxDepth,double crossChance,double mutationChance,
			Selection selection,Cross cross,Mutation mutation, double elitism) {
		_population=new Population(populationSize,maxDepth);
		_maxDepth=maxDepth;
		_crossChance=crossChance;
		_mutationChance=mutationChance;
		_selection=selection;
		_cross=cross;
		_mutation=mutation;
		_elitism=elitism;
		//TODO: initial evaluation
	}
	
	public void run(int generations) {
		for(int i=0;i<generations;i++) {
			_selection.apply(_population);
			//TODO
			//_population.cross(_cross,_crossChance);
			//_population.mutate(_mutation,_mutationChance);
			//_population.evaluate();
		}
	}
	
}
