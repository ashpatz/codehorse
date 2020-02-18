/**
 * https://www.geeksforgeeks.org/partitioning-a-linked-list-around-a-given-value-and-keeping-the-original-order/
 * https://leetcode.com/problems/partition-list/
 */
package ash.patz.learning.datastructures.linkedlist;

import ash.patz.learning.datastructures.linkedlist.helper.ListNode;
import ash.patz.learning.datastructures.linkedlist.helper.Util;

public class Partition {

    public static void main(String[] args) {
        ListNode head = null;
        head = Util.buildLinkedList(new int[]{3, 5, 8, 10, 5, 2, 1});
        Util.printLinkedList(head);
        Util.printLinkedList(arrange(head, 5));

        head = Util.buildLinkedList(new int[]{1});
        Util.printLinkedList(arrange(head, 0));
    }


    private static ListNode arrange(ListNode head, int x) {

        if(head == null) {
            return head;
        }

        ListNode beforeListStart = null;
        ListNode beforeListCurrent = null;
        ListNode afterListStart = null;
        ListNode afterListCurrent = null;

        while (head != null) {

            if (head.val < x) {

                if (beforeListStart == null) {
                    beforeListStart = head;
                    beforeListCurrent = head;
                } else {
                    beforeListCurrent.next = head;
                    beforeListCurrent = beforeListCurrent.next;
                }

            } else {
                if (afterListStart == null) {
                    afterListStart = head;
                    afterListCurrent = head;
                } else {
                    afterListCurrent.next = head;
                    afterListCurrent = head;
                }
            }

            head = head.next;
        }

        if(afterListCurrent != null && beforeListCurrent != null) {
            afterListCurrent.next = null;
            beforeListCurrent.next = afterListStart;
            return beforeListStart;
        } else if(afterListCurrent != null) {
            return afterListStart;
        } else { //(beforeListCurrent != null) && (afterListCurrent == null)
            return beforeListStart;
        }

    }
}
