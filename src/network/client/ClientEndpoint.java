package network.client;

import network.model.Status;
import network.model.StatusDecoder;
import network.model.StatusEncoder;
import view.client.ImageLoader;
import view.client.components.affective.AffectiveTimeSeriesGraph;
import view.client.components.expressive.ExpressiveTimeSeriesGraph;
import view.client.components.expressive.FacialExpressions;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import controller.client.FacialExpressionSolver;

import java.io.IOException;

import static java.lang.String.format;

@javax.websocket.ClientEndpoint(encoders = StatusEncoder.class, decoders = StatusDecoder.class)
public class ClientEndpoint {


    @OnOpen
    public void onOpen(Session session) {
        System.out.println(format("Connection established. session id: %s", session.getId()));
        try {
            session.getBasicRemote().sendText("start");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @OnMessage
    public void onMessage(Status status) {
		FacialExpressionSolver.LowerFace lowerFace = FacialExpressionSolver.computeLowerFace(status);
		FacialExpressionSolver.UpperFace upperFace = FacialExpressionSolver.computeUpperrFace(status);
		ImageLoader.loadImage(FacialExpressions.getPanel(), upperFace.getFileName(), lowerFace.getFileName());
		//TODO  For displaying graph

        /*status.setEngagementBoredom(0.9);
        status.setExcitementShortTerm(0.3);
        status.setExcitementLongTerm(1);
        status.setBlink(true);
        status.setLookingDown(false);
        status.setEyesOpen(0.4);*/

        AffectiveTimeSeriesGraph.getinstance().update(status);
        ExpressiveTimeSeriesGraph.getinstance().update(status);
    }


}
