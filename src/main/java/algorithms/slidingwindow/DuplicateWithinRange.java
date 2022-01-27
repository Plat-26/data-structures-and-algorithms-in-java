package algorithms.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array and a positive number k, check whether the array contains any duplicate elements within the range k.
 * If k is more than the array’s size, the solution should check for duplicates in the complete array.
 */
public class DuplicateWithinRange {

    public static void main(String[] args) {
        DuplicateWithinRange withinRange = new DuplicateWithinRange();

        //{ 5, 6, 8, 2, 4, 6, 9 } k = 4 - true
        System.out.println(withinRange.hasDuplicates(new int[] { 5, 6, 8, 2, 4, 6, 9 }, 4));
        //{ 5, 6, 8, 2, 4, 6, 9 } k = 2 - false
        System.out.println(withinRange.hasDuplicates(new int[] { 5, 6, 8, 2, 4, 6, 9 }, 2));
        //{ 1, 2, 3, 2, 1 } k = 7 - true
        System.out.println(withinRange.hasDuplicates(new int[] { 1, 2, 3, 2, 1 }, 7));

    }

    public boolean hasDuplicates(int[] array, int k) {
        Set<Integer> set = new HashSet<>();

        int left = 0;
        for (int right = 0; right < array.length; right++) {
            if (set.contains(array[right])) {

                while (array[left] != array[right]) {
                    left++;
                }
                if (right - left <= k) {
                    return true;
                }
            } else {
                set.add(array[right]);
            }
        }
        return false;
    }
}
