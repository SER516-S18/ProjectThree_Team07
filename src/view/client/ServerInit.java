package view.client;

import network.model.Connection;
import network.server.Server;

import java.io.*;
import java.nio.channels.*;

/**
 * @author Team 7
 * @version 1.0
 *
 * Handles Opening Server from Client
 */

public class ServerInit {
  private String appName;
  private static File file;
  private FileChannel channel;
  private FileLock lock;
  private static ServerInit serverInitInstance;

  public static ServerInit getInstance() {
    if (serverInitInstance == null) {
      serverInitInstance = new ServerInit("EmojiServer");
    }
    return serverInitInstance;
  }

  public ServerInit(String appName) {
    this.appName = appName;
  }

  public boolean isAppActive() {
    try {
      file = new File(System.getProperty("user.home"), appName + ".tmp");
      channel = new RandomAccessFile(file, "rw").getChannel();
      try {
        lock = channel.tryLock();
      } catch (OverlappingFileLockException e) {
        return true;
      }
      if (lock == null) {
        closeLock();
        return true;
      }
      Runtime.getRuntime().addShutdownHook(new Thread() {
        // destroy the lock when the JVM is closing
        public void run() {
          closeLock();
          deleteFile();
        }
      });
      return false;
    } catch (Exception e) {
      closeLock();
      return true;
    }
  }

  public void closeLock() {
    try {
      lock.release();
    } catch (Exception e) {
    }
    try {
      channel.close();
    } catch (Exception e) {
//      e.printStackTrace();
    }
  }

  public void deleteFile() {
    try {
      file.delete();
    } catch (Exception e) {
    }
  }

  public static void loadServer(String host, String port) {
    ServerInit serverInstance = ServerInit.getInstance();
    if (!serverInstance.isAppActive()) {
      try {
        Connection.getInstance().setHost(host);
        Connection.getInstance().setPort(Integer.valueOf(port));
        Runtime.getRuntime().exec("java -jar server.jar " + host + " " + port);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}

