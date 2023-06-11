package string;

import org.junit.Test;

public class ReverseString {


    @Test
    public void testReverseCharacter() {

        String test = "hello";
        char[] testCharArray = reverseCharacter(test.toCharArray());
        System.out.println(new String(testCharArray));

    }
    /**
     * LeetCode344. 反转字符串
     * @param chars
     * @return
     */
    public char[] reverseCharacter(char[] chars) {

        if (chars.length == 0) {
            return chars;
        }
        int left = 0;
        int right = chars.length - 1;
        for (left = 0; left <= right; left++) {
            char tempChar = chars[left];
            chars[left] = chars[right];
            chars[right] = tempChar;
            right--;
        }

        return chars;
    }

    @Test
    public void testKreverse() {

        String test = "abcdefgh";
        int k = 3;
        System.out.println(Kreverse(test, k));

    }

    /**
     * LeetCode541. K个⼀组反转
     * @param chars
     * @param k
     * @return
     */
    public String Kreverse(String chars, int k) {

        if (chars == null || chars.length() == 0 || k == 0) {
            return chars;
        }

        int left = 0;
        int right = k - 1;
        char[] charsArray = chars.toCharArray();
        while (right < chars.length()) {

            int currentOffset = right + 1; // 记录上层循环的开始位置
            while (left <= right) {
                char temp = charsArray[left];
                charsArray[left] = charsArray[right];
                charsArray[right] = temp;
                left++;
                right--;
            }
            left = currentOffset;
            right = left + k - 1;
        }
        return new String(charsArray);

    }


}
