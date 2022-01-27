package algorithms.slidingwindow;

/**
 * Given an array of positive numbers and a positive number s, find the length of the smallest contiguous sub array
 * whose sum is greater than or equal to s. Return 0 if no such sub array exists.
 */
public class FindMinSubArray {

    public static void main(String[] args) {
        FindMinSubArray finder = new FindMinSubArray();
        int minSubarray = finder.findSum(new int[]{1, 3, 2, 2, 4, 5}, 6);
        System.out.println(minSubarray);

        int minSubarray2 = finder.findSum(new int[]{2, 1, 5, 2, 8}, 7);
        System.out.println(minSubarray2);

    }

    /**
     * Time: O(n)
     * Space: O(1)
     * @param array
     * @param s
     * @return
     */
    public int findSum(int[] array, int s) {
        int minSubArray = Integer.MAX_VALUE;

        //initialize window
        int left = 0;
        int currSum =  0;
        for (int right = 0;  right < array.length; right++) {
            //grow window to fit constraint
            currSum += array[right];

            //when window fits constraint perform logic
            while (currSum >= s) {
                minSubArray = Math.min(minSubArray, right - left + 1);
                currSum -= array[left];
                left++;
            }
        }
        //return zero when s does not exit
        if (minSubArray == Integer.MAX_VALUE) {
            return 0;
        }

        return minSubArray;
    }
}
