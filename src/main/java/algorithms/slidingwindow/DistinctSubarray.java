package algorithms.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array, print all maximum size subarrays having all distinct elements in them.
 */
public class DistinctSubarray {

    public static void main(String[] args) {
        DistinctSubarray dist = new DistinctSubarray();
        dist.printDistinctSubarray(new int[] {5, 2, 3, 5, 4, 3} );
    }

    // { 5, 2, 3, 5, 4, 3 }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param array, where n = array.length
     */
    public void printDistinctSubarray(int[] array) {
        Set<Integer> set = new HashSet<>();

        int n = array.length;
        int left = 0;
        int right = 0;
        while (right < n) {

            while (right < n && !set.contains(array[right])) {
                set.add(array[right]);
                right++;
            }
            printSubArray(array, left, right);

            while (right < n && set.contains(array[right])) {
                set.remove(array[left]);
                left++;
            }
        }
    }

    private void printSubArray(int[] array, int left, int right) {
        for (int i = left; i < right; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
