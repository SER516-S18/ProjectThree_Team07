package util;

import network.model.Status;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

import static util.StatusConstants.*;

/**
 * Json builders used to generate json payloads to send over the network
 *
 * @author team 7
 */
public class JsonUtil {

  /**
   * Encoding a status object to a json object
   *
   * @param status the status object to be serialized
   */
  public static String encodeServerStatus(Status status) {
    return Json.createObjectBuilder()
        .add(
            EXPRESSIVE,
            Json.createObjectBuilder()
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
                .add(CLENCH, status.getClench())
                .add(SMIRK_LEFT, status.getSmirkLeft())
                .add(SMIRK_RIGHT, status.getSmirkRight())
                .add(EYEBROW_FURROW, status.getEyebrowFurrow())
                .add(LAUGH, status.getLaugh()))
        .add(
            EMOTIONAL,
            Json.createObjectBuilder()
                .add(INTEREST, status.getInterest())
                .add(ENGAGEMENT, status.getEngagement())
                .add(STRESS, status.getStress())
                .add(RELAXATION, status.getRelaxation())
                .add(EXCITEMENT, status.getExcitement())
                .add(FOCUS, status.getFocus()))
        .add(
            AFFECTIVE,
            Json.createObjectBuilder()
                .add(MEDITATION, status.getMediation())
                .add(ENGAGEMENT_BOREDOM, status.getEngagementBoredom())
                .add(EXCITEMENT_SHORT_TERM, status.getExcitementShortTerm())
                .add(FRUSTRATION, status.getFrustration())
                .add(EXCITEMENT_LONG_TERM, status.getExcitementLongTerm()))
        .add(
            META,
            Json.createObjectBuilder()
                .add(IS_AUTO_REST, status.isAutoReset())
                .add(TIMESTAMP, status.getTimestamp()))
        .build()
        .toString();
  }

  /**
   * Decodes a json string into a status object
   *
   * @param statusMessage json string representing a json status
   */
  public static Status decodeServerStatus(String statusMessage) {
    Status status = Status.getInstance();
    JsonObject jsonObject = Json.createReader(new StringReader(statusMessage)).readObject();

    JsonObject jsonExpressive = jsonObject.getJsonObject(EXPRESSIVE);

    status.setLookingRight(jsonExpressive.getBoolean(LOOKING_RIGHT));
    status.setLookingLeft(jsonExpressive.getBoolean(LOOKING_LEFT));
    status.setLookingDown(jsonExpressive.getBoolean(LOOKING_DOWN));
    status.setLookingUp(jsonExpressive.getBoolean(LOOKING_UP));
    status.setLeftWink(jsonExpressive.getBoolean(LEFT_WINK));
    status.setRightWink(jsonExpressive.getBoolean(RIGHT_WINK));
    status.setBlink(jsonExpressive.getBoolean(BLINK));
    status.setEyebrowRaise(jsonExpressive.getJsonNumber(EYEBROW_RAISE).doubleValue());
    status.setEyebrowFurrow(jsonExpressive.getJsonNumber(EYEBROW_FURROW).doubleValue());
    status.setSmirkLeft(jsonExpressive.getJsonNumber(SMIRK_LEFT).doubleValue());
    status.setSmirkRight(jsonExpressive.getJsonNumber(SMIRK_RIGHT).doubleValue());
    status.setEyesOpen(jsonExpressive.getJsonNumber(EYES_OPEN).doubleValue());
    status.setSmile(jsonExpressive.getJsonNumber(SMILE).doubleValue());
    status.setClench(jsonExpressive.getJsonNumber(CLENCH).doubleValue());
    status.setLaugh(jsonExpressive.getJsonNumber(LAUGH).doubleValue());

    JsonObject jsonEmotional = jsonObject.getJsonObject(EMOTIONAL);

    status.setInterest(jsonEmotional.getJsonNumber(INTEREST).doubleValue());
    status.setEngagement(jsonEmotional.getJsonNumber(ENGAGEMENT).doubleValue());
    status.setStress(jsonEmotional.getJsonNumber(STRESS).doubleValue());
    status.setRelaxation(jsonEmotional.getJsonNumber(RELAXATION).doubleValue());
    status.setExcitement(jsonEmotional.getJsonNumber(EXCITEMENT).doubleValue());
    status.setFocus(jsonEmotional.getJsonNumber(FOCUS).doubleValue());

    JsonObject jsonAffective = jsonObject.getJsonObject(AFFECTIVE);

    status.setMediation(jsonAffective.getJsonNumber(MEDITATION).doubleValue());
    status.setEngagementBoredom(jsonAffective.getJsonNumber(ENGAGEMENT_BOREDOM).doubleValue());
    status.setExcitementShortTerm(jsonAffective.getJsonNumber(EXCITEMENT_SHORT_TERM).doubleValue());
    status.setFrustration(jsonAffective.getJsonNumber(FRUSTRATION).doubleValue());
    status.setExcitementShortTerm(jsonAffective.getJsonNumber(EXCITEMENT_LONG_TERM).doubleValue());

    JsonObject jsonMeta = jsonObject.getJsonObject(META);

    status.setAutoReset(jsonMeta.getBoolean(IS_AUTO_REST));
    status.setTimestamp(jsonMeta.getJsonNumber(TIMESTAMP).doubleValue());

    return status;
  }
}
