package listNode;

import ListNodeUtils.ListNode;
import ListNodeUtils.ListUtils;
import org.junit.Test;

import java.util.Stack;

public class Base {

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

}
