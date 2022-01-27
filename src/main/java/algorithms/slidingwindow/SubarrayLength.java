package algorithms.slidingwindow;

/**
 * Given an array of positive integers, find the smallest subarray’s length
 * whose sum of elements is greater than a given number k.
 */
public class SubarrayLength {

    public static void main(String[] args) {
        SubarrayLength array = new SubarrayLength();
        int length = array.findSubarrayLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 20);
        System.out.println(length);

        int length2 = array.findSubarrayLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 7);
        System.out.println(length2);
    }

    //{1, 2, 3, 4, 5, 6, 7, 8}, k = 20
    public int findSubarrayLength(int[] array, int target) {

        int minSubarrayLength = Integer.MAX_VALUE; //6
        int currentSum = 0; //25

        int windowSize = 0;
        int left = 0;
        for (int right = 0; right < array.length; right++) {
            currentSum += array[right];
            windowSize++; //5

            while (currentSum > target) {
                minSubarrayLength = Math.min(minSubarrayLength, windowSize);
                currentSum -= array[left];

                windowSize--;
                left++;
                }
            }
        return minSubarrayLength;
    }
}
