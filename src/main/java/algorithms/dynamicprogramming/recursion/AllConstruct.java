package algorithms.dynamicprogramming.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a function all construct(target, wordBank) that accepts a target String and an array of Strings
 * The function should return a 2D array containing all of the ways that the target can be constructed by concatenating
 * elements of the wordBank array. Each element of the 2D array should represent one combination that constructs the
 * target.
 */
public class AllConstruct {

    public List<List<String>> allConstruct(String target, String[] wordBank) {
        if ("".equals(target)) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        for (String word : wordBank) {
            if(target.startsWith(word)) {
                String suffix = target.replaceAll(word, "");
                List<List<String>> suffixList = allConstruct(suffix, wordBank);
                List<String> targetList = new ArrayList<>();
                for (List<String> list : suffixList) {
                    if (list.add(word)) {
//                        targetList.add(list);
                    }
                }
                result.add(targetList);
            }
        }
        return result;
    }
}
