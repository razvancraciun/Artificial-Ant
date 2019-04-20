package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import controller.Controller;
import model.entity.AlgorithmObserver;
import model.entity.Individual;

public class Plot extends JPanel implements AlgorithmObserver {

	private JFreeChart _chart;
	private ChartPanel _chartPanel;
	private XYSeriesCollection _dataset;
	private XYSeries _best;
	private XYSeries _generationBest;
	private XYSeries _generationAverage;
	
	
	public Plot(Controller ctrl) {
		ctrl.addObserver(this);
		setLayout(new BorderLayout());
		_dataset = new XYSeriesCollection();
		_best=new XYSeries("Best");
		_generationBest=new XYSeries("Generation best");
		_generationAverage=new XYSeries("Generation average");
		_dataset.addSeries(_best);
		_dataset.addSeries(_generationBest);
		_dataset.addSeries(_generationAverage);
		 _chart = ChartFactory.createXYLineChart(
		        "Artificial ant", 
		        "Generations", 
		        "Food", _dataset);
		_chartPanel = new ChartPanel(_chart);
		add(_chartPanel,BorderLayout.CENTER);
		_chart.getXYPlot().getRenderer().setSeriesStroke(0, new BasicStroke(2.0f));
		_chart.getXYPlot().getRenderer().setSeriesStroke(1, new BasicStroke(2.0f));
		_chart.getXYPlot().getRenderer().setSeriesStroke(2, new BasicStroke(2.0f));
	}
	
	
	
	
	
	@Override
	public void onNewGeneration(int generation,int best,int generationBest,double generationAvg) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				_best.add(generation,best);
				_generationBest.add(generation, generationBest);
				_generationAverage.add(generation, generationAvg);
			}
			
		});
		
	}
	@Override
	public void onNewBest(Individual best) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStart() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				_best.clear();
				_generationBest.clear();
				_generationAverage.clear();
			}
			
		});
	}
	@Override
	public void onEnd() {
		// TODO Auto-generated method stub
		
	}
	
}
