package Strings;

/**
 * Problem Description for 'Minimum Window Substring': https://leetcode.com/problems/minimum-window-substring/
 * 
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. 
 * If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * 
 * Constraints:
 *      m == s.length
 *      n == t.length
 *      1 <= m, n <= 105
 *      s and t consist of uppercase and lowercase English letters
 * 
 * Questions:
 * Are upper and lower case letters condsiderred to be different? (i.e. is a == A?)
 * 
 * Observations:
 * We may be able to use sliding window technique based on the keywords SUBSTRING and MINIMUM WINDOW
 * 
 * Possible Solutions:
 * 
 * Worst case O(n^2)
 * Average case O(n)
 * 
 */ 
public class MinimumWindowSubstring {
    
    public static void main(String[] args)
    {
        System.out.println(MinimumWindowSubstring.minWindow("cabwefgewcwaefgcf", "cae"));
    }
    
    public static String minWindow(String s, String t) {
        // check of current window contains all of the characters in t
        int counter = t.length();
        int[] letterFrequency = new int[128];
        for(char c : t.toCharArray()) letterFrequency[c]++;

        // global substring pointer variables
        int subStart = 0, subLength = Integer.MAX_VALUE;

        // local window variable trackers
        int start = 0, end; 

        // traverse over entire collection
        for(end = 0; end < s.length(); end++)
        {
            // update local trackers
            char endChar = s.charAt(end);
            if(letterFrequency[endChar] > 0) counter--;
            letterFrequency[endChar]--;

            // satisfy costraint
            while(counter == 0)
            {
                // update global trackers
                if((end - start + 1) < subLength)
                {
                    subStart = start;
                    subLength = end - start + 1;
                }

                // shrink window
                char startChar = s.charAt(start);
                letterFrequency[startChar]++;
                if(letterFrequency[startChar] > 0) counter++;
                start++;
            }
        }

        // return substring
        return (subLength == Integer.MAX_VALUE ? "" : s.substring(subStart, subStart + subLength));
    }
}
