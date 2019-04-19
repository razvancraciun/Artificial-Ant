package model.entity;

public interface AlgorithmObserver {

	public void onNewGeneration(int generation,int best, int generationBest,double generationAvg);
	public void onNewBest(Individual best);
	public void onStart();
	public void onEnd();
}
