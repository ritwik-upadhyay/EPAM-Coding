import java.util.*;
public class ParkEase {
    
    //---------------VEHICLE--------------------
    static abstract class Vehicle {
        private String registrationNo;
        private String owner;
        public Vehicle(String registrationNo, String owner) {
            this.registrationNo = registrationNo;
            this.owner = owner;
        }
        public String getRegistrationNo() {
            return this.registrationNo;
        }
        public String getOwner() {
            return this.owner;
        }
        public abstract String getVehicleType();
    }
    //CAR
    static class Car extends Vehicle {
        public Car(String reg, String owner) {
            super(reg,owner);
        }
        @Override
        public String getVehicleType() {
            return "Car";
        }
    }
    //Bike
    static class Bike extends Vehicle {
        public Bike(String reg, String owner) {
            super(reg,owner);
        }
        @Override
        public String getVehicleType() {
            return "Bike";
        }
    }
    //-------------------SLOT--------------------
    static class Slot {
        String slotId;
        String type;
        Vehicle vehicle;
        Slot(String slotId, String type) {
            this.slotId = slotId;
            this.type = type;
            this.vehicle = null;
        }
        boolean isFree() {
            return vehicle == null;
        }
    }
    //-------------------FLOOR---------------------
    static class Floor {
        String floorId;
        List<Slot> carSlots;
        List<Slot> bikeSlots;
        Floor(String floorId) {
            this.floorId = floorId;
            carSlots = new ArrayList<>();
            bikeSlots = new ArrayList<>();
            //Car slots
            carSlots.add(new Slot("C1","Car"));
            carSlots.add(new Slot("C2","Car"));
            carSlots.add(new Slot("C3","Car"));
            //Bike slots
            bikeSlots.add(new Slot("B1","Bike"));
            bikeSlots.add(new Slot("B2", "Bike"));
        }
    }
    //------------------PARKING RECORD----------------
    static class ParkingRecord {
        Vehicle vehicle;
        String floorId;
        String slotId;
        ParkingRecord(Vehicle vehicle, String floorId, String slotId) {
            this.vehicle = vehicle;
            this.floorId = floorId;
            this.slotId = slotId;
        }
    }
    //Floors
    static List<Floor> floors = new ArrayList<>();
    //O(1) lookup map
    static Map<String, ParkingRecord> parkingMap = new HashMap<>();
    //-----------INITIALIZE FLOORS--------------------
    static void initializeParkingLot() {
        floors.add(new Floor("F1"));
        floors.add(new Floor("F2"));
    }
    //-----------PARK VEHICLE--------------------------
    static void parkVehicle(String eventId, Vehicle vehicle) {
        for(Floor floor : floors) {
            List<Slot> slots;
            if(vehicle.getVehicleType().equals("Car")) {
                slots = floor.carSlots;
            }
            else {
                slots = floor.bikeSlots;
            }
            for(Slot slot : slots) {
                if(slot.isFree()) {
                    slot.vehicle = vehicle;
                    ParkingRecord record = new ParkingRecord(vehicle, floor.floorId, slot.slotId);
                    parkingMap.put(vehicle.registrationNo, record);
                    System.out.println(
                        eventId + ": "
                                + vehicle.registrationNo
                                + " (" + vehicle.owner + ") parked at "
                                + floor.floorId + "-"
                                + slot.slotId
                    );
                    return;
                }
            }
        }
        System.out.println(
            eventId + ": No slot available for " + vehicle.registrationNo
        );
    }
    //-----------------LEAVE VEHICLE-------------------
    static void leaveVehicle(String eventId, String registrationNo) {
        ParkingRecord record = parkingMap.get(registrationNo);
        if(record == null) {
            System.out.println(eventId + ": Vehicle not found");
            return;
        }
        for(Floor floor : floors) {
            if(!floor.floorId.equals(record.floorId)) {
                continue;
            }
            List<Slot> slots;
            if(record.vehicle.getVehicleType().equals("Car")) {
                slots = floor.carSlots;
            }
            else {
                slots = floor.bikeSlots;
            }
            for(Slot slot : slots) {
                if(slot.slotId.equals(record.slotId)) {
                    slot.vehicle = null;
                    parkingMap.remove(registrationNo);
                    System.out.println(
                        eventId + ": "
                                + registrationNo
                                + " (" + record.vehicle.owner + ") left from " 
                                + floor.floorId + "-" 
                                + slot.slotId
                                + " [slot freed]"
                    );
                    return;
                }
            }
        }
    }
    //----------------LOOKUP------------------
    static void lookupVehicle(
        String registrationNo
    ) {
        ParkingRecord record = parkingMap.get(registrationNo);
        if(record == null) {
            System.out.println(
                "Lookup " + registrationNo
                          + " -> Vehicle not found"
            );
            return;
        }
        System.out.println(
            "Lookup " + registrationNo
                      + " -> "
                      + record.vehicle.owner 
                      + " | " 
                      + record.floorId + "-"
                      + record.slotId 
                      + " | "
                      + record.vehicle.getVehicleType()
        );
    }
    //-----------------FLOOR REPORT---------------------
    static void printFloorReport() {
        for(Floor floor : floors) {
            StringBuilder sb = new StringBuilder();
            sb.append("Floor ").append(floor.floorId).append(": ");
            //Car slots
            for(Slot slot : floor.carSlots) {
                sb.append(slot.slotId);
                if(slot.isFree()) {
                    sb.append("[free] ");
                }
                else {
                    sb.append("[").append(slot.vehicle.owner).append("] ");
                }
            }
            //Bike slots
            for(Slot slot : floor.bikeSlots) {
                sb.append(slot.slotId);
                if(slot.isFree()) {
                    sb.append("[free] ");
                }
                else {
                    sb.append("[").append(slot.vehicle.owner).append("] ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
    //-----------------MAIN-------------------
    public static void main(String[] args) {
        initializeParkingLot();
        //E01
        parkVehicle(
            "E01",
            new Car(
                "KA-01-AB-1234",
                "Arjun Mehta"
            )
        );
        //E02
        parkVehicle(
            "E02",
            new Bike(
                "KA-05-CD-5678",
                "Sara Khan"
            )
        );
        //E03
        parkVehicle(
            "E03",
            new Car(
                "KA-03-EF-9012",
                "Ravi Kumar"
            )
        );
        //E04
        parkVehicle(
            "E04",
            new Car(
                "KA-02-GH-3456",
                "Priya Nair"
            )
        );
        //E05
        parkVehicle(
            "E05",
            new Bike(
                "KA-09-IJ-7890",
                "Dev Sharma"
            )
        );
        //E06
        leaveVehicle(
            "E06",
            "KA-01-AB-1234"
        );
        //E07
        parkVehicle(
            "E07",
            new Car(
                "KA-07-KL-2345",
                "Meena Iyer"
            )
        );
        //E08
        leaveVehicle(
            "E08",
            "KA-05-CD-5678"
        );
        System.out.println();
        //Lookups
        lookupVehicle("KA-03-EF-9012");
        lookupVehicle("KA-07-KL-2345");
        lookupVehicle("KA-99-ZZ-0000");
        System.out.println();
        //Occupancy Report
        printFloorReport();
    }
}
