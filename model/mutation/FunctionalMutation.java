package model.mutation;

import java.util.ArrayList;
import java.util.List;

import model.entity.Individual;
import model.misc.NonTerminal;
import model.misc.Tree;

public class FunctionalMutation implements Mutation {

	List<Tree> _functions;
	
	@Override
	public void apply(Individual source) {
		_functions= new ArrayList<Tree>();
		addFunctions(source.getTree());
		if(_functions.size()<=0) {
			return;
		}
		Tree chosen = _functions.get((int) (Math.random()*_functions.size()));
		
		if(chosen.getType()==NonTerminal.SEQ2) {
			chosen.setType(NonTerminal.IF);
		}
		else if(chosen.getType()==NonTerminal.IF) {
			chosen.setType(NonTerminal.SEQ2);
		}
	}
	
	public void addFunctions(Tree root) {
		if(root.getType().getClass()==NonTerminal.class&& root.getType()!=NonTerminal.SEQ3) {
			_functions.add(root);
		}
		for(Tree child : root.getChildren()) {
			addFunctions(child);
		}
	}

	public String toString() {
		return "Functional";
	}
}
