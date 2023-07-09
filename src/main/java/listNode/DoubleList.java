package listNode;

import ListNodeUtils.ListNode;
import ListNodeUtils.ListUtils;
import org.junit.Test;

public class DoubleList {

    /**
     * LeetCode876 给定⼀个头结点为 head 的⾮空单链表，返回链表的中间结点。如果有两个中间结点，则返回第⼆个
     * 中间结点。
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (slow != null && fast != null && fast.next != null) {
            count++;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (count % 2 == 0) {
            return slow;
        }else {
            return slow.next;
        }

    }

    @Test
    public void testMiddleNode() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode node = middleNode(ListUtils.arrayToList(arr));
        System.out.println(node.val);
    }


}
