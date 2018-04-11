package view.client.components.affective;
/**
 * Class to plot affective graph
 *
 * @author Team 7 Affective Tne Series panel
 */
import java.awt.*;

import javax.swing.*;

import network.model.Status;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import util.ServerConstants;

public class AffectiveTimeSeriesGraph {

  /** The time Series data. */
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
  private Double displayLength;

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

  public Double getDisplayLength() {
    return displayLength;
  }

  public void setDisplayLength(Double displayLength) {
    this.displayLength = displayLength;
  }

  /**
   * Constructs a new graph application.
   *
   * @param title the frame title.
   */
  public AffectiveTimeSeriesGraph(final String title) {

    // super(title);
    this.interestSeries = new TimeSeries(ServerConstants.INTEREST, Millisecond.class);
    this.engagementSeries = new TimeSeries(ServerConstants.ENGAGEMENT, Millisecond.class);
    this.stressSeries = new TimeSeries(ServerConstants.STRESS, Millisecond.class);
    this.relaxationSeries = new TimeSeries(ServerConstants.RELAXATION, Millisecond.class);
    this.excitementSeries = new TimeSeries(ServerConstants.EXCITEMENT, Millisecond.class);
    this.focusSeries = new TimeSeries(ServerConstants.FOCUS, Millisecond.class);
    this.displayLength = 60000.0; // 60 seconds
    setColors();

    chart = createChart(createDataSet());

    chartPanel = new ChartPanel(chart);

    content = new JPanel(new BorderLayout());
    content.add(chartPanel);
    chartPanel.setPreferredSize(new java.awt.Dimension(400, 500));
  }

  public TimeSeriesCollection createDataSet() {
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
    JFreeChart result = ChartFactory.createTimeSeriesChart("", "", "", dataset, false, true, false);

    final XYPlot plot = result.getXYPlot();

    plot.getRenderer().setSeriesPaint(0, interestColor);
    plot.getRenderer().setSeriesPaint(1, engagementColor);
    plot.getRenderer().setSeriesPaint(2, stressColor);
    plot.getRenderer().setSeriesPaint(3, relaxationColor);
    plot.getRenderer().setSeriesPaint(4, excitementColor);
    plot.getRenderer().setSeriesPaint(5, focusColor);

    ValueAxis axis = plot.getDomainAxis();
    axis.setAutoRange(true);
    axis.setFixedAutoRange(displayLength); // 60 seconds
    axis = plot.getRangeAxis();
    axis.setRange(0.0, 1.0);
    axis.setVerticalTickLabels(false);
    axis.setTickLabelsVisible(false);

    return result;
  }

  private void setColors() {
    interestColor = Color.MAGENTA;
    engagementColor = Color.BLUE;
    stressColor = Color.GRAY;
    relaxationColor = Color.ORANGE;
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

  public void updateGraph() {
    content.remove(chartPanel);
    chart = createChart(createDataSet());
    chartPanel = new ChartPanel(chart);
    content.add(chartPanel);
    chartPanel.setPreferredSize(new java.awt.Dimension(400, 500));
    content.setVisible(true);
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
    affectiveGraph.add(content);
    return affectiveGraph;
  }
}
