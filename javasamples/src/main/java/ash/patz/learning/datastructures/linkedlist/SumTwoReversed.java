/**
 * https://www.geeksforgeeks.org/sum-of-two-linked-lists/
 */
package ash.patz.learning.datastructures.linkedlist;

import ash.patz.learning.datastructures.linkedlist.helper.ListNode;
import ash.patz.learning.datastructures.linkedlist.helper.Util;

public class SumTwoReversed {

    static class WrapInt {
        int value;

        WrapInt(int value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode result = null;

//        l1 = Util.buildLinkedList(new int[]{2, 4, 3});
//        l2 = Util.buildLinkedList(new int[]{5, 4, 6});
//        result = addTwoNumbers(l1, l2); // {7, 8, 9}
//        Util.printLinkedList(result);

        l1 = Util.buildLinkedList(new int[]{7, 1, 6});
        l2 = Util.buildLinkedList(new int[]{5, 9, 2});
        result = addTwoNumbers(l1, l2); // {1, 3, 0, 8}
        Util.printLinkedList(result);

//        l1 = Util.buildLinkedList(new int[]{0});
//        l2 = Util.buildLinkedList(new int[]{0});
//        result = addTwoNumbers(l1, l2); // {0}
//        Util.printLinkedList(result);

//        l1 = Util.buildLinkedList(new int[]{1, 6, 0, 3, 3, 6, 7, 2, 0, 1});
//        l2 = Util.buildLinkedList(new int[]{6, 3, 0, 8, 9, 6, 6, 9, 6, 1});
//        result = addTwoNumbers(l1, l2); // {7, 9, 0, 1, 3, 3, 4, 2, 7, 2}
//        Util.printLinkedList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        WrapInt carry = new WrapInt(0);
        ListNode head = addTwoNumbers(l1, l2, carry);
        if(carry.value > 0) {
            ListNode carryOver = new ListNode(carry.value);
            carryOver.next = head;
            return carryOver;
        }
        return head;
    }

    /**
     * Traverse first, then compute
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, WrapInt carry) {
        if(l1 == null && l2 == null) {
            return null;
        } else {
            ListNode next = addTwoNumbers(l1.next, l2.next, carry);
            int sum = carry.value;
            sum += l1.val;
            sum += l2.val;
            ListNode result = new ListNode(sum % 10);
            carry.value = sum > 9 ? 1 : 0;
            result.next = next;
            return result;
        }
    }
}
