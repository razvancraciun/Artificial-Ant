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
		Individual firstCopy= new Individual(first);
		Individual secondCopy=new Individual(second);
		add(first.getTree(),true);
		add(second.getTree(),false);
		first.getTree().computeDepths();
		second.getTree().computeDepths();
		
		
		Tree point1=choosePoint(true);
		Tree point2=choosePoint(false);
		
		while(first.getTree().getDepth()-point1.getDepth()+point2.getDepth()>first.getMaxDepth() || 
				second.getTree().getDepth()-point2.getDepth()+point1.getDepth()>second.getMaxDepth()) {
			point1=choosePoint(true);
			point2=choosePoint(false);
		}
		
		
		
		
		Tree temp1 = new Tree(point1);
		Tree temp2= new Tree(point2);
		
		//System.out.println(point1+ ". Parent: "+ point1.getParent());
		//System.out.println(point2+ ". Parent: "+ point2.getParent());
		
		if(point1.getParent()!=null) {
			point1.getParent().replaceChild(point1, temp2); //nu schimba nimic
		}
		else {
			point2.setParent(null);
			first.setTree(temp2);
			
		}
		if(point2.getParent()!=null) {
			point2.getParent().replaceChild(point2, temp1);
		}
		else {
			point2.setParent(null);
			second.setTree(temp1);
			
		}
		
		//System.out.println(point1+ ". Parent: "+ temp1.getParent());
		//System.out.println(point2+ ". Parent: "+ temp2.getParent());
		
	
	}
	
	private Tree choosePoint(boolean first) {
		Tree point = null;
		if(first) {
			if(Math.random()<0.9 && _firstFunctions.size()>0) {
				point = _firstFunctions.get((int)(Math.random()*_firstFunctions.size()));
			}
			else {
				point = _firstTerminals.get((int)(Math.random()*_firstTerminals.size()));
			}
		}
		else {
			if(Math.random()<0.9 && _secondFunctions.size()>0) {
				point = _secondFunctions.get((int)(Math.random()*_secondFunctions.size()));
			}
			else {
				point = _secondTerminals.get((int)(Math.random()*_secondTerminals.size()));
			}
		}
		return point;
		
		
	}

	private void initLists() {
		_firstFunctions=new ArrayList<Tree>();
		_secondFunctions=new ArrayList<Tree>();
		_firstTerminals=new ArrayList<Tree>();
		_secondTerminals=new ArrayList<Tree>();
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
