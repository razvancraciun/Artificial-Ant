package view;


import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.JTabbedPane;
=======
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250

import controller.Controller;

public class MainWindow extends JFrame {
	//private static final long serialVersionUID = -7907731647470797405L;
	
	private JPanel _mainPanel;
	private ControlPanel _controlPanel;
	private Board _graphicsPanel;
<<<<<<< HEAD
	private Plot _plotPanel;
=======
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
	
	public MainWindow(Controller ctrl) {
		super("Artificial ant");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initGUI(ctrl);
	}
	
	private void initGUI(Controller ctrl) {
		_mainPanel=new JPanel();
		_mainPanel.setLayout(new BorderLayout());
		this.setContentPane(_mainPanel);
		_controlPanel=new ControlPanel(ctrl);
		_graphicsPanel=new Board(ctrl);
<<<<<<< HEAD
		_plotPanel=new Plot(ctrl);
=======
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
		JPanel cpContainer = new JPanel(new BorderLayout());
		cpContainer.add(_controlPanel,BorderLayout.CENTER);
		cpContainer.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
<<<<<<< HEAD
		JTabbedPane center = new JTabbedPane();
		center.addTab("Board", _graphicsPanel);
		center.addTab("Plot", _plotPanel);
		
		
		_mainPanel.add(cpContainer,BorderLayout.WEST);
		_mainPanel.add(center,BorderLayout.CENTER);
=======
		JPanel graphicsContainer = new JPanel(new BorderLayout());
		graphicsContainer.add(_graphicsPanel,BorderLayout.CENTER);
		//graphicsContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
		
		_mainPanel.add(cpContainer,BorderLayout.WEST);
		_mainPanel.add(graphicsContainer,BorderLayout.CENTER);
>>>>>>> 9b598c4e67b0c7e7e5e80bec1596c817cfe36250
	}
}
