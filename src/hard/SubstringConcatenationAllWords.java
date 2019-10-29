package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 30: Substring with Concatenation of All Words
 */
public class SubstringConcatenationAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> wordMap = new HashMap<>();
        // How many words in current string don't match the words in a correct string
        // i.e. number of extraneous, overused, and underused words in current string
        int offCount = 0;
        int len = words[0].length();
        List<Integer> indices = new ArrayList<>();

        // Offset from 0 from which to form words and perform search
        for (int offset = 0; offset < len; offset++) {
            offCount = 0;
            wordMap.clear();
            // Build frequency map of words
            for (String str : words) {
                if (!wordMap.containsKey(str)) {
                    wordMap.put(str, 0);
                    offCount++;
                }
                wordMap.put(str, wordMap.get(str) + 1);
            }

            // Build up a full starting string
            for (int i = 0; i < words.length && i * len + len + offset <= s.length(); i++) {
                String word = s.substring(i * len + offset, i * len + len + offset);
                offCount += addWord(word, wordMap);
            }

            // If current string has zero wrong words, add index as answer
            // Occurs when wordMap has all 0 values (no extra or missing words from given array)
            // and there are no words that don't appear in the given words array
            if (offCount == 0) {
                indices.add(offset);
            }

            // Go through s adding next word while removing beginning word
            for (int i = words.length; i * len + len + offset <= s.length(); i++) {
                String word = s.substring(i * len + offset, i * len + len + offset);
                offCount += addWord(word, wordMap);

                // Remove beginning word and update offCount from doing so
                word = s.substring((i - words.length) * len + offset, (i - words.length) * len + len + offset);
                if (!wordMap.containsKey(word)) {
                    offCount--;
                } else {
                    int count = wordMap.get(word) + 1;
                    wordMap.put(word, count);
                    if (count == 0) {
                        offCount--;
                    } else if (count == 1) {
                        offCount++;
                    }
                }

                if (offCount == 0) {
                    indices.add((i - words.length + 1) * len + offset);
                }
            }
        }
        return indices;
    }

    // Mark the given word appearing by decrementing its value in wordMap
    // Return change in offCount that occurred from adding this word
    private int addWord(String word, Map<String, Integer> wordMap) {
        int offCount = 0;
        if (!wordMap.containsKey(word)) {
            offCount++;
        } else {
            int count = wordMap.get(word) - 1;
            wordMap.put(word, count);
            if (count == 0) {
                offCount--;
            } else if (count == -1) {
                offCount++;
            }
        }
        return offCount;
    }

    public static void main(String[] args) {
        List<Integer> result = new SubstringConcatenationAllWords().
                findSubstring("barfoothefoobarman", new String[] {"foo","bar"});
        System.out.println(result);
    }
}
