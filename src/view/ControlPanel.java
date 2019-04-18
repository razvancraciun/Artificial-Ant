package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import controller.Controller;
import model.cross.Cross;
import model.cross.NoCross;
import model.entity.AlgorithmObserver;
import model.entity.Individual;
import model.mutation.Mutation;
import model.mutation.NoMutation;
import model.selection.NoSelection;
import model.selection.RouletteSelection;
import model.selection.Selection;

public class ControlPanel extends JPanel implements AlgorithmObserver {
	private static final long serialVersionUID = -5855602882300724686L;
	
	private JSpinner _populationSize;
	private JSpinner _generations;
	private JComboBox<Selection> _selection;
	private JSpinner _crossChance;
	private JButton _start;
	private JSpinner _mutationChance;
	private JSpinner _depth;
	private JSpinner _elitism;
	
	
	private Controller _ctrl;
	
	
	
	public ControlPanel(Controller ctrl) {
		_ctrl=ctrl;
		ctrl.addObserver(this);
		initGUI();
	}
	
	private void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel generationsLabel = new JLabel("Number of generations:");
		_generations=new JSpinner(new SpinnerNumberModel(100,1,10000,10));
		
		JLabel populationLabel=new JLabel("Population size:");
		_populationSize=new JSpinner(new SpinnerNumberModel(100,10,10000,10));
		
		JLabel depthLabel=new JLabel("Maximum depth:");
		_depth=new JSpinner(new SpinnerNumberModel(4,2,10,1));
		
		
		JLabel selectionLabel = new JLabel("Selection:");
		Selection[] selections= {new NoSelection(),new RouletteSelection()};
		_selection = new JComboBox<Selection>(selections);
		_selection.setSelectedIndex(1);
		
		JLabel crossChanceLabel = new JLabel("Cross chance:"); 
		_crossChance= new JSpinner(new SpinnerNumberModel(0.6,0,1,0.05));
		
		JLabel mutationChanceLabel= new JLabel("Mutation chance:");
		_mutationChance = new JSpinner(new SpinnerNumberModel(0.05,0,1,0.01));
		
		JLabel elitismLabel = new JLabel("Elitism:");
		_elitism=new JSpinner(new SpinnerNumberModel(0,0,1,0.01));
		
		_start=new JButton("Start");
		
		addListeners();
		
		add(generationsLabel);
		add(_generations);
		add(populationLabel);
		add(_populationSize);
		add(depthLabel);
		add(_depth);
		add(selectionLabel);
		add(_selection);
		add(crossChanceLabel);
		add(_crossChance);
		add(mutationChanceLabel);
		add(_mutationChance);
		add(elitismLabel);
		add(_elitism);
		JPanel space = new JPanel();
		space.setPreferredSize(new Dimension(50,500));
		add(space);
		add(_start);
	}

	
	private void addListeners() {
		_start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				_ctrl.init((int)_populationSize.getValue(),(int) _depth.getValue(), (double) _crossChance.getValue(), (double) _mutationChance.getValue(),
						(Selection) _selection.getSelectedItem(), (Cross) new NoCross(), (Mutation) new NoMutation(), (double) _elitism.getValue());
				_ctrl.run((int)_generations.getValue());
			}
			
		});
	}
	
	@Override
	public void onNewGeneration(int generation, int best, int bestThisGeneration, int averageThisGeneration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNewBest(Individual best) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnd() {
		// TODO Auto-generated method stub
		
	}
}
