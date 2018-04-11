package network.model;

import util.JsonUtil;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/** @author Team 7
 * Decoder for status object
 * */
public class StatusDecoder implements Decoder.Text<Status> {

  @Override
  public void init(final EndpointConfig config) {}

  @Override
  public void destroy() {}

  @Override
  public Status decode(final String statusMessage) throws DecodeException {
    return JsonUtil.decodeServerStatus(statusMessage);
  }

  @Override
  public boolean willDecode(final String s) {
    return true;
  }
}
