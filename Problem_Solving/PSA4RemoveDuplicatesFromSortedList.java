package Problem_Solving;

public class PSA4RemoveDuplicatesFromSortedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;

        public LinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addElement(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }

        }

        @Override
        public String toString() {
            String list = "";
            Node current = head;
            if (head == null) {
                return "Linked List is Empty.";
            }
            list += "[";
            while (current != null) {
                if (current.next == null) {
                    list += current.data + "]";
                } else {
                    list += current.data + ",";
                }
                current = current.next;
            }
            return list;
        }
    }

    public static void removeDuplicates(Node head) {
        if (head == null) {
            System.out.println("Empty Linked List.");
            return;
        }
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addElement(1);
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(3);
        System.out.println("Linked List: " + list);
        removeDuplicates(list.head);
        System.out.println("After removing duplicates, Linked List: " + list);
    }
}
