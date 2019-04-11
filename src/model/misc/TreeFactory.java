package model.misc;

import java.util.ArrayList;
import java.util.List;

public class TreeFactory {
	
	private static TreeFactory instance;
	
	
	public Tree buildCompleteTree(int depth) {
		if(depth<1)
			throw new IllegalArgumentException("Depth must be at least 1");
		else if(depth==1) {
			return new Tree(getRandomTerminal());
		}
		else {
			Tree tree = new Tree(getRandomNonTerminal());
			tree.addChild(buildCompleteTree(depth-1));
			tree.addChild(buildCompleteTree(depth-1));
			if(tree.getType()==NonTerminal.SEQ3) {
				tree.addChild(buildCompleteTree(depth-1));
			}
			return tree;
		}	
	}
	
	public Tree buildGrowthTree(int depth) {
		if(depth<1)
			throw new IllegalArgumentException("Depth must be at least 1");
		else if(depth==1) {
			return new Tree(getRandomTerminal());
		}
		else {
			if(Math.random()<0.5) {
				Tree tree = new Tree(getRandomNonTerminal());
				tree.addChild(buildGrowthTree(depth-1));
				tree.addChild(buildGrowthTree(depth-1));
				return tree;
			}
			else {
				return new Tree(getRandomTerminal());
			}
		}	
	}
	
	
	public NodeType getRandomTerminal() {
		return Terminal.values()[(int)(Math.random()*Terminal.values().length)];
	}
	
	public NodeType getRandomNonTerminal() {
		return NonTerminal.values()[(int)(Math.random()*NonTerminal.values().length)];
	}
	
	private TreeFactory() {};
	
	public static TreeFactory getInstance() {
		if(instance==null) {
			instance=new TreeFactory();
		}
		return instance;
	}
	
}
