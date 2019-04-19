package model.entity;

public interface AlgorithmObserver {

<<<<<<< HEAD
	public void onNewGeneration(int generation,int best, int generationBest,double generationAvg);
=======
	public void onNewGeneration(int generation,int best, int bestThisGeneration, int averageThisGeneration);
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
	public void onNewBest(Individual best);
	public void onStart();
	public void onEnd();
}
