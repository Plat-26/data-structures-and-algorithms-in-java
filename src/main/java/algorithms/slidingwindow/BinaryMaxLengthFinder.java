package algorithms.slidingwindow;

/**
 * Given a binary array, find the index of 0 to be replaced with 1 to get a maximum length sequence of continuous ones.
 */
public class BinaryMaxLengthFinder {

    public static void main(String[] args) {
        BinaryMaxLengthFinder maxLengthFinder = new BinaryMaxLengthFinder();
        int max = maxLengthFinder.binaryMaxLengthFinder(new int[]{0, 0, 1, 0, 1, 1, 1, 0, 1, 1});
        System.out.println(max);

        int max2 = maxLengthFinder.binaryMaxLengthFinder(new int[]{1, 1, 0});
        System.out.println(max2);
    }

    //{0, 0, 1, 0, 1, 1, 1, 0, 1, 1}
    public int binaryMaxLengthFinder(int[] array) {

        int maxIndex = -1;
        int prevZeroIndex = - 1;

        int zeroCount = 0;
        int maxCount = -1;

        int left = 0;
        for (int right = 0; right < array.length; right++) {
            if (array[right] == 0) {
                prevZeroIndex = right;
                zeroCount++;
            }

            //shrink window when constraint is violated
            if (zeroCount > 1) {
                while (array[left] != 0) {
                    left++;
                }
                left++;
                zeroCount--;
            }

            if (right - left + 1 > maxCount) {
                maxCount = right - left + 1;
                maxIndex = prevZeroIndex;

            }

        }

        return maxIndex;
    }
}
