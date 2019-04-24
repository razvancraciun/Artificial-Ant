package model.entity;

import model.misc.Field;
import model.misc.NonTerminal;
import model.misc.Terminal;
import model.misc.Tree;
import model.misc.TreeFactory;

public class Individual {

	private int _fitness;
	private Tree _tree;
	private int _maxDepth;
	private int _maxSteps;
	
	private int _steps;
	private int _food;
	private enum Face {LEFT,RIGHT,UP,DOWN};
	private Face _face;
	private int _xPos;
	private int _yPos;
	private String[][] _field;
 	
	public Individual(int depth,boolean complete, int steps) {
		_maxSteps=steps;
		_xPos=_yPos=0;
		_face=Face.RIGHT;
		_field=Field.getInstance().getNewField();
		_fitness=0;
		_maxDepth=depth;
		if(complete) {
			_tree=TreeFactory.getInstance().buildCompleteTree(depth);
		}
		else {
			_tree=TreeFactory.getInstance().buildGrowthTree(depth);
		}
	}
	
	public Individual(Individual other) {
		_fitness=other.getFitness();
		_maxDepth=other.getMaxDepth();
		_tree=new Tree(other.getTree());
		_field=Field.getCopy(other.getField());
		_maxSteps=other.getMaxSteps();
	}
	
	public int getMaxSteps() {
		return _maxSteps;
	}
	
	public Tree getTree() {
		return _tree;
	}
	
	public int getFitness() {
		return _fitness;
	}
	
	public int getMaxDepth() {
		return _maxDepth;
	}
	
	public void setTree(Tree tree) {
		this._tree=tree;
	}
	
	public void evaluate() {
		_xPos=_yPos=0;
		_face=Face.RIGHT;
		_fitness=0;
		_field = Field.getInstance().getNewField();
		_steps=_food=0;
		while(_steps<_maxSteps&& _food<90) {
			evaluateTree(_tree);
		}
		_fitness=_food;
	}
	
	public void evaluateTree(Tree tree) {
		
		if(tree.getType()==Terminal.ADVANCE) {
			advance();
			_steps++;
		}
		else if(tree.getType()==Terminal.LEFT) {
			left();
			_steps++;
		}
		else if(tree.getType()==Terminal.RIGHT) {
			right();
			_steps++;
		}
		else if(tree.getType()==NonTerminal.SEQ2) {
			evaluateTree(tree.getChild(0));
			evaluateTree(tree.getChild(1));
		}
		else if(tree.getType()==NonTerminal.SEQ3) {
			evaluateTree(tree.getChild(0));
			evaluateTree(tree.getChild(1));
			evaluateTree(tree.getChild(2));
		}
		else if(tree.getType()==NonTerminal.IF) {
			switch(_face) {
			case UP:
				if(_field[mod(_yPos-1,_field.length)][_xPos].contains("#")) {
					evaluateTree(tree.getChild(0));
				}
				else evaluateTree(tree.getChild(1));
				break;
			case DOWN:
				if(_field[mod(_yPos+1,_field.length)][_xPos].contains("#")) {
					evaluateTree(tree.getChild(0));
				}
				else evaluateTree(tree.getChild(1));
				break;
			case LEFT:
				if(_field[_yPos][mod(_xPos-1,_field[0].length)].contains("#")) {
					evaluateTree(tree.getChild(0));
				}
				else evaluateTree(tree.getChild(1));
				break;
			case RIGHT:
				if(_field[_yPos][mod(_xPos+1,_field[0].length)].contains("#")) {
					evaluateTree(tree.getChild(0));
				}
				else evaluateTree(tree.getChild(1));
				break;
			default:
				throw new IllegalArgumentException("Invalid face @ if");
		
			}
		}
		else throw new IllegalArgumentException("Unsupported node type");
	}
	
	public void advance() {
		switch(_face) {
		case RIGHT: 
			_xPos=mod(_xPos+1,_field[0].length);
			break;
		case LEFT:
			_xPos=mod(_xPos-1,_field[0].length);
			break;
		
		case UP:
			_yPos=mod(_yPos-1,_field.length);
			break;
		case DOWN:
			_yPos=mod(_yPos+1,_field.length);
			break;		
		default:
			throw new IllegalArgumentException("Invalid face");
		}
		
		if(_field[_yPos][_xPos].equals("#")) {//food
			_field[_yPos][_xPos]="$"; //food eaten
			_food++;
		}
		else if(_field[_yPos][_xPos].contains("0")) {
			_field[_yPos][_xPos]="@"; //no food found
		}
	}
	
	public void printField() {
		String print="";
		for(int i=0;i<_field.length;i++) {
			for(int j=0;j<_field[0].length;j++) {
				print += _field[i][j] + " ";
			}
			print+="\n";
		}
		System.out.println(print);
	}
	
	public void left() {
		switch(_face) {
		case UP: 
			_face=Face.LEFT;
			break;
		case LEFT:
			_face=Face.DOWN;
			break;
		case DOWN:
			_face=Face.RIGHT;
			break;
		case RIGHT:
			_face=Face.UP;
			break;
		default:
			throw new IllegalArgumentException("BAD FACE @ left");
		}
	}
	public void right() {
		switch(_face) {
		case UP: 
			_face=Face.RIGHT;
			break;
		case LEFT:
			_face=Face.UP;
			break;
		case DOWN:
			_face=Face.LEFT;
			break;
		case RIGHT:
			_face=Face.DOWN;
			break;
		default:
			throw new IllegalArgumentException("BAD FACE @ right");
		}
	}
	
	public String[][] getField() {
		return _field;
	}
	
	public String toString() {
		return _tree.toString() + " |||Food: "+ _fitness;
	}
	
	private int mod(int x, int y)
	{
	    int result = x % y;
	    if (result < 0)
	    {
	        result += y;
	    }
	    return result;
	}
}
