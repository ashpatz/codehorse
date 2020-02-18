/**
 * https://leetcode.com/problems/add-two-numbers/
 * https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 * variation - https://www.geeksforgeeks.org/sum-of-two-linked-lists/
 */
package ash.patz.learning.datastructures.linkedlist;

import ash.patz.learning.datastructures.linkedlist.helper.ListNode;
import ash.patz.learning.datastructures.linkedlist.helper.Util;

public class SumTwo {

    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode result = null;

        l1 = Util.buildLinkedList(new int[]{2, 4, 3});
        l2 = Util.buildLinkedList(new int[]{5, 4, 6});
        result = addTwoNumbers(l1, l2); // {7, 8, 9}
        Util.printLinkedList(result);

        l1 = Util.buildLinkedList(new int[]{7, 1, 6});
        l2 = Util.buildLinkedList(new int[]{5, 9, 2});
        result = addTwoNumbers(l1, l2); // {2, 1, 9}
        Util.printLinkedList(result);

        l1 = Util.buildLinkedList(new int[]{0});
        l2 = Util.buildLinkedList(new int[]{0});
        result = addTwoNumbers(l1, l2); // {0}
        Util.printLinkedList(result);

        l1 = Util.buildLinkedList(new int[]{1, 6, 0, 3, 3, 6, 7, 2, 0, 1});
        l2 = Util.buildLinkedList(new int[]{6, 3, 0, 8, 9, 6, 6, 9, 6, 1});
        result = addTwoNumbers(l1, l2); // {7, 9, 0, 1, 3, 3, 4, 2, 7, 2}
        Util.printLinkedList(result);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        return addTwoNumbers(l1, l2, 0, head, current);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry, ListNode head, ListNode current) {
        int sum = carry;

        if (l1 == null && l2 == null && carry == 0) {
            return head;
        }
        int l1Val = l1 != null ? l1.val : 0;
        int l2Val = l2 != null ? l2.val : 0;
        ListNode result = null;
        sum = sum + l1Val + l2Val;

        if (sum > 9) {
            carry = 1;
            result = new ListNode(sum - 10);
        } else { //if (sum > 0) {
            carry = 0;
            result = new ListNode(sum);
        }

        if (head == null) {
            current = result;
            head = current;
        } else {
            current.next = result;
            current = current.next;
        }

        if (l1 != null && l2 != null) {
            addTwoNumbers(l1.next, l2.next, carry, head, current);
        } else if (l2 != null) { //l1 == null
            addTwoNumbers(null, l2.next, carry, head, current);
        } else if (l1 != null) { //l2 == null
            addTwoNumbers(l1.next, null, carry, head, current);
        }
        return head;
    }
}
