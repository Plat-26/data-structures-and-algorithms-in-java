package algorithms.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the longest substring containing distinct characters.
 */
public class LongestSubstringFinder {

    public static void main(String[] args) {
        LongestSubstringFinder finder = new LongestSubstringFinder();
        String substring = finder.findLongestSubstring("longestsubstr");
        System.out.println(substring);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param s let n = s.length
     * @return
     */
    public String findLongestSubstring(String s) {
        //longestsubstring tsub

        // int max windowlength = 7
        //initialize a value to store max substring maxLeft = 0 maxRight =
        //initialize the window left = 0 right = 0
        //create set to store the distinct chacracters { l, o, ..}
        //loop from right to s.length
        // if char at right not in set, put in set move right++
        // else: //update maxLeft and maxRight according to window length
        //  currWindowLenght = right - left + 1;
        //  if(curr > prev) maxLeft = left, maxRight = right
        // while (char at left is not char at right )
        //  remove character at left from set
        //  left++
        // left++ left = 6


        int maxLeft = 0;
        int maxRight = 0;
        int maxWindowLength = 0;

        Set<Character> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {

            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));

                //update maximum substring
                int currWindowLength = right - left + 1; //consider full length from right
                if (currWindowLength > maxWindowLength) {
                    maxLeft = left;
                    maxRight = right;
                    maxWindowLength = currWindowLength;
                }

            } else {
                int currWindowLength = right - left; //consider length of string before current index right
                if (currWindowLength > maxWindowLength) {
                    maxLeft = left;
                    maxRight = right - 1;
                    maxWindowLength = currWindowLength;
                }

                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }
}
