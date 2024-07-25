package Strings;
import java.util.*;

/**
 * Problem Description for 'Is Unique': Problem 1 CTCI
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 * 
 * Questions:
 * Can we assume that the characters in the string are ascii? or are they unicode?
 * Does case sensitivity matter (A != a)?
 * 
 * Observations:
 * 
 */
public class IsUnique {
    public static void main(String[] args)
    {
        IsUnique test = new IsUnique();

        /* Solution 1 */
        // all unique characters
        System.out.println(test.isUnique1("abcdef"));

        // single duplicate character
        System.out.println(test.isUnique1("aabcdef"));

        // empty string
        System.out.println(test.isUnique1(""));

        // > 128 characters
        System.out.println(test.isUnique1("abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde"));

        /* Solution 2 */
        // all unique characters
        System.out.println(test.isUnique2("abcdef"));

        // single duplicate character
        System.out.println(test.isUnique2("aabcdef"));

        // empty string
        System.out.println(test.isUnique2(""));

        // > 128 characters
        System.out.println(test.isUnique2("abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde"));
    }

    /** Solution x
     * Description:
     * Insert all characters into a hashset. A hashset only allows unique values.
     *  
     * Edge Cases:
     * s is an empty string
     * if we are using ascii, then if s will never iterate over more than 128 characters
     * 
     * Runtime:
     * Insertion to a hashset takes amortized O(1) time for best/average and O(n) for worst. 
     * If there is a collision, a hashset simply does not insert the value.
     * Iterating over all elements in the string takes O(n) time.
     * 
     * Space Complexity:
     * O(n) space for the hashset because we make a copy of n characters, where n is the number of characters in s.
     * 
     */
    
    public boolean isUnique1(String s)
    {
        if(s.length() > 128) return false;
    
        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray())
        {
            if(set.contains(c))
                return false;
            else
                set.add(c);
        }
        return true;
    }

    /** Solution 2
     * Description:
     * Insert all characters into a int array to record freqeuncy. 
     * If we find a letter that has a frequency > 0, then return false.
     * 
     * Even better, we can use a boolean array, because we are only worried about two values: 
     * whether the item has been inserted before or not
     * 
     * Edge Cases:
     * s is an empty string
     * if we are using ascii, then if s will never iterate over more than 128 characters
     * 
     * Runtime:
     * Insertion and access to an array takes O(1).
     * Iterating over all elements in the string takes O(n) time.
     * Could argue it takes O(1) time because we never iterate over more than 128 characters.
     * 
     * Space Complexity:
     * If we are using ascii, then space is O(1) because it will constantly be 128.
     * 
     */
    public boolean isUnique2(String s)
    {
        if(s.length() > 128) return false;

        boolean[] letters = new boolean[128];
        for(int i = 0; i < s.length(); i++)
        {
            int val = s.charAt(i);
            if(letters[val] == true)
                return false;
            letters[val] = true;
        }
        return true;
    }

    /** Solution 3
     * Description:
     * We can first sort the array and then check adjacent elements to check if there are duplicates.
     * 
     * Edge Cases:
     * s is an empty string
     * if we are using ascii, then if s will never iterate over more than 128 characters
     * 
     * Runtime:
     * Sorting takes O(nlogn) time.
     * Iterating over all elements in the string takes O(n) time.
     * 
     * Space Complexity:
     * Not counting the Array.sort() method, this method uses O(n) space because we make a char array out of s.
     * 
     */
    public boolean isUnique3(String s)
    {
        if(s.length() > 128) return false;
        
        char[] letters = s.toCharArray();
        Arrays.sort(letters);

        for(int i = 1; i < letters.length; i++)
        {
            if(letters[i] == letters[i-1])
                return false;
        }
        return true;
    }
}
