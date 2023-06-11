package string;

import org.junit.Test;

public class IsPalindrome {

    @Test
    public void testIsPalindrome() {

        String test = "a,bbca";
        System.out.println(isPalindrome(test));

    }
    /**
     * LeetCode.125. 验证回⽂串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        Boolean isPalindrome = true;

        int left = 0;
        int right = s.length() - 1;

        char[] charArray = s.toCharArray();

        while (left < right) {
            while (left < charArray.length && !isCharacterOrDigital(charArray[left])) {
                left++;
            }
            while (right >0 && !isCharacterOrDigital(charArray[right])) {
                right--;
            }
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        return isPalindrome;
    }

    public boolean isCharacterOrDigital(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }else {
            return false;
        }
    }

}
