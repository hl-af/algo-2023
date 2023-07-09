package listNode;

import ListNodeUtils.ListNode;
import ListNodeUtils.ListUtils;
import org.junit.Test;

import java.util.Stack;

public class Base {

    /**
     * 剑指offer52 ：输⼊两个链表，找出它们的第⼀个公共节点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode findFirstCommonNodeByStack(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode firstCommonNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode p1 = stack1.pop();
            ListNode p2 = stack2.pop();
            if (p1 != p2) {
                return firstCommonNode;
            }
            firstCommonNode = p1;
        }
        return null;
    }

    @Test
    public void testFindFirstCommonNodeByMap() {
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {11, 12, 13, 14};
        int[] a3 = {5, 6, 7};
        ListNode p1 = ListUtils.arrayToList(a1);
        ListNode p2 = ListUtils.arrayToList(a2);
        ListNode p3 = ListUtils.arrayToList(a3);
        p1 = ListUtils.conjTwoList(p1, p3);
        p2 = ListUtils.conjTwoList(p2, p3);
        ListNode node = findFirstCommonNodeByStack(p1, p2);
        System.out.println(node.val);
    }

    /**
     * 判断列表是否为回文串
     * @param head
     * @return
     */
    public boolean isPalindromeByStack(ListNode head) {

        if (head == null) {
            return true;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }

        p = head;
        int countHalf = count / 2;
        while (countHalf-- > 0) {
            stack.push(p);
            p = p.next;
        }

        while (!stack.isEmpty() && p != null) {
            ListNode peek = stack.pop();
            if (peek.val != p.val) {
                return false;
            }
            p = p.next;
        }

        // 如果p或者栈有没有清空的元素，说明不是回文
        if (!stack.isEmpty() || p != null) {
            return false;
        }

        return true;
    }

    public Boolean isPalindromeByFastAndSlow(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode mid = head;

        // 快指针的写法
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        mid = mid.next;
        fast = reverseList(mid);
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
        }

        if (slow != null || fast != null) {
            return false;
        }

        return true;

    }

    private ListNode reverseList(ListNode head) {

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
    public void testIsPalindrome() {
        int[] arr = new int[]{1, 2, 3, 3, 2, 1};
        ListNode head = ListUtils.arrayToList(arr);
        System.out.println(isPalindromeByStack(head));
        System.out.println(isPalindromeByFastAndSlow(head));
    }

    /**
     * LeetCode21 将两个升序链表合并为⼀个新的升序链表并返回，新链表是通过拼接给定的两个链表的所有节点组成的。
     * 定义一个新的head，来分别连接两个列表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode newHead = new ListNode(-1);
        ListNode p = newHead;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                p.next = list2;
                list2 = list2.next;
            } else if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            }else {
                p.next = list1;
                list1 = list1.next;
                p = p.next;
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        // 重定向到最后一个节点
        p = newHead;
        while (p.next != null) {
            p = p.next;
        }

        while (list1 != null) {
            p.next = list1;
            p = p.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            p.next = list2;
            p = p.next;
            list2 = list2.next;
        }

        return newHead.next;
    }

    @Test
    public void testMergeTwoLists() {
        int[] l1 = new int[]{1, 3, 7, 8, 9};
        int[] l2 = new int[]{-2};
        ListNode list1 = ListUtils.arrayToList(l1);
        ListNode list2 = ListUtils.arrayToList(l2);
        ListNode head = mergeTwoLists(list1, list2);
        ListUtils.printList(head);
    }


}
