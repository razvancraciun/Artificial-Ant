package model.entity;

public class Pair {

	private Individual _first;
	private Individual _second;
	
	public Pair(Individual first,Individual second) {
		_first=first;
		_second=second;
	}
	
	public Individual getFirst() {
		return _first;
	}
	public Individual getSecond() {
		return _second;
	}
}
