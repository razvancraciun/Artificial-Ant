package view;


import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.Controller;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = -7907731647470797405L;
	
	private JPanel _mainPanel;
	private ControlPanel _controlPanel;
	private Board _graphicsPanel;
	private Plot _plotPanel;
	
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
		_plotPanel=new Plot(ctrl);
		JPanel cpContainer = new JPanel(new BorderLayout());
		cpContainer.add(_controlPanel,BorderLayout.CENTER);
		cpContainer.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		JTabbedPane center = new JTabbedPane();
		center.addTab("Board", _graphicsPanel);
		center.addTab("Plot", _plotPanel);
		
		
		_mainPanel.add(cpContainer,BorderLayout.WEST);
		_mainPanel.add(center,BorderLayout.CENTER);
	}
}
