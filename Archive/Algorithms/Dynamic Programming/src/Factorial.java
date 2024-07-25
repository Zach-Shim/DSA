public class Factorial {
    public static void main(String[] args)
    {
        int n = 5;
        System.out.println(factorial(n));
        System.out.println(factorialTD(n, new int[n+1]));
        System.out.println(factorialBU(n));
    }

    // classic recursive technique
    // Time Complexity: takes O(2^n) time, way too long
    // space complexity: O(n) 
    private static int factorial(int n)
    {
        if(n <= 2) return 1;
        return factorial(n-1) + factorial(n-2);
    }

    // top-down recursion using memoization
    // Time Complexity: reduces to O(2n) = O(n)
    // Space Complexity: O(n)
    private static int factorialTD(int n, int[] memo)
    {
        if(n <= 1) return n;
        if(memo[n] == 0) memo[n] = factorial(n-1) + factorial(n-2);
        return memo[n];
    }

    // bottom-up recursion 
    // Time Complexity: reduces to O(2n) = O(n)
    // Space Complexity: O(n)
    private static int factorialBU(int n)
    {
        if(n <= 1) return n;
        
        int a = 0, b = 1;
        for(int i = 2; i < n; i++)
        {
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }
}
