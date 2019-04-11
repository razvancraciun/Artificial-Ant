package model.misc;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	
	private List<Tree> children;
	private NodeType type;
	
	
	public Tree(NodeType type) {
		this.type=type;
		children=new ArrayList<Tree>();
		
	}
	
	public NodeType getType() {
		return type;
	}

	public void setType(NodeType type) {
		this.type = type;
	}

	public void addChild(Tree tree) {
		children.add(tree);
	}
	
	public String toString() {
		String result=""+type;
		if(type.getClass()==NonTerminal.class)
			result+="(";
		for(int i=0;i<children.size()-1;i++) {
			result+=children.get(i)+",";
		}
		if(children.size()>1)
			result+=children.get(children.size()-1);
		if(type.getClass()==NonTerminal.class)
			result+=")";
		return result;
	}
	
	
}
