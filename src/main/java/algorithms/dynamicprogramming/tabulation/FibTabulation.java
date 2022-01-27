package algorithms.dynamicprogramming.tabulation;

/**
 * Given a number n, find its value in the fibonacci series
 */
public class FibTabulation {
    public static void main(String[] args) {
        FibTabulation fib = new FibTabulation();
        int fibValue = fib.fib(7);
        System.out.println(fibValue);
    }

    public int fib(int n) {
        int[] arry = new int[n + 1];
        arry[1] = 1;
        for (int i = 0; i < arry.length; i++) {
            if (i + 1 < arry.length) {
                arry[i + 1] += arry[i];
            }
            if (i + 2 < arry.length) {
                arry[i + 2] += arry[i];
            }
        }
        return arry[n];
    }
}
