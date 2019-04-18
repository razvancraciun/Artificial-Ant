package model.entity;

import java.util.ArrayList;
import java.util.List;

import model.cross.Cross;
import model.mutation.Mutation;
import model.selection.Selection;

public class GeneticAlorithm implements PopulationObserver {

	private Population _population;
	private int _maxDepth;
	private double _crossChance;
	private double _mutationChance;
	private Selection _selection;
	private Cross _cross;
	private Mutation _mutation;
	private double _elitism;
	
	private Individual _best;
	
	private List<AlgorithmObserver> _observers;
	
	public GeneticAlorithm(int populationSize,int maxDepth,double crossChance,double mutationChance,
			Selection selection,Cross cross,Mutation mutation, double elitism) {
		_observers=new ArrayList<AlgorithmObserver>();
		init(populationSize,maxDepth,crossChance,mutationChance,selection,cross,mutation,elitism);
	}
	
	
	public void init(int populationSize,int maxDepth,double crossChance,double mutationChance,
			Selection selection,Cross cross,Mutation mutation, double elitism) {
		_population=new Population(populationSize,maxDepth);
		_population.addObserver(this);
		
		_best=null;
		_maxDepth=maxDepth;
		_crossChance=crossChance;
		_mutationChance=mutationChance;
		_selection=selection;
		_cross=cross;
		_mutation=mutation;
		_elitism=elitism;
	}
	
	public void run(int generations) {
		for(AlgorithmObserver o : _observers) {
			o.onStart();
		}
		_population.evaluate();
		for(int i=0;i<generations;i++) {
			_selection.apply(_population);
			//TODO
			//_population.cross(_cross,_crossChance);
			_population.mutate(_mutation,_mutationChance);
			_population.evaluate();
		}
		for(AlgorithmObserver o : _observers) {
			o.onEnd();
		}
	}
	
	public void addObserver(AlgorithmObserver o ) {
		_observers.add(o);
	}


	@Override
	public void onNewBest(Individual best) {
		_best=best;
		//System.out.println("New best: Alg. Observers : "+_observers.size());
		for(AlgorithmObserver o : _observers) {
			o.onNewBest(_best);
		}
		
	}
	
}
