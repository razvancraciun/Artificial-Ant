package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;

public class MainWindow extends JFrame {

	private JPanel _mainPanel;
	private ControlPanel _controlPanel;
	private Board _graphicsPanel;
	
	public MainWindow(Controller ctrl) {
		super("Artificial ant");
		initGUI(ctrl);
	}
	
	private void initGUI(Controller ctrl) {
		_mainPanel=new JPanel();
		_mainPanel.setLayout(new BorderLayout());
		this.setContentPane(_mainPanel);
		_controlPanel=new ControlPanel(ctrl);
		_graphicsPanel=new Board(ctrl);
		_mainPanel.add(_controlPanel,BorderLayout.WEST);
		_mainPanel.add(_graphicsPanel,BorderLayout.CENTER);
	}
}
