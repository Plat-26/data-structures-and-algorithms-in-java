package algorithms.stringsandarrays;

import java.util.HashMap;

/**
 * Design a logger system that receives a stream of messages along with their timestamps.
 * Each unique message should only be printed at most every 10 seconds (i.e. a message printed at
 * timestamp t will prevent other identical messages from being printed until timestamp t + 10).
 *
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 *
 * Implement the Logger class:
 *
 * Logger() Initializes the logger object.
 * bool shouldPrintMessage(int timestamp, string message)
 * Returns true if the message should be printed in the given timestamp, otherwise returns false.
 */
public class Logger {

  HashMap<String, Integer> map;

  public Logger() {
    this.map = new HashMap<>();
  }

  /**
   * Time: O(1)
   * Space: O(n) where n is the number of messages arriving at the timestamp
   */
  public boolean shouldPrintMessage(int timestamp, String message) {
    if(!map.containsKey(message)) {
      map.put(message, timestamp);
      return true;
    }
    int allowedTimestamp = map.get(message) + 10;
    if(timestamp >= allowedTimestamp) {
      map.put(message, timestamp);
      return true;
    }
    return false;
  }

  /*
   * Your Logger object will be instantiated and called as such:
   * Logger obj = new Logger();
   * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
   */
}
