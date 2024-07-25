import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] test1 = new int[] {2,5,3,10};
        int target1 = 30;
        List<List<Integer>> res1 = s.findSubarrays2(test1, target1);
        System.out.println(res1);

        int[] test2 = new int[] {8,2,6,5};
        int target2 = 50;
        List<List<Integer>> res2 = s.findSubarrays2(test2, target2);
        System.out.println(res2);
    }

    /*
     * Given an array with positive numbers and a target number, 
     * find all of its contiguous subarrays whose product is less than the target number.
     */
    public List<List<Integer>> findSubarrays(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int currProduct = 1;
        for(int i = 0; i < nums.length; i++) {
            int j = i;
            List<Integer> sol = new ArrayList<>();
            while(j < nums.length) {
                currProduct *= nums[j];
                if(currProduct < target) {
                    sol.add(nums[j]);
                    res.add(new ArrayList<Integer>(sol));
                    j++;
                } else {
                    currProduct = 1;
                    break;        
                }
            }
        }
        return res;
    }

    /* 
     * Time: O(N^2)
     * Space: O(1) (exlucing solution space)
     */
    public List<List<Integer>> findSubarrays2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int product = 1;
            List<Integer> subarr = new ArrayList<>();
            for(int j = i; j < nums.length; j++) {
                if((nums[j] * product) < target) {
                    subarr.add(nums[j]);
                    product = nums[j] * product;
                } else {
                    break;
                }
                res.add(new ArrayList<Integer>(subarr));
            }
        }
        return res;
    }
}