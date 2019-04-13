package launcher;

import controller.Controller;
import model.entity.Individual;
import model.entity.Population;
import model.misc.Field;
import model.misc.Tree;
import model.misc.TreeFactory;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		/*Controller ctrl=new Controller();
		
		MainWindow window=new MainWindow(ctrl);
		window.setSize(300,300);
		window.setVisible(true);;
		*/
		Population p = new Population(100,4);
		p.evaluate();
		System.out.println(p);
	}

}
