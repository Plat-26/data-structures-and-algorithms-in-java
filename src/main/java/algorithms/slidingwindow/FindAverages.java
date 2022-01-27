package algorithms.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array find the average of all sub-array of length k.
 */
public class FindAverages {

    public static void main(String[] args) {
        FindAverages avgs = new FindAverages();
        Double[] averages = avgs.findAverage(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.println(Arrays.toString(averages)); // [1, 2, 3]
    }

    /**
     * Time: O(n * k)
     * Space: O(n)
     * @param array let n = array.length
     * @param k
     * @return double here to take into account integer division
     */
    public Double[] findAveragesNaive(int[] array, int k) {
        List<Double> averages = new ArrayList<>();

        for (int i = 0; i <= array.length - k; i++) {
            double sum = 0;
            for (int j = 0; j < k; j++) {
                sum += array[i + j];
            }
            averages.add(sum / k);
        }
        Double[] nums = new Double[averages.size()];
        averages.toArray(nums);
        return nums;
    }

    public Double[] findAverage(int[] array, int k) {
        List<Double> averages = new ArrayList<>();

        double sum = 0;
        //define window start values
        int windowLeft = 0;
        for (int windowRight = 0; windowRight < array.length; windowRight++) {
            //expand window
            sum += array[windowRight];

            //perform logic when window is of right size
            if (windowRight >= k - 1) {
                averages.add(sum / k);
                sum -= array[windowLeft];
                windowLeft++;
            }
        }
        //convert result ot right type
        Double[] result = new Double[averages.size()];
        averages.toArray(result);

        return result;
    }
}
