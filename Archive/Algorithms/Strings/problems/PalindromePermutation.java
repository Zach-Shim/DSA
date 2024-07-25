public class PalindromePermutation {
    public static void main(String[] args)
    {
        PalindromePermutation test = new PalindromePermutation();
        int[] frequency = test.isPalindromePermutation("Tact Coa");
        System.out.println(test.checkOddCount(frequency));
    }
    
    public boolean checkOddCount(int[] frequency) {
        boolean foundOdd = false;
        for(int i : frequency) {
            if(i % 2 != 0) {
                if(foundOdd) return false;
                foundOdd = true;
            }
        }
        return true;
    }

    public int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if(val >= a && val <= z) {
            return val - a;
        }
        return -1;                           
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
     * O(n+n) = O(n) time where n is the length of the string.
     * 
     * Space Complexity:
     * O(n) space because we create a frequency array according to the length of phrase.
     * 
     */
    public int[] isPalindromePermutation(String phrase) {
        int[] frequency = new int [
                                    Character.getNumericValue('z') -
                                    Character.getNumericValue('a') + 1
                                  ];

        for(char c : phrase.toCharArray()) {
            int index = getCharNumber(Character.toLowerCase(c));
            if(index != -1) {
                frequency[index]++;
            }
        }

        return frequency;
    }
}
