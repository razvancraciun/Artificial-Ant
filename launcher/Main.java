package launcher;

import javax.swing.SwingUtilities;


import controller.Controller;
import model.cross.ExchangeCross;
import model.entity.GeneticAlorithm;
import model.entity.Individual;
import model.mutation.InitializationMutation;
import model.mutation.Mutation;
import model.mutation.TerminalMutation;
import model.selection.RouletteSelection;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		
		GeneticAlorithm ga= new GeneticAlorithm(100, 4,500, 0.6, 0.05, new RouletteSelection(), new ExchangeCross(), new TerminalMutation(), 0);
		Controller ctrl=new Controller(ga);
		
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					MainWindow window=new MainWindow(ctrl);
					window.setSize(800,600);
					window.setVisible(true);
				}
			});
		}
		catch(Exception e) {
			System.out.println("Something went wrong...");
			System.out.println();
			e.printStackTrace();
		} 
		
	} 

}
