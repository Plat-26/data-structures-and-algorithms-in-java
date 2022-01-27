package algorithms.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of sorted integers that may contain several duplicate elements,
 * count the total number of distinct absolute values in it.
 */
public class DistinctAbsolute {

    public static void main(String[] args) {
        DistinctAbsolute val = new DistinctAbsolute();
        System.out.println(val.countDistinctAbsolutes(new int[] { -2, -1, 0, 1, 2, 3 }));

        System.out.println(val.countDistinctAbsolutes(new int[]{ -1, -1, -1, -1 }));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param array, where n is the length of array
     * @return
     */
    public int countDistinctAbsolutes(int[] array) {
        Set<Integer> set = new HashSet<>();

        for (int num : array) {
            set.add(Math.abs(num));
        }
        return set.size();
    }
}
