package algorithms.dynamicprogramming.tabulation;

public class CountConstructTabulation {

    public static void main(String[] args) {
        CountConstructTabulation count = new CountConstructTabulation();
        int countConstruct = count.countConstruct("purple", new String[]{"p", "ur", "purp", "ple", "le"});
        System.out.println(countConstruct);
    }

    public int countConstruct(String target, String[] wordBank) {
        int[] arry = new int[target.length() + 1];
        arry[0] = 1;

        for (int i = 0; i < arry.length; i++) {
            if (arry[i] != 0) {
                for (String word : wordBank) {
                    if (target.startsWith(word, i)) {
                        if (i + word.length() < arry.length) {
                            arry[i + word.length()] += arry[i];
                        }
                    }
                }
            }
        }
        return arry[target.length()];
    }
}
