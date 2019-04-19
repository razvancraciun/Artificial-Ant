package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
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


	
	
	public ControlPanel(Controller ctrl) {
		_ctrl=ctrl;
		ctrl.addObserver(this);
		initGUI();
	}
	
	private void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel generationsLabel = new JLabel("Number of generations:");
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
	}

	
	private void addListeners() {
		_start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
						
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
		
	}

	@Override
	public void onNewBest(Individual best) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				_best.setText(best.getTree().toString());
				_food.setText("Food eaten: " + best.getFitness());
			}
			
		});
	}

	@Override
	public void onStart() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				_progress.setMaximum((Integer)_generations.getValue());
				setFieldsActive(false);
			}
			
		});
		
	}

	@Override
	public void onEnd() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				setFieldsActive(true);
			}
			
		});
		
	}
}
