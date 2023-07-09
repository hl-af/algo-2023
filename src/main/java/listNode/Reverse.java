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

    /**
     * LeetCode92 ：给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right。请你反转从位
     * 置 left 到位置 right 的链表节点，返回反转后的链表
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode start, end, p;
        p = head;
        left = left - 1; // 目标需要-1才能移动到指定位置
        right = right - left - 1;// right要提前算好，不能放到下面
        while (left-- > 0) {
            p = p.next;
            dumpHead = dumpHead.next;
        }
        start = p;

        while (right-- > 0) {
            p = p.next;
        }
        end = p;
        ListNode next = end.next;
        end.next = null;
        dumpHead.next = null;

        reverse(start);

        dumpHead.next = end;
        start.next = next;

        return head;

    }

    @Test
    public void testReverseBetween() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        ListNode head = reverseBetween(ListUtils.arrayToList(arr), 4, 6);
        ListUtils.printList(head);

    }


    /**
     * LeetCode25.给你⼀个链表，每 k 个节点⼀组进⾏翻转，请你返回翻转后的链
     * 表。k 是⼀个正整数，它的值⼩于或等于链表的⻓度。
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode dumpHead = pre;
        pre.next = head;
        ListNode p = head;
        while (p != null) {

            // 记录start
            ListNode start = pre.next;
            // 移动p到尾节点
            for (int i = 0; i < k - 1; i++) {
                p = p.next;
            }
            // 记录下一个节点
            ListNode next = p.next;
            // 清空
            p.next = null;
            pre.next = null;
            reverse(start);
            // 前驱指向新的头节点p，p原来是尾节点
            pre.next = p;
            // start变为尾节点，指向下一个节点
            start.next = next;
            // p移动
            p = next;
            pre = start;
        }

        return dumpHead.next; // 这里要单独使用dump的，不能使用pre。因为pre的位置移动了
    }

    @Test
    public void testReverseKGroup() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        ListNode head = reverseKGroup(ListUtils.arrayToList(arr), 2);
        ListUtils.printList(head);
    }
}
