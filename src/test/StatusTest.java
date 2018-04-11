package test;

import network.model.Status;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatusTest {
    @Test
    public void testStatusModel() {
        Status status = Status.getInstance();

        status.setLookingRight(true);
        status.setLookingLeft(true);
        status.setLookingDown(true);
        status.setLookingUp(true);
        status.setRightWink(true);
        status.setLeftWink(true);
        status.setBlink(true);
        status.setEyebrowRaise(1.0);
        status.setEyebrowFurrow(1.0);
        status.setEyesOpen(1.0);
        status.setSmile(1.0);
        status.setClench(1.0);
        status.setSmirkLeft(1.0);
        status.setSmirkRight(1.0);
        status.setLaugh(1.0);


        status.setInterest(1.0);
        status.setEngagement(1.0);
        status.setStress(1.0);
        status.setExcitement(1.0);
        status.setFocus(1.0);
        status.setRelaxation(1.0);

        status.setActivatedEye(true);
        status.setAutoReset(true);

        status.setTimestamp(1.0);

        assertEquals(status.getLookingRight(), true);
        assertEquals(status.getLookingLeft(), true);
        assertEquals(status.getLookingDown(), true);
        assertEquals(status.getLookingUp(), true);
        assertEquals(status.getRightWink(), true);
        assertEquals(status.getLeftWink(), true);
        assertEquals(status.getBlink(), true);
        assertEquals(status.isEyeActivated(), true);
        assertEquals(status.isAutoReset(), true);

        assertEquals(status.getEyebrowRaise(), 1.0, 0.0);
        assertEquals(status.getEyebrowFurrow(), 1.0, 0.0);
        assertEquals(status.getEyesOpen(), 1.0, 0.0);
        assertEquals(status.getSmile(), 1.0, 0.0);
        assertEquals(status.getClench(), 1.0, 0.0);
        assertEquals(status.getSmirkLeft(), 1.0, 0.0);
        assertEquals(status.getSmirkRight(), 1.0, 0.0);
        assertEquals(status.getLaugh(), 1.0, 0.0);

        assertEquals(status.getInterest(), 1.0, 0.0);
        assertEquals(status.getEngagement(), 1.0, 0.0);
        assertEquals(status.getStress(), 1.0, 0.0);
        assertEquals(status.getRelaxation(), 1.0, 0.0);
        assertEquals(status.getExcitement(), 1.0, 0.0);
        assertEquals(status.getFocus(), 1.0, 0.0);
        assertEquals(status.getTimestamp(), 1.0, 0.0);


    }
}