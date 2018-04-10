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
    private TimeSeries interestSeries;
    private TimeSeries engagementSeries;
    private TimeSeries stressSeries;
    private TimeSeries relaxationSeries;
    private TimeSeries excitementSeries;
    private TimeSeries focusSeries;
    static JPanel content;

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
        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(this.interestSeries);
        dataset.addSeries(this.engagementSeries);
        dataset.addSeries(this.stressSeries);
        dataset.addSeries(this.relaxationSeries);
        dataset.addSeries(this.excitementSeries);
        dataset.addSeries(this.focusSeries);
        final JFreeChart chart = createChart(dataset);

        final ChartPanel chartPanel = new ChartPanel(chart);

        content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 500));
        //setContentPane(chartPanel);

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
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(60000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 1.0);
        axis.setVerticalTickLabels(false);
        axis.setTickLabelsVisible(false);
        return result;
    }

    public void startplotting() throws InterruptedException {
        Status status = Status.getInstance();
        int x = 0;
        while (x < 1000) {
            status.setMediation(new Random().nextDouble());
            status.setEngagementBoredom(new Random().nextDouble());
            status.setExcitementShortTerm(new Random().nextDouble());
            status.setExcitementLongTerm(new Random().nextDouble());
            status.setFrustration(new Random().nextDouble());
            update(status);
            Thread.sleep(1000);
        }
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

    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    /*public static void main(final String[] args) throws InterruptedException {




        final AffectiveTimeSeriesGraph demo = new AffectiveTimeSeriesGraph("Affective Graph");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

        Status status =Status.getInstance();
        int x = 0;
        while (x < 1000) {
            status.setInterest(new Random().nextDouble() * 100);
            status.setEngagement(new Random().nextDouble() * 100);
            status.setExcitement(new Random().nextDouble() * 100);
          //  status.setExcitmentLongTerm(new Random().nextDouble() * 100);
            status.setRelaxation(new Random().nextDouble() * 100);
            status.setFocus(new Random().nextDouble() * 100);
            demo.update(status);
            Thread.sleep(1000);
        }
    }*/
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
