package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
<<<<<<< HEAD
import javax.swing.SwingUtilities;
=======
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250

import controller.Controller;
import model.entity.AlgorithmObserver;
import model.entity.Individual;
import model.misc.Field;

public class Board extends JComponent implements AlgorithmObserver {
	private static final long serialVersionUID = -5962146845734641733L;
	
	
	private String[][] _field;
	
	public Board(Controller ctrl) {
		_field=Field.getInstance().getNewField();
		ctrl.addObserver(this);
		initGUI();
		
	}
	
	public void initGUI() {
	
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gr = (Graphics2D) g;
		
		int squareWidth = getWidth()/_field[0].length-1;
		int squareHeight = getHeight()/_field.length-1;
		
		for(int i=0;i<_field.length;i++) {
			for(int j=0;j<_field[i].length;j++) {
				if(_field[i][j].contains("#")) {
					//uneaten food
					gr.setColor(Color.RED);
					gr.fillRect(10+j*squareWidth, 10+i*squareHeight, squareWidth-4, squareHeight-4);
				}
				else if(_field[i][j].contains("@")) {
					//passed over but no food found
					gr.setColor(Color.YELLOW);
					gr.fillRect(10+j*squareWidth, 10+i*squareHeight, squareWidth-4, squareHeight-4);
				}
				else if(_field[i][j].contains("$")) {
					gr.setColor(Color.GREEN);
					gr.fillRect(10+j*squareWidth, 10+i*squareHeight, squareWidth-4, squareHeight-4);
				}
				else {
					gr.setColor(Color.BLACK);
					gr.drawRect(10+j*squareWidth, 10+i*squareHeight, squareWidth-4, squareHeight-4);
				}
				
			}
		}
	}

<<<<<<< HEAD

	@Override
	public void onNewBest(Individual best) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				_field=best.getField();
				repaint();
			}
		});
=======
	@Override
	public void onNewGeneration(int generation, int best, int bestThisGeneration, int averageThisGeneration) {
		// TODO Auto-generated method stub
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
		
	}

	@Override
<<<<<<< HEAD
	public void onStart() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				_field=Field.getInstance().getNewField();
			}
		});
		
	}

	@Override
	public void onEnd() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				repaint();
			}
		});
		
	}

	@Override
	public void onNewGeneration(int generation,int best,int generationBest,double generationAvg) {
		// TODO Auto-generated method stub
		
=======
	public void onNewBest(Individual best) {
		//System.out.println("new best");
		_field=best.getField();
	}

	@Override
	public void onStart() {
		_field=Field.getInstance().getNewField();
	}

	@Override
	public void onEnd() {
		
		repaint();
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
	}
}
