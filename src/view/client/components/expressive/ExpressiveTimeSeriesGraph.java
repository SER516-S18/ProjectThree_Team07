package view.client.components.expressive;
/**
 * Class to plot affective graph
 *
 * @author spraka10
 */

import network.model.Status;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.Value;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;


public class ExpressiveTimeSeriesGraph {

    /**
     * The time Series data.
     */
    private TimeSeries lookingRightSeries;
    private TimeSeries eyebrowRaiseSeries;
    private TimeSeries lookingLeftSeries;
    private TimeSeries clenchSeries;
    private TimeSeries lookingDownSeries;
    private TimeSeries lookingUpSeries;
    private TimeSeries rightWinkSeries;
    private TimeSeries leftWinkSeries;
    private TimeSeries blinkSeries;
    private TimeSeries eyesOpenSeries;
    private TimeSeries smileSeries;
    static JPanel content;

    /**
     * Constructs a new graph application.
     *
     * @param title the frame title.
     */
    private ExpressiveTimeSeriesGraph(final String title) {

        this.blinkSeries = new TimeSeries("blink", Millisecond.class);
        this.clenchSeries = new TimeSeries("clench", Millisecond.class);
        this.eyebrowRaiseSeries = new TimeSeries("eyebrowRaise", Millisecond.class);
        this.eyesOpenSeries = new TimeSeries("eyesOpen", Millisecond.class);
        this.leftWinkSeries = new TimeSeries("leftWink", Millisecond.class);
        this.lookingDownSeries = new TimeSeries("lookingDown", Millisecond.class);
        this.lookingLeftSeries = new TimeSeries("lookingLeft", Millisecond.class);
        this.lookingRightSeries = new TimeSeries("lookingRight", Millisecond.class);
        this.lookingUpSeries = new TimeSeries("lookingUp", Millisecond.class);
        this.rightWinkSeries = new TimeSeries("rightWink", Millisecond.class);
        this.smileSeries = new TimeSeries("smile", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(this.blinkSeries);
        dataset.addSeries(this.clenchSeries);
        dataset.addSeries(this.eyebrowRaiseSeries);
        dataset.addSeries(this.eyesOpenSeries);
        dataset.addSeries(this.leftWinkSeries);
        dataset.addSeries(this.lookingDownSeries);
        dataset.addSeries(this.lookingLeftSeries);
        dataset.addSeries(this.lookingRightSeries);
        dataset.addSeries(this.lookingUpSeries);
        dataset.addSeries(this.rightWinkSeries);
        dataset.addSeries(this.smileSeries);
        final JFreeChart chart = createChart(dataset);

        final ChartPanel chartPanel = new ChartPanel(chart);

        content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 500));
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
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(60000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 50);
        axis.setVerticalTickLabels(false);
        axis.setTickLabelsVisible(false);
        plot.setDomainGridlinesVisible(false);
        plot.setRangeGridlinesVisible(false);
        axis.setVisible(false);
        axis.setTickLabelPaint(Color.WHITE);

        axis = plot.getRangeAxis();
        axis.setVisible(false);
        axis.setTickLabelsVisible(false);
        axis.setTickLabelPaint(Color.WHITE);
        return result;
    }

    /**
     * update the time series data from server status for affective values
     *
     * @param status
     */
    public void update(Status status) {

        this.blinkSeries.addOrUpdate(new Millisecond(),  (status.getBlink() ? 1:0)+3);
        this.smileSeries.addOrUpdate(new Millisecond(), status.getSmile()+6);
        this.rightWinkSeries.addOrUpdate(new Millisecond(), (status.getRightWink()?1:0)+9);
        this.lookingUpSeries.addOrUpdate(new Millisecond(), (status.getLookingUp()?1:0)+12);
        this.lookingRightSeries.addOrUpdate(new Millisecond(), (status.getLookingRight()?1:0)+15);
        this.lookingLeftSeries.addOrUpdate(new Millisecond(), (status.getLookingLeft()?1:0)+18);
        this.lookingDownSeries.addOrUpdate(new Millisecond(), (status.getLookingDown()?1:0)+21);
        this.leftWinkSeries.addOrUpdate(new Millisecond(), (status.getLeftWink()?1:0)+24);
        this.eyesOpenSeries.addOrUpdate(new Millisecond(), status.getEyesOpen()+27);
        this.eyebrowRaiseSeries.addOrUpdate(new Millisecond(), (status.getEyebrowRaise()?1:0)+30);
        this.clenchSeries.addOrUpdate(new Millisecond(), status.getClench()+33);

    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    /*public static void main(final String[] args) throws InterruptedException {

        final ExpressiveTimeSeriesGraph demo = new ExpressiveTimeSeriesGraph("Expressive Graph");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

        Status status = Status.getInstance();
        int x = 0;
        while (x < 1000) {
            status.setBlink(true);
            status.setClench(0);
            status.setEyebrowRaise(true);
            status.setEyesOpen(0);
            status.setLookingDown(false);
            status.setLookingLeft(true);
            status.setLookingRight(false);
            status.setLookingUp(true);
            status.setLeftWink(false);
            status.setRightWink(true);
            status.setSmile(0);
            demo.update(status);
            Thread.sleep(1000);
            status.setBlink(false);
            status.setClench(1);
            status.setEyebrowRaise(false);
            status.setEyesOpen(1);
            status.setLookingDown(true);
            status.setLookingLeft(false);
            status.setLookingRight(true);
            status.setLookingUp(false);
            status.setLeftWink(true);
            status.setRightWink(false);
            status.setSmile(1);
            demo.update(status);
            Thread.sleep(1000);

        }


    }*/

    private static ExpressiveTimeSeriesGraph expTimeSeriesGraph;
    public static ExpressiveTimeSeriesGraph getinstance(){
        if(expTimeSeriesGraph == null){
            expTimeSeriesGraph = new ExpressiveTimeSeriesGraph("Expressive Graph");
        }
        return expTimeSeriesGraph;
    }

    public  JPanel getPanel() {
        JPanel expressiveGraph = new JPanel();

        //JLabel instructions = new JLabel("Graph displaying affective data", JLabel.CENTER);
        expressiveGraph.add(content);

        return expressiveGraph;
    }

}
