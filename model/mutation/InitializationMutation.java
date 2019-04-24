package model.mutation;

import java.util.ArrayList;
import java.util.List;

import model.entity.Individual;
import model.misc.Tree;
import model.misc.TreeFactory;

public class InitializationMutation implements Mutation {

	private List<Tree> subtrees;
	private List<Integer> levels;
	
	@Override
	public void apply(Individual source) {
		subtrees=new ArrayList<Tree>();
		levels = new ArrayList<Integer>();
		addTrees(source.getTree(),0);
		int index = (int) (1+ Math.random()*(subtrees.size()-1));
		if(subtrees.size()<2) {
			return;
		}
		
		Tree pick = subtrees.get(index);
		
		if(pick.getParent()!=null) {
			pick.getParent().replaceChild(pick, TreeFactory.getInstance().buildGrowthTree(source.getMaxDepth()-levels.get(index)));
		}
	}

	private void addTrees(Tree tree,int level) {
		subtrees.add(tree);
		levels.add(level);
		for(Tree child : tree.getChildren()) {
			addTrees(child,level+1);
		}
	}
	
	public String toString() {
		return "Initialization";
	}

}
