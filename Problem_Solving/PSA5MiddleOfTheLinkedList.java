package Problem_Solving;
public class PSA5MiddleOfTheLinkedList {
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
        public void add(int data) {
            Node newNode = new Node(data);
            if(head==null) {
                head = newNode;
                tail = newNode;
            }
            else {
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
    public static int findMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;    
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        System.out.println(findMiddleNode(list.head));
    }
}