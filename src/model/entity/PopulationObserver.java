package model.entity;

public interface PopulationObserver {

	public void onNewBest(Individual best);
	public void onNewEvaluation(int best,double avg);
}
