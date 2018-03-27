package util;

import network.model.Status;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

import static util.StatusConstants.*;

public class JsonUtil {

    public static String encodeServerStatus(Status status) {
        return Json.createObjectBuilder()
                .add(EXPRESSIVE, Json.createObjectBuilder()
                        .add(LOOKING_RIGHT, status.getLookingRight())
                        .add(EYEBROW_RAISE, status.getEyebrowRaise())
                        .add(LOOKING_LEFT, status.getLookingLeft())
                        .add(LOOKING_DOWN, status.getLookingDown())
                        .add(LOOKING_UP, status.getLookingUp())
                        .add(LEFT_WINK, status.getLeftWink())
                        .add(RIGHT_WINK, status.getRightWink())
                        .add(BLINK, status.getBlink())
                        .add(EYES_OPEN, status.getEyesOpen())
                        .add(SMILE, status.getSmile())
                        .add(CLENCH, status.getClench()))

                .add(AFFECTIVE, Json.createObjectBuilder()
                        .add(MEDITATION, status.getMediation())
                        .add(ENGAGEMENT_BOREDOM, status.getEngagementBoredom())
                        .add(EXCITEMENT_SHORT_TERM, status.getExcitementShortTerm())
                        .add(FRUSTRATION, status.getFrustration())
                        .add(EXCITEMENT_LONG_TERM, status.getExcitementLongTerm()))

                .build().toString();
    }

    public static Status decodeServerStatus(String statusMessage) {
        Status status = new Status();
        JsonObject jsonObject = Json.createReader(new StringReader(statusMessage)).readObject();

        JsonObject jsonExpressive = jsonObject.getJsonObject(EXPRESSIVE);

        status.setLookingRight(jsonExpressive.getJsonNumber(LOOKING_RIGHT).doubleValue());
        status.setEyebrowRaise(jsonExpressive.getJsonNumber(EYEBROW_RAISE).doubleValue());
        status.setLookingLeft(jsonExpressive.getJsonNumber(LOOKING_LEFT).doubleValue());
        status.setLookingDown(jsonExpressive.getJsonNumber(LOOKING_DOWN).doubleValue());
        status.setLookingUp(jsonExpressive.getJsonNumber(LOOKING_UP).doubleValue());
        status.setLeftWink(jsonExpressive.getJsonNumber(LEFT_WINK).doubleValue());
        status.setRightWink(jsonExpressive.getJsonNumber(RIGHT_WINK).doubleValue());
        status.setBlink(jsonExpressive.getJsonNumber(BLINK).doubleValue());
        status.setEyesOpen(jsonExpressive.getJsonNumber(EYES_OPEN).doubleValue());
        status.setSmile(jsonExpressive.getJsonNumber(SMILE).doubleValue());
        status.setClench(jsonExpressive.getJsonNumber(CLENCH).doubleValue());

        JsonObject jsonAffective = jsonObject.getJsonObject(AFFECTIVE);

        status.setMediation(jsonAffective.getJsonNumber(MEDITATION).doubleValue());
        status.setEngagementBoredom(jsonAffective.getJsonNumber(ENGAGEMENT_BOREDOM).doubleValue());
        status.setExcitementShortTerm(jsonAffective.getJsonNumber(EXCITEMENT_SHORT_TERM).doubleValue());
        status.setFrustration(jsonAffective.getJsonNumber(FRUSTRATION).doubleValue());
        status.setExcitmentLongTerm(jsonAffective.getJsonNumber(EXCITEMENT_LONG_TERM).doubleValue());

        return status;
    }
}
