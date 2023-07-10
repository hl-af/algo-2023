package listNode;

import ListNodeUtils.ListNode;
import ListNodeUtils.ListUtils;
import org.junit.Test;

public class DeleteNode {


    /**
     * LeetCode 203：给你⼀个链表的头节点 head 和⼀个整数 val ，请你删除链表中所有满⾜
     * Node.val == val 的节点，并返回新的头节点 。
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummpyHead = new ListNode(-1);
        dummpyHead.next = head;
        ListNode pre = dummpyHead;
        ListNode p = head;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
                p.next = null;
                pre = pre.next;
                p = pre;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }

        return dummpyHead.next;
    }

    @Test
    public void testRemoveElements() {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        ListNode head = removeElements(ListUtils.arrayToList(arr), 1);
        ListUtils.printList(head);
    }
}
