package model.mutation;

import java.util.ArrayList;
import java.util.List;

import model.entity.Individual;
import model.misc.Tree;
import model.misc.TreeFactory;

public class InitializationMutation implements Mutation {

	private List<Tree> subtrees;
	private List<Integer> levels;
	
	//TODO can not pick root?
	
	@Override
	public void apply(Individual source) {
		subtrees=new ArrayList<Tree>();
		levels = new ArrayList<Integer>();
		addTrees(source.getTree(),0);
		int index = (int) (Math.random()*subtrees.size());
		Tree pick = subtrees.get(index);
		
		if(pick.getParent()!=null) {
			pick.getParent().replaceChild(pick, TreeFactory.getInstance().buildGrowthTree(source.getMaxDepth()-levels.get(index)));
		}
		else {
			source.setTree(TreeFactory.getInstance().buildGrowthTree(source.getMaxDepth()));
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
