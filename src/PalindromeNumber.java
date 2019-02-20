/**
 * Problem 9: Palindrome Number
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        int reverse = 0;

        while (temp != 0) {
            reverse *= 10;
            reverse += temp % 10;
            temp /= 10;
        }

        return reverse == x;
    }

    public static void main(String[] args) {
        boolean isPalindrome = new PalindromeNumber().isPalindrome(121);
        System.out.println(isPalindrome);
    }
}
