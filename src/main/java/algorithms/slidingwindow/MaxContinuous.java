package algorithms.slidingwindow;

/**
 * Given a binary array, find the maximum sequence of continuous 1’s that can be formed
 * by replacing at most k zeroes by ones.
 */
public class MaxContinuous {

    public static void main(String[] args) {
        MaxContinuous max = new MaxContinuous();
        int maxContinuous = max.findMaxContinuous(new int[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0}, 1);
        System.out.println(maxContinuous);

        int maxContinuous2 = max.findMaxContinuous(new int[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0}, 2);
        System.out.println(maxContinuous2);
    }

    //{ 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0 }
    public int findMaxContinuous(int[] array, int k) {

        int zeroCount = 0;
        int maxContinuous = 0;

        int left = 0;
        for (int right = 0; right < array.length; right++) {
            if (array[right] == 0) {
                zeroCount++;
            }

            if (zeroCount > k) {
                while (array[left] != 0) {
                    left++;
                }
                left++;
                zeroCount--;
            }

            if (right - left + 1 > maxContinuous) {
                maxContinuous = right - left + 1;
            }
        }
        return maxContinuous;
    }
}
