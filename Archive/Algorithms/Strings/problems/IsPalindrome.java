package Strings;

public class IsPalindrome {
    public static void main(String[] args)
    {
        IsPalindrome test = new IsPalindrome();
        test.isPalindrome("A man, a plan, a canal: Panama");
    }
    
    public boolean isPalindrome(String s) {
        int front = 0, back = s.length() - 1;
        while(front < back)
        {
            while(front < back && !Character.isLetterOrDigit(s.charAt(front))) front++;
            while(front < back && !Character.isLetterOrDigit(s.charAt(back))) back--;
            
            if(Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(back))) return false;
                
            ++front;
            --back;
        }
        return true;
    }
}