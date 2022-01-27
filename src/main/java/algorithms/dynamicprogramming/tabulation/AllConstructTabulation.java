package algorithms.dynamicprogramming.tabulation;

import java.util.ArrayList;
import java.util.List;

public class AllConstructTabulation {

    public static void main(String[] args) {
        AllConstructTabulation tabs = new AllConstructTabulation();
        List<List<String>> purple = tabs.allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"});
        System.out.println(purple.toString());
    }
    //purple p purpl le pur ple
    public List<List<String>> allConstruct (String target, String[] wordBank) {
        List<List<String>>[] arry = new List[target.length() + 1];
        for(int i = 0; i < arry.length; i++) {
            arry[i] = new ArrayList<>();
        }

        arry[0].add(new ArrayList<>());
        for (int i = 0; i < arry.length; i++) {
            for (String word : wordBank) {
                if (target.startsWith(word, i)) {
                    if (i + word.length() < arry.length) {
                        List<List<String>> newCombo = new ArrayList<>();
                        for (List<String> list : arry[i]) {
                            list.add(word);
                            newCombo.add(list);
                        }
                        for (List list : newCombo) {
                            arry[i + word.length()].add(list);
                        }
                    }
                }
            }
        }
        return arry[target.length()];
    }
}
