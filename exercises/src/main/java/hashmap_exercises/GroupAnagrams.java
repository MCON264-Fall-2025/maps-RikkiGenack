package hashmap_exercises;

import java.util.*;

/**
 * LeetCode 49 - Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * Example:
 * Input:  ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]] (order may vary)
 */
public class GroupAnagrams {

    /**
     * Groups the given words into lists of anagrams.
     *
     * @param strs array of input strings
     * @return a list of groups, where each group is a list of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // TODO: implement
        // Typical approach:
        // - For each string, sort its characters to get a "canonical form"
        Map<String, List<String>> map = new HashMap<>(strs.length);//canonicalForm -> list of words
        for(int i =0; i<strs.length; i++){
         String sortedString = sort(strs[i]);
         if(map.get(sortedString)==null){
             ArrayList<String> list = new ArrayList<>();
             list.add(strs[i]);
             map.put(sortedString, list);

         }
         else{//add word to that connanical key
             List<String> list = map.get(sortedString);
             list.add(strs[i]);
         }
        }
        // - Use a Map<String, List<String>>: canonicalForm -> list of words
        // - Return the map's values as the result
        return new ArrayList<>(map.values());
    }



    String sort(String s){
    // 1. Convert to char array
        char[] chars = s.toCharArray();

    // 2. Sort the array
        Arrays.sort(chars);

    // 3. Convert back to a string
        String sorted = new String(chars);
        return sorted;
    }
}

