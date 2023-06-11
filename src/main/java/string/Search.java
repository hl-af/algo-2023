package string;

import org.junit.Test;

public class Search {


    @Test
    public void testFirstUniqChar() {
        String test = "eetlcode";
        System.out.println(firstUniqChar(test));
    }
    /**
     * LeetCode387. 字符串中的第⼀个唯⼀字符
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {

        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] indexArray = new int[26];
        for (int i = 0; i < indexArray.length; i++) {
            indexArray[i] = -1;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int index = charArray[i] - 'a';
            if (indexArray[index] == -1) {
                indexArray[index] = i;
            }else {
                indexArray[index]= Integer.MAX_VALUE;
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < indexArray.length; i++) {
            if (indexArray[i] < minIndex && indexArray[i] != -1) {
                minIndex = indexArray[i];
            }
        }

        return minIndex;
    }

}
