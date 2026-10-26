class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        s = s.toLowerCase();

        int left = 0, right = n - 1;
        while (left < right) {
            if (!isAlphanumeric(s.charAt(left))) {
                left++;
                continue;
            }

            if (!isAlphanumeric(s.charAt(right))) {
                right--;
                continue;
            }

            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }
}
