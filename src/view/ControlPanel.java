package view;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import controller.Controller;
import model.selection.NoSelection;
import model.selection.Selection;

public class ControlPanel extends JPanel {

	private JSpinner _populationSize;
	private JSpinner _generations;
	private JComboBox _selection;
	private JSpinner _crossChance;
	
	public ControlPanel(Controller ctrl) {
		initGUI();
	}
	
	private void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel populationLabel=new JLabel("Population size:");
		_populationSize=new JSpinner(new SpinnerNumberModel(100,10,10000,10));
		
		JLabel generationsLabel = new JLabel("Number of generations:");
		_generations=new JSpinner(new SpinnerNumberModel(100,10,10000,10));
		
		JLabel selectionLabel = new JLabel("Selection:");
		Object[] selections= {new NoSelection()};
		_selection = new JComboBox(selections);
		
		JLabel crossChanceLabel = new JLabel("Cross chance:"); 
		_crossChance= new JSpinner(new SpinnerNumberModel(0.6,0,1,0.05));
		
		
		add(populationLabel);
		add(_populationSize);
		add(generationsLabel);
		add(_generations);
		add(selectionLabel);
		add(_selection);
		add(crossChanceLabel);
		add(_crossChance);
	}
}
