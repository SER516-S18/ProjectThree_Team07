package test;

import controller.server.MessageSender;
import network.model.Status;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageSenderTest {
    @Test
    public void testClearLowerFaceValues() {
        Status status = Status.getInstance();
        status.setSmile(1);
        status.setClench(1);
        status.setSmirkLeft(1);
        status.setSmirkRight(1);
        status.setLaugh(1);
        MessageSender.clearLowerFaceValues();
        assertEquals(status.getSmile(), 0, 0);
        assertEquals(status.getSmirkRight(), 0, 0);
        assertEquals(status.getSmirkLeft(), 0, 0);
        assertEquals(status.getClench(), 0, 0);
        assertEquals(status.getLaugh(), 0, 0);
    }
    @Test
    public void testClearEyeActionValues() {
        Status status = Status.getInstance();
        status.setBlink(true);
        status.setLeftWink(true);
        status.setRightWink(true);
        status.setLookingLeft(true);
        status.setLookingRight(true);
        MessageSender.clearEyeActionValues();
        assertEquals(status.getBlink(),false);
        assertEquals(status.getLeftWink(),false);
        assertEquals(status.getRightWink(),false);
        assertEquals(status.getLookingLeft(),false);
        assertEquals(status.getLookingRight(),false);


    }

}