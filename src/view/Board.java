package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JPanel;

import controller.Controller;

public class Board extends JComponent {

	public Board(Controller ctrl) {
		initGUI();
	}
	
	public void initGUI() {
		
		
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gr = (Graphics2D) g;
		g.setColor(Color.red);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
