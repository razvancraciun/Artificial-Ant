package model.entity;

import model.misc.Tree;
import model.misc.TreeFactory;

public class Individual {

	private double _fitness;
	private Tree _tree;
	private int _maxDepth;
	
	public Individual(int depth,boolean complete) {
		_fitness=0;
		_maxDepth=depth;
		if(complete) {
			_tree=TreeFactory.getInstance().buildCompleteTree(depth);
		}
		else {
			_tree=TreeFactory.getInstance().buildGrowthTree(depth);
		}
	}
	
	public String toString() {
		return _tree.toString();
	}
}
