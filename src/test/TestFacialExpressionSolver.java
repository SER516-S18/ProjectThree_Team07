package test;

import controller.client.FacialExpressionSolver;
import network.model.Status;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFacialExpressionSolver {

    private Status status;

    @Before
    public void setUp() {
        status = Status.getInstance();
    }

    @Test
    public void testComputeLowerFace() {
        status.setSmile(0.6);
        assertEquals(FacialExpressionSolver.computeLowerFace(status), FacialExpressionSolver.LowerFace.SMILE);
        status.setSmile(0.0);

        status.setClench(0.6);
        assertEquals(FacialExpressionSolver.computeLowerFace(status), FacialExpressionSolver.LowerFace.CLENCH);
        status.setClench(0.0);

        status.setSmirkLeft(0.1);
        assertEquals(FacialExpressionSolver.computeLowerFace(status), FacialExpressionSolver.LowerFace.SMIRK_LEFT);
        status.setSmirkLeft(0.0);

        status.setSmirkRight(0.1);
        assertEquals(FacialExpressionSolver.computeLowerFace(status), FacialExpressionSolver.LowerFace.SMIRK_RIGHT);
        status.setSmirkRight(0.0);

        status.setLaugh(0.1);
        assertEquals(FacialExpressionSolver.computeLowerFace(status), FacialExpressionSolver.LowerFace.LAUGH);
        status.setLaugh(0.0);

        assertEquals(FacialExpressionSolver.computeLowerFace(status), FacialExpressionSolver.LowerFace.NORMAL);
    }

    @Test
    public void testComputeUpperFace() {
        status.setLeftWink(true);
        assertEquals(FacialExpressionSolver.computeUpperrFace(status), FacialExpressionSolver.UpperFace.WINK_LEFT);
        status.setLeftWink(false);

        status.setRightWink(true);
        assertEquals(FacialExpressionSolver.computeUpperrFace(status), FacialExpressionSolver.UpperFace.WINK_RIGHT);
        status.setRightWink(false);

        status.setLookingLeft(true);
        assertEquals(FacialExpressionSolver.computeUpperrFace(status), FacialExpressionSolver.UpperFace.LOOK_LEFT);
        status.setLookingLeft(false);

        status.setLookingRight(true);
        assertEquals(FacialExpressionSolver.computeUpperrFace(status), FacialExpressionSolver.UpperFace.LOOK_RIGHT);
        status.setLookingRight(false);

        status.setBlink(true);
        assertEquals(FacialExpressionSolver.computeUpperrFace(status), FacialExpressionSolver.UpperFace.BLINK);
        status.setBlink(false);

        status.setEyebrowRaise(0.1);
        assertEquals(FacialExpressionSolver.computeUpperrFace(status), FacialExpressionSolver.UpperFace.RAISE_BROW);
        status.setEyebrowRaise(0.0);

        status.setEyebrowFurrow(0.1);
        assertEquals(FacialExpressionSolver.computeUpperrFace(status), FacialExpressionSolver.UpperFace.FURROW_BROW);
        status.setEyebrowFurrow(0.0);

        assertEquals(FacialExpressionSolver.computeUpperrFace(status), FacialExpressionSolver.UpperFace.NORMAL);
    }
}
