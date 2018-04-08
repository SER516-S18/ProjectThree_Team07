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
        Status status = Status.getInstance();
        JsonObject jsonObject = Json.createReader(new StringReader(statusMessage)).readObject();

        JsonObject jsonExpressive = jsonObject.getJsonObject(EXPRESSIVE);

        status.setLookingRight(jsonExpressive.getBoolean(LOOKING_RIGHT));
        status.setEyebrowRaise(jsonExpressive.getBoolean(EYEBROW_RAISE));
        status.setLookingLeft(jsonExpressive.getBoolean(LOOKING_LEFT));
        status.setLookingDown(jsonExpressive.getBoolean(LOOKING_DOWN));
        status.setLookingUp(jsonExpressive.getBoolean(LOOKING_UP));
        status.setLeftWink(jsonExpressive.getBoolean(LEFT_WINK));
        status.setRightWink(jsonExpressive.getBoolean(RIGHT_WINK));
        status.setBlink(jsonExpressive.getBoolean(BLINK));
        status.setEyebrowFurrow(jsonExpressive.getBoolean(EYEBROW_FURROW));
        status.setSmirkLeft(jsonExpressive.getJsonNumber(SMIRK_LEFT).doubleValue());
        status.setSmirkRight(jsonExpressive.getJsonNumber(SMIRK_RIGHT).doubleValue());
        status.setEyesOpen(jsonExpressive.getJsonNumber(EYES_OPEN).doubleValue());
        status.setSmile(jsonExpressive.getJsonNumber(SMILE).doubleValue());
        status.setClench(jsonExpressive.getJsonNumber(CLENCH).doubleValue());
        status.setLaugh(jsonExpressive.getJsonNumber(LAUGH).doubleValue());

        JsonObject jsonAffective = jsonObject.getJsonObject(AFFECTIVE);

        status.setMediation(jsonAffective.getJsonNumber(MEDITATION).doubleValue());
        status.setEngagementBoredom(jsonAffective.getJsonNumber(ENGAGEMENT_BOREDOM).doubleValue());
        status.setExcitementShortTerm(jsonAffective.getJsonNumber(EXCITEMENT_SHORT_TERM).doubleValue());
        status.setFrustration(jsonAffective.getJsonNumber(FRUSTRATION).doubleValue());
        status.setExcitementShortTerm(jsonAffective.getJsonNumber(EXCITEMENT_LONG_TERM).doubleValue());

        return status;
    }
}
