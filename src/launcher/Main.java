package launcher;

import controller.Controller;
import model.cross.NoCross;
import model.entity.GeneticAlorithm;
import model.mutation.NoMutation;
import model.selection.NoSelection;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		GeneticAlorithm ga= new GeneticAlorithm(100, 4, 0.6, 0.05, new NoSelection(), new NoCross(), new NoMutation(), 0);
		Controller ctrl=new Controller(ga);
		
		
		MainWindow window=new MainWindow(ctrl);
		window.setSize(800,600);
		window.setVisible(true);
	}

}
