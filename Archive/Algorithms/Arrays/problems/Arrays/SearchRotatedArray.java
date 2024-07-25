package Arrays;

public class SearchRotatedArray
{
    public static void main(String[] args)
    {
        SearchRotatedArray.search(new int[]{4,5,6,7,0,1,2}, 0);
    }

    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        
        // find smallest value in the array
        while(lo < hi)
        {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        
        // regular binary search, accounting for the wrapping of the rotation
        int trueLo = lo;
        lo = 0;
        hi = nums.length - 1;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int trueMid = (trueLo + mid) % nums.length;
            if(target == nums[trueMid])
                return trueMid;
            else if(target > nums[trueMid])
                lo = mid+1;
            else if(target < nums[trueMid])
                hi = mid-1;
        }
        return - 1;
    }
}