package view.client.components.affective;
/**
 * Class to plot affective graph
 *
 * @author spraka10
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import network.model.Status;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import util.ServerConstants;


public class AffectiveTimeSeriesGraph {

    /**
     * The time Series data.
     */
    private TimeSeries interestSeries;
    private TimeSeries engagementSeries;
    private TimeSeries stressSeries;
    private TimeSeries relaxationSeries;
    private TimeSeries excitementSeries;
    private TimeSeries focusSeries;
    static JPanel content;
    private ChartPanel chartPanel;
    private JFreeChart chart;

    private Color interestColor;
    private Color engagementColor;
    private Color stressColor;
    private Color relaxationColor;
    private Color excitementColor;
    private Color focusColor;

    public Color getInterestColor() {
        return interestColor;
    }

    public void setInterestColor(Color interestColor) {
        this.interestColor = interestColor;
    }


    public Color getEngagementColor() {
        return engagementColor;
    }

    public void setEngagementColor(Color engagementColor) {
        this.engagementColor = engagementColor;
    }


    public Color getStressColor() {
        return stressColor;
    }

    public void setStressColor(Color stressColor) {
        this.stressColor = stressColor;
    }


    public Color getRelaxationColor() {
        return relaxationColor;
    }

    public void setRelaxationColor(Color relaxationColor) {
        this.relaxationColor = relaxationColor;
    }

    public Color getExcitementColor() {
        return excitementColor;
    }

    public void setExcitementColor(Color excitementColor) {
        this.excitementColor = excitementColor;
    }

    public Color getFocusColor() {
        return focusColor;
    }

    public void setFocusColor(Color focusColor) {
        this.focusColor = focusColor;
    }


    /**
     * Constructs a new graph application.
     *
     * @param title the frame title.
     */
    public AffectiveTimeSeriesGraph(final String title) {

        //super(title);
        this.interestSeries = new TimeSeries("interest", Millisecond.class);
        this.engagementSeries = new TimeSeries("engagement", Millisecond.class);
        this.stressSeries = new TimeSeries("stress", Millisecond.class);
        this.relaxationSeries = new TimeSeries("relaxation", Millisecond.class);
        this.excitementSeries = new TimeSeries("excitement", Millisecond.class);
        this.focusSeries = new TimeSeries("focus", Millisecond.class);
        setColors();

        chart = createChart(createDataSet());

        chartPanel = new ChartPanel(chart);

        content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 500));
        //setContentPane(chartPanel);
    }

    public TimeSeriesCollection createDataSet(){
        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(this.interestSeries);
        dataset.addSeries(this.engagementSeries);
        dataset.addSeries(this.stressSeries);
        dataset.addSeries(this.relaxationSeries);
        dataset.addSeries(this.excitementSeries);
        dataset.addSeries(this.focusSeries);
        return dataset;
    }

    /**
     * Creates a time series chart.
     *
     * @param dataset the dataset.
     * @return A time series chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {
        JFreeChart result = ChartFactory.createTimeSeriesChart(
                "",
                "",
                "",
                dataset,
                true,
                true,
                false
        );

        final XYPlot plot = result.getXYPlot();

        /* //Method 1
        DefaultDrawingSupplier drawingSupplier = new DefaultDrawingSupplier(
                new Paint[] { Color.GREEN, Color.RED, Color.BLUE, Color.MAGENTA, Color.BLACK, Color.CYAN },
                DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE);
        plot.setDrawingSupplier(drawingSupplier);*/

         //Method 2
        plot.getRenderer().setSeriesPaint(0, interestColor);
        plot.getRenderer().setSeriesPaint(1, engagementColor);
        plot.getRenderer().setSeriesPaint(2, stressColor);
        plot.getRenderer().setSeriesPaint(3, relaxationColor);
        plot.getRenderer().setSeriesPaint(4, excitementColor);
        plot.getRenderer().setSeriesPaint(5, focusColor);

        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(60000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 1.0);
        axis.setVerticalTickLabels(false);
        axis.setTickLabelsVisible(false);
        return result;
    }

   private void setColors(){
        interestColor = Color.MAGENTA;
        engagementColor = Color.BLUE;
        stressColor = Color.GRAY;
        relaxationColor = Color.BLACK;
        excitementColor = Color.CYAN;
        focusColor = Color.RED;
   }


    /**
     * update the time series data from server status for affective values
     *
     * @param status
     */
    public void update(Status status) {

    	
        this.interestSeries.addOrUpdate(new Millisecond(), status.getInterest());

        this.engagementSeries.addOrUpdate(new Millisecond(), status.getEngagement());
        this.stressSeries.addOrUpdate(new Millisecond(), status.getStress());
        this.excitementSeries.addOrUpdate(new Millisecond(), status.getExcitement());
        this.relaxationSeries.addOrUpdate(new Millisecond(), status.getRelaxation());
        this.focusSeries.addOrUpdate(new Millisecond(), status.getFocus());


    }

    public void updateGraph(){
        content.remove(chartPanel);
        chart = createChart(createDataSet());
        chartPanel = new ChartPanel(chart);
        content.add(chartPanel);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 500));
        content.setVisible(true);
        //update(Status.getInstance());
    }
    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    public static void main(final String[] args) throws InterruptedException {
        final AffectiveTimeSeriesGraph demo = new AffectiveTimeSeriesGraph("Affective Graph");

        JFrame jFrame = new JFrame("Affective Graph JPanel");
        jFrame.setVisible(true);
        jFrame.setSize(600, 400);
        jFrame.add(content);

        //demo.pack();
        //RefineryUtilities.centerFrameOnScreen(demo);
        //demo.setVisible(true);

        Status status =Status.getInstance();
        int x = 0;
        while (x < 1000) {
            status.setInterest(new Random().nextDouble());
            status.setEngagement(new Random().nextDouble());
            status.setExcitement(new Random().nextDouble());
            status.setRelaxation(new Random().nextDouble());
            status.setFocus(new Random().nextDouble());
            demo.update(status);
            Thread.sleep(1000);
        }
    }
    private static AffectiveTimeSeriesGraph affectiveTimeSeriesGraph;

    public static AffectiveTimeSeriesGraph getinstance() {
        if (affectiveTimeSeriesGraph == null) {
            affectiveTimeSeriesGraph = new AffectiveTimeSeriesGraph("Affective Graph");
        }
        return affectiveTimeSeriesGraph;
    }

    public static JPanel getPanel() {
        JPanel affectiveGraph = new JPanel();

        //JLabel instructions = new JLabel("Graph displaying affective data", JLabel.CENTER);
        affectiveGraph.add(content);

        return affectiveGraph;
    }

}
