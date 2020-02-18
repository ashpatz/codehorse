package ash.patz.learning.datastructures.linkedlist.helper;

public class Util {

    public static void printLinkedList(ListNode head) {
        StringBuilder builder = null;
        while (head != null) {
            if (builder == null) {
                builder = new StringBuilder();
                builder.append(head.val);
            } else {
                builder.append(" --> ");
                builder.append(head.val);
            }
            head = head.next;
        }
        System.out.println(builder);
    }

    public static ListNode buildLinkedList(int [] values) {
        ListNode first = null;
        ListNode head = null;
        for(int val : values) {
            if(head != null) {
                head.next = new ListNode(val);
                head = head.next;
            } else {
                head = new ListNode(val);
                first = head;
            }
        }
        return first;
    }
}
