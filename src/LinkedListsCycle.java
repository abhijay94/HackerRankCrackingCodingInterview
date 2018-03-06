import java.util.ArrayList;

public class LinkedListsCycle {

    //Detect a cycle in a linked list. Note that the head pointer may be 'NULL' if the list is empty.
    // A Node is defined as:
    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        ArrayList<Node> visitedList = new ArrayList<>();
        if (head == null) {
            return false;
        } else {
            while (head != null) {
                if (visitedList.contains(head)) return true;
                else {
                    visitedList.add(head);
                    head = head.next;
                }
            }
            return false;
        }
    }
}
