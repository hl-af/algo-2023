package string;

import org.junit.Test;


public class StringBase {


    @Test
    public void testToLowerCharacter() {

        String hello = "HelLo";
        System.out.println(toLowerCase(hello));

    }

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

}
