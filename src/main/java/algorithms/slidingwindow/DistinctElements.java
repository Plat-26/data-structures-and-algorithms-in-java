package algorithms.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array and an integer k, find the count of distinct elements in every subarray of size k.
 */
public class DistinctElements {

    public static void main(String[] args) {
        DistinctElements elements = new DistinctElements();
        List<Integer> count = elements.countDistinctElements(new int[]{2, 1, 2, 3, 2, 1, 4, 5}, 5);
        System.out.println(count.toString());
    }

    //{2, 1, 2, 3, 2, 1, 4, 5 } k = 5

    /**
     * Time: O(n)
     * Space: O(n)
     * @param array, where n is the size of the sub array
     * @param k
     * @return
     */
    public List<Integer> countDistinctElements(int[] array, int k) {
        List<Integer> count = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); //2 - 1, 1 - 1, 3 - 1, 4 - 1

        int windowSize = 0;
        int left = 0;
        for (int right = 0; right < array.length; right++) {
            map.put(array[right], map.getOrDefault(array[right], 0) + 1);
            windowSize++;

            if (windowSize == k) {
                count.add(map.size());
                map.put(array[left], map.get(array[left]) - 1);

                if(map.get(array[left]) == 0) {
                    map.remove(array[left]);
                }
                left++;
                windowSize--;
            }
        }
        return count;
    }
}
