package model.cross;

<<<<<<< HEAD
import model.entity.Individual;
=======
import model.entity.Pair;
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250

public class NoCross implements Cross{

	@Override
<<<<<<< HEAD
	public void apply(Individual first, Individual second) {
=======
	public Pair apply(Pair original) {
		return original;
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
	}

}
