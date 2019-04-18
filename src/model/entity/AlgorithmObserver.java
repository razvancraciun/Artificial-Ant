package model.entity;

public interface AlgorithmObserver {

	public void onNewGeneration(int generation,int best, int bestThisGeneration, int averageThisGeneration);
	public void onNewBest(Individual best);
	public void onStart();
	public void onEnd();
}
