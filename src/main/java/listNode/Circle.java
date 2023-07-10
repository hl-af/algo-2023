package listNode;

import ListNodeUtils.ListNode;
import ListNodeUtils.ListUtils;
import org.junit.Test;

public class Circle {

    // 判断列表是否有环
    public Boolean hasCycle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testDetectCycle() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = ListUtils.arrayToList(a);
        ListNode p = head;
        ListNode secondNode = null;
        ListNode lastNode = null;
        for (int i = 0; i < a.length; i++) {
            if (i == 2) {
                secondNode = p;
            }
            if (i == a.length - 1) {
                lastNode = p;
            }
            p = p.next;
        }
        lastNode.next = secondNode;
        System.out.println(hasCycle(head));
        System.out.println(detectCycle(head).val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        int len = 1;
        fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            len++;
        }

        fast = head;
        slow = head;

        while (len-- > 0) {
            fast = fast.next;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
