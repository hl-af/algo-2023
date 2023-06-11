package string;

import org.junit.Test;

import java.util.Arrays;

public class CommonnPrefix {

    @Test
    public void testLongestCommonPrefix() {
        String[] testCase = new String[]{"abcseee", "abcs","evc"};
        System.out.println(longestCommonPrefix(testCase));
    }

    public String longestCommonPrefix(String[] strs) {

        int length = 0;
        Boolean same = true;
        StringBuilder stringBuilder = new StringBuilder();
        while (same) {
            char c = ' ';
            if (strs[0].length() > length) {
                c = strs[0].charAt(length);
            }else {
                break;
            }
            for (int i = 0; i < strs.length; i++) {

                // 判断长度是否越界
                if (length == strs[i].length() - 1) {
                    same = false;
                    break;
                }

                if (strs[i].charAt(length) == c) {
                    continue;
                }else{
                    same = false;
                }
            }
            if (same) {
                stringBuilder.append(c);
            }
            length++;
        }
        return stringBuilder.toString();
    }

    //TODO 归并的写法
}
