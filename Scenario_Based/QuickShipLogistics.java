public class QuickShipLogistics {
    //-------NODE OF LINKED LIST-------
    static class Node {
        String address;
        Node next;
        Node prev;
        Node(String address) {
            this.address = address;
            this.next = null;
            this.prev = null;
        }
    }
    //-------DELIVERY ROUTE----------
    static class DeliveryRoute {
        private Node head;
        private Node tail;
        //Add stop at the end
        public void addStop(String address) {
            Node newNode = new Node(address);
            if(head==null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        //Add urgent stop at the beginning
        public void addUrgentStop(String address) {
            Node newNode = new Node(address);
            if(head==null) {
                head = newNode;
                tail = newNode;
            }
            else {
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
            }
        }
        //Remove first stop after completion
        public String deliverNext() {
            if(head==null) {
                return "None";
            }
            else if(head==tail) {
                String nextStop = head.address;
                head = null;
                tail = null;
                return nextStop;
            }
            else {
                String nextStop = head.address;
                head = head.next;
                head.prev = null;
                return nextStop;
            }
        }
        //Remove last stop after customer cancelled
        public String cancelLastStop() {
            if(head==null) {
                return "None";
            }
            else if(tail==head) {
                String lastStop = tail.address;
                head = null;
                tail = null;
                return lastStop;
            }
            else {
                String lastStop = tail.address;
                tail = tail.prev;
                tail.next = null;
                return lastStop;
            }
        }
        //Return next stop to deliver without removing it
        public String peekNext() {
            if(head==null) {
                return "None";
            }
            String nextStop = head.address;
            return nextStop;
        }
        //Return last stop to deliver without removing it
        public String peekLast() {
            if(head==null) {
                return "None";
            }
            String lastStop = tail.address;
            return lastStop;
        }
        //Display Delivery Route
        public void displayDeliveryRoute() {
            if(head==null) {
                System.out.println("No addresses found in the delivery route");
                return;
            }
            System.out.print("[");
            Node curr = head;
            while(curr!=null) {
                if(curr.next==null) {
                    System.out.print(curr.address);
                }
                else {
                    System.out.print(curr.address + ", ");
                }
                curr = curr.next;
            }
            System.out.print("]");
            System.out.println();
        }
    }
    //----------MAIN---------
    public static void main(String[] args) {
        DeliveryRoute route = new DeliveryRoute();
        route.addStop("Karol Bagh");
        route.addStop("Lajpat Nagar");
        route.addStop("Connaught Place");
        route.displayDeliveryRoute();

        route.addUrgentStop("Nehru Place");
        route.displayDeliveryRoute();

        String nextStop = route.deliverNext();
        System.out.println(nextStop);
        route.displayDeliveryRoute();

        route.addStop("Dwarka");
        route.displayDeliveryRoute();

        String lastStop = route.cancelLastStop();
        System.out.println(lastStop);
        route.displayDeliveryRoute();

        String peekNextStop = route.peekNext();
        System.out.println(peekNextStop);
        route.displayDeliveryRoute();

        String peekLastStop = route.peekLast();
        System.out.println(peekLastStop);
        route.displayDeliveryRoute();

        System.out.println(route.deliverNext());
        route.displayDeliveryRoute();

        System.out.println(route.deliverNext());
        route.displayDeliveryRoute();

        System.out.println(route.cancelLastStop());
        route.displayDeliveryRoute();
        
        System.out.println(route.deliverNext());
        route.displayDeliveryRoute();
    }
}