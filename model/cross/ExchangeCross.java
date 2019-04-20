package model.cross;

import java.util.ArrayList;
import java.util.List;


import model.entity.Individual;
import model.misc.Terminal;
import model.misc.Tree;

public class ExchangeCross implements Cross {

	private List<Tree> _firstFunctions;
	private List<Tree> _secondFunctions;
	private List<Tree> _firstTerminals;
	private List<Tree> _secondTerminals;
	
	@Override
	public void apply(Individual  first,Individual second) {
		initLists();
		add(first.getTree(),true);
		add(second.getTree(),false);
		
		Individual firstCopy = new Individual(first);
		Individual secondCopy = new Individual(second);
		
		replace(firstCopy,secondCopy);
		firstCopy.getTree().computeDepths();
		secondCopy.getTree().computeDepths();
		
		while(firstCopy.getTree().getDepth()>first.getMaxDepth() || secondCopy.getTree().getDepth()>second.getMaxDepth()) {
			replace(firstCopy,secondCopy);
			firstCopy.getTree().computeDepths();
			secondCopy.getTree().computeDepths();
		}
		
		first=firstCopy;
		second=secondCopy;
		
		
		
		
		//System.out.println(first);
		//sSystem.out.println(second);
	}
	
	private void initLists() {
		_firstFunctions=new ArrayList<Tree>();
		_secondFunctions=new ArrayList<Tree>();
		_firstTerminals=new ArrayList<Tree>();
		_secondTerminals=new ArrayList<Tree>();
	}

	private void replace(Individual first, Individual second) {
		Tree point1;
		if(Math.random()<0.9 && _firstFunctions.size()>0) {
			point1=_firstFunctions.get((int)(Math.random()*_firstFunctions.size()));
		}
		else {
			point1=_firstTerminals.get((int)(Math.random()*_firstTerminals.size()));
		}
		Tree point2;
		if(Math.random()<0.9 && _secondFunctions.size()>0) {
			point2=_secondFunctions.get((int)(Math.random()*_secondFunctions.size()));
		}
		else {
			point2=_secondTerminals.get((int)(Math.random()*_secondTerminals.size()));
		}
		
		if(point1.getParent()!=null) {
			point1.getParent().replaceChild(point1,point2);
		}
		else {
			first.setTree(point2);
		}
		
		if(point2.getParent()!=null) {
			point2.getParent().replaceChild(point2,point1);
		}
		else {
			second.setTree(point1);
		}
	}
	
	private void add(Tree tree, boolean first) {
		if(tree.getType().getClass()==Terminal.class) {
			if(first) {
				_firstTerminals.add(tree);
			}
			else {
				_secondTerminals.add(tree);
			}
			
		}
		else {
			if(first) {
				_firstFunctions.add(tree);
				for(Tree child : tree.getChildren()) {
					add(child,true);
				}
			}
			else {
				_secondFunctions.add(tree);
				for(Tree child : tree.getChildren()) {
					add(child,false);
				}
			}
		}
	}
}
