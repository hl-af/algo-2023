package listNode;

import ListNodeUtils.ListNode;
import ListNodeUtils.ListUtils;
import org.junit.Test;

public class Reverse {

    /**
     * Leetcode61.：给你⼀个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }

        k = k % len;

        head = reverse(head);

        ListNode fast = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while (k-- > 0) {
            pre = pre.next;
            fast = fast.next;
        }
        pre.next = null; //断开两个列表
        ListNode last = head;
        head = reverse(head);
        fast = reverse(fast);
        last.next = fast;
        return head;
    }

    private ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }

        return pre;
    }


    @Test
    public void testRotateRight() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        ListNode head = rotateRight(ListUtils.arrayToList(arr), 2);
        ListUtils.printList(head);
    }

}
