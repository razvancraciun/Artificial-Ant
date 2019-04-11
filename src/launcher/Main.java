package launcher;

import model.entity.Population;
import model.misc.Tree;
import model.misc.TreeFactory;

public class Main {

	public static void main(String[] args) {
		
		/*TreeFactory tf=TreeFactory.getInstance();
		Tree ctree = tf.buildCompleteTree(3);
		Tree gtree = tf.buildGrowthTree(3);

		
		System.out.println(ctree);
		System.out.println(gtree); */ //okay if growth trees can output just one node??
		
		
		Population p = new Population(10,4);
		System.out.println(p);
	}

}
