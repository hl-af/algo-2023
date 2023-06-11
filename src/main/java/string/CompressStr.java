package string;

import org.junit.Test;

public class CompressStr {

    @Test
    public void testCompress() {

        String testCase = "aaaaaaaaaaaaabbbbbbbbbbbcc";
        char[] charArray = testCase.toCharArray();
        int a = compress(charArray);
        System.out.println(a);

    }

    // 字符串压缩问题
    public int compress(char[] chars) {

        if (chars == null || chars.length == 0) {
            return 0;
        }

        int left = 0; // 相同字符的初始位置
        int write = 0;// 写入游标
        for (int read = 0; read < chars.length; read++) {
            if (read == chars.length - 1 || chars[read] != chars[read + 1]) { // 不容易想到的点，read+1的写法兼顾不了最后一位，所以要在最后一位做特殊处理
                chars[write++] = chars[read]; // 写入游标为了避免遗忘，用这样的写法
                int length = read - left + 1;
                if (length > 1) {
                    int ancor = write;
                    while (length > 0) {
                        chars[write++] = (char) (length % 10 + '0'); // 数字转换字符数的写法
                        length = length / 10;
                    }
                    reverseArray(chars, ancor, write - 1);
                }
                left = read + 1;
            }
        }

        return write;

    }

    public void reverseArray(char[] array, int left, int right) {
        while (left <= right) {
            char c = array[left];
            array[left] = array[right];
            array[right] = c;
            left++;
            right--;
        }
    }
}
