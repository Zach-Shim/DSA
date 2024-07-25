package Strings;

/**
 * Problem Description for 'String Compression':
 * Implement a method to perform basic string compression using the counts of repeated characters. 
 * For example, the string aabcccccaaa would become a2blc5a3. 
 * If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * Questions:
 * 
 * Observations:
 * 
 */    

public class StringCompression {
    public static void main(String[] args)
    {
        System.out.println(StringCompression.compress("aabcccccaaa"));
    }

    public static String compress(String s)
    {
        StringBuilder result = new StringBuilder();

        int count = 0;
        int slow = 0, fast = 0;
        while(fast < s.length())
        {
            result.append(s.charAt(slow));
            while(fast < s.length() && s.charAt(slow) == s.charAt(fast))
            {
                ++count;
                ++fast;
            }
            slow = fast;
            result.append(count);
            count = 0;
        }
        return result.toString();
    }
}
