package algorithms.stringsandarrays;

import java.util.HashMap;
import java.util.Map;

/**
 * You are playing the Bulls and Cows game with your friend.
 *
 * You write down a secret number and ask your friend to guess what the number is.
 * When your friend makes a guess, you provide a hint with the following info:
 *
 * The number of "bulls", which are digits in the guess that are in the correct position.
 * The number of "cows", which are digits in the guess that are in your secret number
 * but are located in the wrong position. Specifically,
 * the non-bull digits in the guess that could be rearranged such that they become bulls.
 * Given the secret number secret and your friend's guess guess,
 * return the hint for your friend's guess.
 *
 * The hint should be formatted as "xAyB",
 * where x is the number of bulls and y is the number of cows.
 * Note that both secret and guess may contain duplicate digits.
 */
public class BullsAndCows {

  public static void main(String[] args) {
    BullsAndCows bc = new BullsAndCows();
    System.out.println(bc.getHint("1122","1222"));
  }

  /**
   * Time: O(n)
   * Space: O(n)
   * @param secret
   * @param guess
   * @return
   */
  public String getHint(String secret, String guess) {
    HashMap<Character, Integer> map = new HashMap<>();
    for(char c : secret.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int bulls = 0, matching = 0;
    for(int i = 0; i < secret.length(); i++) {
      char cs = secret.charAt(i);
      char cg = guess.charAt(i);
      if(cs == cg) {
        //Always count the bulls
        bulls++;

        if(map.containsKey(cs)) {
          matching++;
          updateMapState(map, cs);
        }
      } else {
        if(map.containsKey(cg)) {
          matching++;
          updateMapState(map, cg);
        }
      }
    }
    //cows are numbers that are not bulls;
    int cows = matching - bulls;
    return bulls + "A" + cows + "B";
  }


  private void updateMapState(Map<Character, Integer> map, char ch) {
    map.put(ch, map.get(ch) - 1);

    if(map.get(ch) == 0) {
      map.remove(ch);
    }
  }

  /**
   * public String getHint(String secret, String guess) {
   *         int[] map = new int[10];
   *         for(char c : secret.toCharArray()) {
   *           map[c - '0']++;
   *         }
   *
   *         int bulls = 0, matching = 0;
   *         for(int i = 0; i < secret.length(); i++) {
   *             char cs = secret.charAt(i);
   *             char cg = guess.charAt(i);
   *             if(cs == cg) {
   *                 bulls++;
   *                 if(map[cs - '0'] > 0) {
   *                     matching++;
   *                     map[cs - '0']--;
   *                 }
   *             } else {
   *                 if(map[cg - '0'] > 0) {
   *                     matching++;
   *                     map[cg - '0']--;
   *                 }
   *             }
   *         }
   *         int cows = matching - bulls;
   *         return bulls + "A" + cows + "B";
   *     }
   */
}
