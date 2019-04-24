package model.entity;

import java.util.ArrayList;
import java.util.List;

import model.cross.Cross;
import model.mutation.Mutation;
import model.selection.Selection;

public class GeneticAlorithm implements PopulationObserver {

	private Population _population;
	private int _maxDepth;
	private int _steps;
	private double _crossChance;
	private double _mutationChance;
	private Selection _selection;
	private Cross _cross;
	private Mutation _mutation;
	private double _elitism;
	
	private Individual _best;
	private int _generationBest;
	private double _generationAvg;
	
	private List<AlgorithmObserver> _observers;
	
	public GeneticAlorithm(int populationSize,int maxDepth,int steps,double crossChance,double mutationChance,
			Selection selection,Cross cross,Mutation mutation, double elitism) {
		_observers=new ArrayList<AlgorithmObserver>();
		init(populationSize,maxDepth,steps,crossChance,mutationChance,selection,cross,mutation,elitism);
	}
	
	
	public void init(int populationSize,int maxDepth, int steps, double crossChance,double mutationChance,
			Selection selection,Cross cross,Mutation mutation, double elitism) {
		_maxDepth=maxDepth;
		_steps= steps;
		_population=new Population(populationSize,_maxDepth,_steps);
		_population.addObserver(this);
		
		_best=null;
		
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
			Thread.currentThread();
			if(Thread.interrupted()) {
				break;
			}
			
			Elite elite = new Elite(_population,_elitism);
			_selection.apply(_population);	
			_population.cross(_cross,_crossChance);
			_population.mutate(_mutation,_mutationChance);
			_population.evaluate();
			if(_elitism>0) {
				elite.replaceWorst(_population);
				_population.evaluate();
			}
			
			
			
			
			for(AlgorithmObserver o : _observers) {
				o.onNewGeneration(i,_best.getFitness(),_generationBest,_generationAvg);
			}
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
		for(AlgorithmObserver o : _observers) {
			o.onNewBest(_best);
		}
	}


	@Override
	public void onNewEvaluation(int best, double avg) {
		_generationBest=best;
		_generationAvg=avg;
	}
	
}
