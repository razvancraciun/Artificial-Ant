package view;

import java.awt.Dimension;
<<<<<<< HEAD
import java.awt.Font;
=======
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import controller.Controller;
import model.cross.Cross;
import model.cross.ExchangeCross;
import model.entity.AlgorithmObserver;
import model.entity.Individual;
import model.mutation.Mutation;
import model.mutation.TerminalMutation;
import model.selection.DeterministicTournamentSelection;
=======
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import controller.Controller;
import model.cross.Cross;
import model.cross.NoCross;
import model.entity.AlgorithmObserver;
import model.entity.Individual;
import model.mutation.Mutation;
import model.mutation.NoMutation;
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
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
<<<<<<< HEAD
	private JButton _stop;
	private JSpinner _mutationChance;
	private JComboBox<Mutation> _mutation;
	private JSpinner _depth;
	private JSpinner _elitism;
	private JProgressBar _progress;
	private JTextArea _best;
	private JLabel _food;
	
	private Controller _ctrl;

	
	private Thread _thread;


=======
	private JSpinner _mutationChance;
	private JSpinner _depth;
	private JSpinner _elitism;
	
	
	private Controller _ctrl;
	
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
	
	
	public ControlPanel(Controller ctrl) {
		_ctrl=ctrl;
		ctrl.addObserver(this);
		initGUI();
	}
	
	private void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel generationsLabel = new JLabel("Number of generations:");
<<<<<<< HEAD
		generationsLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);

		_generations=new JSpinner(new SpinnerNumberModel(100,1,10000,10));
		_generations.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		JLabel populationLabel=new JLabel("Population size:");
		populationLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		_populationSize=new JSpinner(new SpinnerNumberModel(100,10,10000,10));
		_populationSize.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		JLabel depthLabel=new JLabel("Maximum depth:");
		depthLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		_depth=new JSpinner(new SpinnerNumberModel(4,2,10,1));
		_depth.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		JLabel selectionLabel = new JLabel("Selection:");
		selectionLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		Selection[] selections= {new DeterministicTournamentSelection() ,new RouletteSelection()};
		_selection = new JComboBox<Selection>(selections);
		_selection.setSelectedIndex(1);
		_selection.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		JLabel crossChanceLabel = new JLabel("Cross chance:"); 
		crossChanceLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		_crossChance= new JSpinner(new SpinnerNumberModel(0.6,0,1,0.05));
		_crossChance.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		JLabel mutationChanceLabel= new JLabel("Mutation chance:");
		mutationChanceLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		_mutationChance = new JSpinner(new SpinnerNumberModel(0.05,0,1,0.01));
		_mutationChance.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		JLabel mutationLabel = new JLabel("Mutation:");
		mutationLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		Mutation[] mutations = {new TerminalMutation()};
		_mutation = new JComboBox<Mutation>(mutations);
		_mutation.setSelectedIndex(0);
		_mutation.setAlignmentX(JLabel.LEFT_ALIGNMENT);		
		
		JLabel elitismLabel = new JLabel("Elitism:");
		elitismLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		_elitism=new JSpinner(new SpinnerNumberModel(0,0,1,0.01));
		_elitism.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		JLabel bestLabel = new JLabel("Best individual:");
		bestLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		_best=new JTextArea();
		_best.setEditable(false);
		_best.setLineWrap(true);
		_best.setPreferredSize(new Dimension(100,100));
		_best.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		_food = new JLabel("Food eaten: 0");
		_food.setFont(new Font("Serif",Font.BOLD,20));
		_food.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		JLabel progressLabel = new JLabel("Progress:");
		progressLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		_progress=new JProgressBar(0,100);
		_progress.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		
		_start=new JButton("Start");
		_stop=new JButton("Stop");

=======
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
		
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
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
<<<<<<< HEAD
		add(mutationLabel);
		add(_mutation);
		add(elitismLabel);
		add(_elitism);
		add(bestLabel);
		add(_best);
		add(_food);
		JPanel space1 = new JPanel();
		space1.setPreferredSize(new Dimension(50,500));
		add(space1);
		add(progressLabel);
		add(_progress);
		JPanel space2 = new JPanel();
		space2.setPreferredSize(new Dimension(50,500));
		add(space2);
		JPanel buttons = new JPanel();
		buttons.setAlignmentX(LEFT_ALIGNMENT);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.add(_start);
		buttons.add(_stop);
		add(buttons);
		JPanel space3 = new JPanel();
		space3.setPreferredSize(new Dimension(50,500));
		add(space3);
=======
		add(elitismLabel);
		add(_elitism);
		JPanel space = new JPanel();
		space.setPreferredSize(new Dimension(50,500));
		add(space);
		add(_start);
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
	}

	
	private void addListeners() {
		_start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
<<<<<<< HEAD
						
				_thread = new Thread(new Runnable() {

					@Override
					public void run() {
						
						_ctrl.init((int)_populationSize.getValue(),(int) _depth.getValue(), (double) _crossChance.getValue(), (double) _mutationChance.getValue(),
								(Selection) _selection.getSelectedItem(), (Cross) new ExchangeCross(), (Mutation) _mutation.getSelectedItem(), (double) _elitism.getValue());
						_ctrl.run((int)_generations.getValue());
						
						
	
					}
					
				});
				_thread.start();
			}
			
		});
		
		_stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				_thread.interrupt();
			}
			
		});
	}
	
	private void setFieldsActive(boolean value) {
		_populationSize.setEnabled(value);
		_generations.setEnabled(value);
		_selection.setEnabled(value);
		_crossChance.setEnabled(value);
		_start.setEnabled(value);
		_mutationChance.setEnabled(value);
		_mutation.setEnabled(value);
		_depth.setEnabled(value);
		_elitism.setEnabled(value);
	}
	
	
	@Override
	public void onNewGeneration(int generation,int best,int generationBest,double generationAvg) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				_progress.setValue(generation);
			}
			
		});
=======
				_ctrl.init((int)_populationSize.getValue(),(int) _depth.getValue(), (double) _crossChance.getValue(), (double) _mutationChance.getValue(),
						(Selection) _selection.getSelectedItem(), (Cross) new NoCross(), (Mutation) new NoMutation(), (double) _elitism.getValue());
				_ctrl.run((int)_generations.getValue());
			}
			
		});
	}
	
	@Override
	public void onNewGeneration(int generation, int best, int bestThisGeneration, int averageThisGeneration) {
		// TODO Auto-generated method stub
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
		
	}

	@Override
	public void onNewBest(Individual best) {
<<<<<<< HEAD
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				_best.setText(best.getTree().toString());
				_food.setText("Food eaten: " + best.getFitness());
			}
			
		});
=======
		// TODO Auto-generated method stub
		
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
	}

	@Override
	public void onStart() {
<<<<<<< HEAD
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				_progress.setMaximum((Integer)_generations.getValue());
				setFieldsActive(false);
			}
			
		});
=======
		// TODO Auto-generated method stub
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
		
	}

	@Override
	public void onEnd() {
<<<<<<< HEAD
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				setFieldsActive(true);
			}
			
		});
=======
		// TODO Auto-generated method stub
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
		
	}
}
