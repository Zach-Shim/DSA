package Strings;
import java.util.*;

/**
 * Problem Description for 'Check Permutation':
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * Implement an algorithm to determine if a string is a permutation of another string. 
 * A string t is a permutation of string s if t can be turned into s by rearranging its letters.
 * What if you cannot use additional data structures?
 * 
 * Questions:
 * Are we using ascii?
 * Are these string case sensitive?
 * 
 * Observations:
 * 
 */    
public class CheckPermutation {
    public static void main(String[] args)
    {
        /* Solution 1 */
        // valid permutation
        System.out.println(CheckPermutation.checkPermutation1("nat", "tan"));

        // same string
        System.out.println(CheckPermutation.checkPermutation1("aabcdef", "aabcdef"));

        // empty strings
        System.out.println(CheckPermutation.checkPermutation1("", ""));

        /* Solution 2 */
        // valid permutation
        System.out.println(CheckPermutation.checkPermutation2("nat", "tan"));

        // same string
        System.out.println(CheckPermutation.checkPermutation2("aabcdef", "aabcdef"));

        // empty strings
        System.out.println(CheckPermutation.checkPermutation2("", ""));
    }

    /** Solution 1
     * Description:
     * Sort both arrays and check for equality.
     *  
     * Edge Cases:
     * One strings length is not equal to the other
     * 
     * Runtime:
     * Time Complexity: O(nlogn) 
     * 
     * Space Complexity:
     * Space Complexity O(n)
     * 
     */
    public static boolean checkPermutation1(String s, String t)
    {
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);

        char[] s2 = t.toCharArray();
        Arrays.sort(s2);

        return Arrays.equals(s1, s2);
    }

    /** Solution 2
     * Description:
     * If two strings have different lengths, they are obviously not permutations of one another.
     * If they do have the same length, we can check if they have the same amount of individual characters.
     *  
     * Edge Cases:
     * One strings length is not equal to the other
     * 
     * Runtime:
     * Time Complexity: O(n) we loop over all chars in s then t so its really (s + t)
     * 
     * Space Complexity:
     * Space Complexity O(n) for character array of s
     * 
     */
    public static boolean checkPermutation2(String s, String t)
    {
        if(s.length() != t.length()) return false;
        
        int[] letterFrequency = new int[128];
        for(char c : s.toCharArray()) letterFrequency[c]++;

        for(int i = 0; i < t.length(); i++)
        {
            letterFrequency[t.charAt(i)]--;
            if(letterFrequency[t.charAt(i)] < 0) 
                return false;
        }
        return true;
    }
}
