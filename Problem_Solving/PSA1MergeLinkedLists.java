package Problem_Solving;

public class PSA1MergeLinkedLists {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;
        LinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = tail.next;
        }

        public void displayLinkedList(Node head) {
            if (head == null) {
                System.out.println("Linked List is empty");
                return;
            }
            System.out.print("[");
            Node curr = head;
            while (curr != null) {
                if (curr.next == null) {
                    System.out.print(curr.data);
                } else {
                    System.out.print(curr.data + ", ");
                }
                curr = curr.next;
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static Node mergeLinkedLists(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node current = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                current = current.next;
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
        }

        if (head1 == null) {
            current.next = head2;
        } else {
            current.next = head1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        System.out.println("Linked List 1:");
        list1.displayLinkedList(list1.head);

        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(3);
        list2.add(4);
        System.out.println("Linked List 2:");
        list2.displayLinkedList(list2.head);

        LinkedList list3 = new LinkedList();
        Node head3 = mergeLinkedLists(list1.head, list2.head);
        System.out.println("Merged Linked List 1 and 2 are:");
        list3.displayLinkedList(head3);
    }
}