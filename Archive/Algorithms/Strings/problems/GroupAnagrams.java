package Strings;
import java.util.*;
/**
 * Problem Description for 'Group Anagrams': https://leetcode.com/problems/group-anagrams/
 * Given an array of strings strs, group the anagrams together. 
 * You can return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * 
 * Constraints:
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consits of lowercase English letters (26 letters)
 * 
 * Questions:
 * are we using ascii?
 * 
 * Observations:
 * We may be able to use an 
 * 
 * Possible Solutions:
 * O(n^2) by comparing each element to every other
 * O(nlogn)
 * O(n)
 * 
 */    
public class GroupAnagrams {
    public static void main(String[] args)
    {
        GroupAnagrams ga = new GroupAnagrams();
        ga.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
    }

    /** Solution x
     * Description:
     *  
     * Edge Cases:
     * 
     * Runtime:
     * 
     * Space Complexity:
     * 
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs)
        {
            char[] frequencyArr = new char[26];
            for(int i = 0;i<s.length();i++){
                frequencyArr[s.charAt(i) - 'a']++;
            }
            String key = String.valueOf(frequencyArr);
            System.out.println(key);
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
            
        }
        return new ArrayList<>(map.values());
    }
}
