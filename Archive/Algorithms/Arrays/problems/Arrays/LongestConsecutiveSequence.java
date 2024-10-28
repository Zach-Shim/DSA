package Arrays;
import java.util.*;
public class LongestConsecutiveSequence {
    public static void main(String[] args)
    {
        LongestConsecutiveSequence.longestConsecutive(new int[] {100,4,200,1,3,2});
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i : nums) map.put(i, null);
        
        Set<Integer> set = map.keySet();
        for(int i : set)
        {
            System.out.println(i);
        }
        return 0;
    }
}
