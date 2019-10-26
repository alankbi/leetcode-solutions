package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 49: Group Anagrams
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!anagrams.containsKey(sorted)) {
                anagrams.put(sorted, new ArrayList<>());
            }
            anagrams.get(sorted).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> anagramList : anagrams.values()) {
            result.add(anagramList);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> result = new GroupAnagrams().groupAnagrams(
                new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(result);
    }
}
