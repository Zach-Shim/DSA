import java.util.*;
public class SlidingWindowMaximum {
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] {1,3,1,2,0,5}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) 
    {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] result = new int[n - k + 1];
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) 
            {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) 
            {
                dq.pollLast();
            }
            dq.offer(nums[i]);
            if (i - k + 1 >= 0)
            {
                result[i - k + 1] = nums[dq.peek()];
            }
        }
        return result;
    }
}