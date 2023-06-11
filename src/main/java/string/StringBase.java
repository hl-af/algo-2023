package string;

import org.junit.Test;


public class StringBase {


    @Test
    public void testToLowerCharacter() {

        String hello = "HelLo";
        System.out.println(toLowerCase(hello));

    }

    /**
     * LeetCode709. 转换成⼩写字⺟
     * @param words
     * @return
     */
    public String toLowerCase(String words) {

        if (words == null || words.length() == 0) {
            return "";
        }
        char[] array =  words.toCharArray(); // 转换为字符串数组的写法
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] += 32; // 如果使用‘a’会有问题
            }
        }
        return new String(array);
    }


    @Test
    public void testMyAtoi() {
        String numStr = "321";
        Integer res = myAtoi(numStr);
        System.out.println("负数测试:" + res);


        String numCharacter = "-321abc";
        System.out.println("后面有字母:" + myAtoi(numCharacter));

        String numCharacterFront = "abc321";
        System.out.println("前面有字母:" + myAtoi(numCharacterFront));

        String upMax = "-2147483650";
        System.out.println("超出最大值:" + myAtoi(upMax));

    }

    /**
     * LeetCode709. 转换成⼩写字⺟
     * 1. 前后是空格的过滤
     * 2. 后面是英文的，丢弃
     * 3. 有负号的，保留
     * @param numStr
     * @return
     */
    public Integer myAtoi(String numStr) {

        Integer res = 0;
        if (numStr == null || numStr.length() == 0) {
            return res;
        }
        int index = 0;
        // 过滤空格
        while (numStr.charAt(index) == ' ') {
            index++;
        }
        Integer one = 1;

         // 符号问题
        if (numStr.charAt(index) == '-') {
            one = -1;
            index++;
        }

        // 转换
        while (index < numStr.length()) {

            int num = (numStr.charAt(index) - '0');//使用Integer.valueOf(numStr.charAt(index))会变成对应的asciid，或者使用字符串

            if (num > 9) {
                break;
            }
            num = one * num;

            // 截断判断
            if ((res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10) ||
                    (res > Integer.MAX_VALUE / 10)) {
                res = Integer.MAX_VALUE;
                break;
            } else if ((res == Integer.MIN_VALUE / 10 && num < Integer.MIN_VALUE % 10) ||
                    (res < Integer.MIN_VALUE / 10)) {
                res = Integer.MIN_VALUE;
                break;
            }

            res = res * 10 + num;
            index++;
        }

        return res;

    }

    public static void main(String[] args) {

        System.out.println(Integer.valueOf("3"));//输出ascii
        System.out.println("最大值:" + Integer.MAX_VALUE);
        System.out.println("最小值:" + Integer.MIN_VALUE);

    }

}
