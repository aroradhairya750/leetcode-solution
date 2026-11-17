class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0 (except 0 itself) are never palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even length, x == reversedHalf
        // For odd length, x == reversedHalf / 10 (middle digit doesn't matter)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}