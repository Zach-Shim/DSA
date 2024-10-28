public class ClimbingStairs
{
    public static void main(String[] args)
    {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(2));   
    }

    public int climbStairs(int n) {
        if(n <= 0) return 0;
        //return waysToTop1(n);
        return waysToTop2(n, new int[n+1]);
    }
    
    // classic recursive solution, but takes way too long at O(2^n) time complexity
    private int waysToTop1(int n)
    {
        if(n <= 1) return 1;
        return waysToTop1(n - 1) + waysToTop1(n - 2);
    }

    // top down recursive approach, where we use memoization to cache previously done work and reduce the time complexity to O(n) and space complexity of O(1)
    private int waysToTop2(int n, int[] memo)
    {
        if(n <= 1) return 1;
        if(memo[n] == 0) memo[n] = waysToTop2(n-1, memo) + waysToTop2(n-2, memo);
        return memo[n];
    }

    // bottom up recursive approach, where we work from the base cases up to n, and can discard the cache to reduce the time complexity to O(n) and the space complexity to O(1)
    
}