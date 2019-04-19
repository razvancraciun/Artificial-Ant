package model.mutation;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import model.entity.Individual;
import model.misc.NodeType;
import model.misc.Terminal;
import model.misc.Tree;
import model.misc.TreeFactory;

public class TerminalMutation implements Mutation {
	
	private List<Tree> _terminals;
	
	@Override
	public void apply(Individual source) {
		_terminals = new ArrayList<Tree>();
		
		addTerminals(source.getTree());
		
		int choice = (int) (Math.random()*_terminals.size());
		NodeType current = _terminals.get(choice).getType();
		NodeType replace = TreeFactory.getInstance().getRandomTerminal();
		
		while(current.equals(replace)) {
			replace=TreeFactory.getInstance().getRandomTerminal();
		}
		
		_terminals.get(choice).setType(replace);
		
		return;
	}
	
	private void addTerminals(Tree tree) {
		if(tree.getType().getClass()==Terminal.class) {
			_terminals.add(tree);
		}
		else {
			for(Tree child : tree.getChildren()) {
				addTerminals(child);
			}
		}
	}
	
	public String toString() {
		return "Terminal";
	}
=======
import model.entity.Individual;

public class TerminalMutation implements Mutation {
	
	@Override
	public void apply(Individual source) {
		// TODO Auto-generated method stub
		return;
	}
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250

}
