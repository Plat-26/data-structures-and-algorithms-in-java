package algorithms.dynamicprogramming.tabulation;

public class CanConstructTabulation {

    public static void main(String[] args) {
        CanConstructTabulation tab = new CanConstructTabulation();
        boolean canConstruct = tab.canConstruct("abcdef", new String[]{"ab", "abc", "def", "cdef"});
        System.out.println(canConstruct);
    }

    public boolean canConstruct(String target, String[] wordbank) {
        boolean[] arry = new boolean[target.length() + 1];
        arry[0] = true;

        for (int i = 0; i < arry.length; i++) {
             if (arry[i]) {
                 for (String word :  wordbank) {
                     if (target.startsWith(word, i)) {
                         if (i + word.length() < arry.length) {
                             arry[i + word.length()] = true;
                         }
                     }


                 }

             }
        }
        return arry[target.length()];
    }
}
