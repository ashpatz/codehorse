package ash.patz.learning.datastructures.linkedlist;

import ash.patz.learning.datastructures.linkedlist.helper.LinkedListNode;
import ash.patz.learning.datastructures.linkedlist.helper.Util;

public class Partition {

    public static void main(String[] args) {

        LinkedListNode head = new LinkedListNode(3);
        LinkedListNode current = Util.appendToList(5, head);
        current = Util.appendToList(8, current);
        current = Util.appendToList(10, current);
        current = Util.appendToList(5, current);
        current = Util.appendToList(2, current);
        Util.appendToList(1, current);
        Util.printLinkedList(head);
        Util.printLinkedList(arrange(head, 5));
    }


    private static LinkedListNode arrange(LinkedListNode head, int x) {
        LinkedListNode beforeListStart = null;
        LinkedListNode beforeListCurrent = null;
        LinkedListNode afterListStart = null;
        LinkedListNode afterListCurrent = null;

        while(head != null) {

            if(head.getValue() < x) {

                if(beforeListStart == null) {
                    beforeListStart = head;
                    beforeListCurrent = head;
                } else {
                    beforeListCurrent.next = head;
                    beforeListCurrent = beforeListCurrent.next;
                }

            } else {
                if(afterListStart == null) {
                    afterListStart = head;
                    afterListCurrent = head;
                } else {
                    afterListCurrent.next = head;
                    afterListCurrent = head;
                }
            }

            head = head.next;
        }

        afterListCurrent.next = null;
        beforeListCurrent.next = afterListStart;
        return beforeListStart;
    }
}
