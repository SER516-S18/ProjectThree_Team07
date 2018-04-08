package view.client.components.affective;
/**
 * Class to plot affective graph
 *
 * @author spraka10
 */

import java.awt.BorderLayout;
import java.util.Random;

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
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class AffectiveTimeSeriesGraph {

    /**
     * The time Series data.
     */
    private TimeSeries mediationSeries;
    private TimeSeries engagementBoredomeSeries;
    private TimeSeries excitementShortTermSeries;
    private TimeSeries frustrationSeries;
    private TimeSeries excitementLongTermSeries;
    static JPanel content;

    /**
     * Constructs a new graph application.
     *
     * @param title the frame title.
     */
    public AffectiveTimeSeriesGraph(final String title) {

        //super(title);
        this.mediationSeries = new TimeSeries("Mediation", Millisecond.class);
        this.engagementBoredomeSeries = new TimeSeries("engagement Boredome", Millisecond.class);
        this.excitementShortTermSeries = new TimeSeries("excitement short term", Millisecond.class);
        this.frustrationSeries = new TimeSeries("frustration", Millisecond.class);
        this.excitementLongTermSeries = new TimeSeries("excitement long term", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(this.mediationSeries);
        dataset.addSeries(this.engagementBoredomeSeries);
        dataset.addSeries(this.excitementShortTermSeries);
        dataset.addSeries(this.frustrationSeries);
        dataset.addSeries(this.excitementLongTermSeries);
        final JFreeChart chart = createChart(dataset);

        final ChartPanel chartPanel = new ChartPanel(chart);

        content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        //setContentPane(content);

    }

    /**
     * Creates a time series chart.
     *
     * @param dataset the dataset.
     * @return A time series chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
                "",
                "",
                "",
                dataset,
                true,
                true,
                false
        );
        final XYPlot plot = result.getXYPlot();
        ValueAxis axis = plot.getRangeAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(60000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 1.0);
        axis.setVerticalTickLabels(false);
        axis.setTickLabelsVisible(false);
        return result;
    }

    public  void startplotting() throws InterruptedException{
        Status status = Status.getInstance();
        int x = 0;
        while (x < 1000) {
            status.setMediation(new Random().nextDouble() * 100);
            status.setEngagementBoredom(new Random().nextDouble() * 100);
            status.setExcitementShortTerm(new Random().nextDouble() * 100);
            status.setExcitementLongTerm(new Random().nextDouble() * 100);
            status.setFrustration(new Random().nextDouble() * 100);
            update(status);
            Thread.sleep(1000);
        }
    }

    /**
     * update the time series data from server status for affective values
     * @param status
     */
    public void update(Status status) {

        this.mediationSeries.addOrUpdate(new Millisecond(), status.getMediation());
        this.engagementBoredomeSeries.addOrUpdate(new Millisecond(), status.getEngagementBoredom());
        this.excitementShortTermSeries.addOrUpdate(new Millisecond(), status.getExcitementShortTerm());
        this.excitementLongTermSeries.addOrUpdate(new Millisecond(), status.getExcitementLongTerm());
        this.frustrationSeries.addOrUpdate(new Millisecond(), status.getFrustration());

    }

   /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     *//*
    public static void main(final String[] args) throws InterruptedException {

        final AffectiveTimeSeriesGraph demo = new AffectiveTimeSeriesGraph("Affective Graph");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

        Status status = new Status();
        int x = 0;
        while (x < 1000) {
            status.setMediation(new Random().nextDouble() * 100);
            status.setEngagementBoredom(new Random().nextDouble() * 100);
            status.setExcitementShortTerm(new Random().nextDouble() * 100);
            status.setExcitmentLongTerm(new Random().nextDouble() * 100);
            status.setFrustration(new Random().nextDouble() * 100);
            demo.update(status);
            Thread.sleep(1000);
        }
    }*/
   private static AffectiveTimeSeriesGraph affectiveTimeSeriesGraph;
   public static AffectiveTimeSeriesGraph getinstance(){
       if(affectiveTimeSeriesGraph == null){
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
