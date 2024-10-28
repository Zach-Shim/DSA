import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        // exceeds time limit
        long start = System.currentTimeMillis();
        System.out.println(start);

        Solution1 sol = new Solution1();
        List<List<Integer>> res = sol.sol1(new int[] {-2,-1,-1,1,1,2,2}, 0);
        System.out.println(res.toString());

        long end = System.currentTimeMillis();
        System.out.println(end);
    }

    public List<List<Integer>> sol1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int front = 0, back = nums.length-1;
        while(front < back) {
            if(front > 0 && nums[front] == nums[front-1]) {front++; continue;}
            if(back < nums.length-1 && nums[back] == nums[back+1]) {back--; continue;}
            if(back - front <= 2) break;
            int p1 = front, p2 = front+1, p3 = back-1, p4 = back;
            while(p2 < p3) {
                int innerSum = nums[p1] + nums[p2] + nums[p3] + nums[p4];
                if(innerSum == target) {
                    while(p2 < p3 && nums[p2] == nums[p2+1]) p2++;
                    while(p3 > p2 && nums[p3] == nums[p3-1]) p3--;
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[p1],nums[p2],nums[p3],nums[p4])));
                    p2++;
                    p3--;
                } else if (innerSum < target) {
                    p2++;
                } else {
                    p3--;
                }
            }

            int outterSum = nums[front] + nums[back];
            if(outterSum <= target) {
                front++;
            } else {
                back--;
            }
        }
        return res;
    }
}
