import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] test1 = new int[] {-1,0,2,3};
        int target1 = 3;
        int res1 = s.searchTriplets2(test1, target1);
        System.out.println(res1);

        int[] test2 = new int[] {-1,4,2,3,1};
        int target2 = 5;
        int res2 = s.searchTriplets2(test2, target2);
        System.out.println(res2);
    }

    /* 
    Description:
    Given an array arr of unsorted numbers and a target sum:
    count all triplets in it such that arr[i] + arr[j] + arr[k] < target 
    where i, j, and k are three different indices. 
    
    Write a function to return the count of such triplets.*/
    public int searchTriplets(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = nums.length-1;
            while(k > j) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < target) {
                    count += k-j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }

    public int searchTriplets2(int[] nums, int target) {
        Arrays.sort(nums);
        int counter = 0;
        for(int i = 0; i < nums.length; i++) {
            int p1 = i, p2 = i+1, p3 = nums.length-1;
            while(p2 < p3) {
                int sum = nums[p1] + nums[p2] + nums[p3];
                if(sum < target) {
                    counter += p3 - p2;
                    p2++;
                } else {
                    p3--;
                }
            }
        }
        return counter;
    }
}