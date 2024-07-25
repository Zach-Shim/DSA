
/*
 * One Away: 
 * There are three types of edits that can be performed on strings: 
 *      1. insert a character, 
 *      2. remove a character, 
 *      3. replace a character. 
 * 
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 */
public class OneAway {
    public static void main(String[] args)
    {
        // replacement test
        System.out.println(OneAway.oneAway("pale", "bale"));

        // insert test
        System.out.println(OneAway.oneAway("pale", "ple"));
        
        // removal test
        System.out.println(OneAway.oneAway("pales", "pale"));

        // false test
        System.out.println(OneAway.oneAway("pales", "bae"));
    }

    /** Solution x
     * Description:
     * Insert all characters into a hashset. A hashset only allows unique values.
     *  
     * Edge Cases:
     * phrase is an empty string
     * if we are using ascii, then if s will never iterate over more than 128 characters
     * 
     * Runtime:
     * O(n) where n is Math.max(s, t) where s and t and the lenghts of string inputs string 1 and string 2
     * 
     * Space Complexity:
     * O(1) not inclduing string parameters
     * 
     */
    public static boolean oneAway(String s1, String s2)
    {
        // same length
        if(s1.length() == s2.length())
            return onEditReplace(s1, s2);

        // insert or removal
        else if(s1.length() - 1 == s2.length())
            return onEditInsert(s1, s2);

        // insert or removal
        else if(s1.length() + 1 == s2.length())
            return onEditInsert(s2, s1);

        return false;
    }

    private static boolean onEditReplace(String s1, String s2) {
        boolean oneEdit = false;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(oneEdit) return true;
                oneEdit = true;
            }
        }
        return true;
    }

    private static boolean onEditInsert(String s1, String s2) {
        int index1 = 0, index2 = 0;
        while(index1 < s1.length() && index2 < s2.length())
        {
            if(s1.charAt(index1) != s2.charAt(index2)) {
                if(index1 != index2) return false;
                index1++;
            }
            else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
