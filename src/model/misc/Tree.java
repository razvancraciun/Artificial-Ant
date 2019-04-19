package model.misc;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	
	private List<Tree> children;
	private NodeType type;
	private int depth;
	private Tree parent;
	
	public Tree(NodeType type) {
		this.type=type;
		children=new ArrayList<Tree>();
	}
	
	public Tree(Tree other) {
		this.type=other.getType();
		children=new ArrayList<Tree>();
		for(int i=0;i<other.getChildren().size();i++) {
			this.children.add(new Tree(other.getChild(i)));
		}
		this.depth=other.getDepth();
	}
	
	public Tree getParent() {
		return parent;
	}
	
	private void setParent(Tree tree) {
		parent = tree;
	}
	
	
	public List<Tree> getChildren() {
		return children;
	}
	
	public NodeType getType() {
		return type;
	}

	public void setType(NodeType type) {
		this.type = type;
	}

	public void addChild(Tree tree) {
		tree.setParent(this);
		children.add(tree);
	}
	
	public void removeChild(Tree tree) {
		children.remove(tree);
	}
	
	public Tree getChild(int index) {
		return children.get(index);
	}
	
	public void computeDepths() {
		if(type.getClass()==Terminal.class) {
			depth=1;
		}
		else {
			int max=0;
			for(Tree t: children) {
				t.computeDepths();
				if(max<t.getDepth()) {
					max=t.getDepth();
				}
			}
			depth=max+1;
		}
	}
	
	public int getDepth() {
		return depth;
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

	public void replaceChild(Tree point1, Tree point2) {
		children.set(children.indexOf(point1),point2);
	}
	
	
}
