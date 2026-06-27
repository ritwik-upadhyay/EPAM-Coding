import java.util.*;
//Final class for tracking parking subscriptions
public final class ParkingLotMonthlySubscriptionTracker {
    //Node class for singly linked list
    static class Node {
        String vehicleNumber;
        int timestamp;
        Node next;
        Node(String vehicleNumber, int timestamp) {
            this.vehicleNumber = vehicleNumber;
            this.timestamp = timestamp;
        }
    }
    //Helper class to store exceeded vehicles
    static class VehicleExtra {
        String vehicleNumber;
        int extraEntries;
        VehicleExtra(String vehicleNumber, int extraEntries) {
            this.vehicleNumber = vehicleNumber;
            this.extraEntries = extraEntries;
        }
    }
    //Core Logic Function
    //Traverses Linked list and finds exceeded vehicles
    public static List<VehicleExtra> findExceededVehicles (
        Node head,
        Map<String, Integer> subscriptionMap
    ) {
        //Count actual parking entries
        Map<String, Integer> entryCountMap = new HashMap<>();
        Node current = head;
        while(current!=null) {
            String vehicle = current.vehicleNumber;
            //Count only subscribed vehicles
            if(subscriptionMap.containsKey(vehicle)) {
                entryCountMap.put(
                    vehicle,
                    entryCountMap.getOrDefault(vehicle,0)+1
                );
            }
            current = current.next;
        }
        //Store vehicles exceeding limits
        List<VehicleExtra> exceededList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryCountMap.entrySet()) {
            String vehicle = entry.getKey();
            int actualEntries = entry.getValue();
            int allowedEntries = subscriptionMap.get(vehicle);
            int extraEntries = actualEntries - allowedEntries;
            //Add only exceeded vehicles
            if(extraEntries>0) {
                exceededList.add(
                    new VehicleExtra(
                        vehicle,
                        extraEntries
                    )
                );
            }
        }
        //Sort
        //1. Higher extra entries first
        //2. Alphabetically if tie
        exceededList.sort((a,b) -> {
            int compareExtra = Integer.compare(
                b.extraEntries,
                a.extraEntries
            );
            if(compareExtra != 0) {
                return compareExtra;
            }
            return a.vehicleNumber.compareTo(b.vehicleNumber);
        });
        return exceededList;
    }
    //Helper Function
    //Efficient O(1) insertion using tail pointer
    public static Node appendNode(
        Node tail,
        Node newNode
    ) {
        tail.next = newNode;
        return newNode;
    }
    //Main Function
    //Reads input and prints result
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Read Parking Lot
        int E = sc.nextInt();
        Node head = null;
        Node tail = null;
        for(int i=0;i<E;i++) {
            String vehicleNumber = sc.next();
            int timestamp = sc.nextInt();
            Node newNode = new Node(
                vehicleNumber,
                timestamp
            );
            //Intialize linked list
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            //O(1) append
            else {
                tail = appendNode(tail, newNode);
            }
        }
        //Read Subscription Details
        int S = sc.nextInt();
        Map<String,Integer> subscriptionMap = new HashMap<>();
        for(int i=0;i<S;i++) {
            String vehicleNumber = sc.next();
            int allowedEntries = sc.nextInt();
            subscriptionMap.put(vehicleNumber, allowedEntries);
        }
        //Process result
        List<VehicleExtra> result = findExceededVehicles(head, subscriptionMap);
        for(VehicleExtra vehicle : result) {
            System.out.println(vehicle.vehicleNumber + " " + vehicle.extraEntries);
        }
        sc.close();
    }
}