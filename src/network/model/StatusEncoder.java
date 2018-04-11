package network.model;

import util.JsonUtil;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/** @author Team 7 Encoder for Status object */
public class StatusEncoder implements Encoder.Text<Status> {

  @Override
  public void init(final EndpointConfig config) {}

  @Override
  public void destroy() {}

  @Override
  public String encode(final Status statusMessage) throws EncodeException {
    return JsonUtil.encodeServerStatus(statusMessage);
  }
}
