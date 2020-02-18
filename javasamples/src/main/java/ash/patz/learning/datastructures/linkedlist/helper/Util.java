package ash.patz.learning.datastructures.linkedlist.helper;

public class Util {

    public static void printLinkedList(LinkedListNode head) {
        StringBuilder builder = null;
        while (head != null) {
            if (builder == null) {
                builder = new StringBuilder();
                builder.append(head.getValue());
            } else {
                builder.append(" --> ");
                builder.append(head.getValue());
            }
            head = head.next;
        }
        System.out.println(builder);
    }

    public static LinkedListNode appendToList(int value, LinkedListNode head) {
        head.next = new LinkedListNode(value);
        return head.next;
    }
}
