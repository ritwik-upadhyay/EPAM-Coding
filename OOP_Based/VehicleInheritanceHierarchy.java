class Vehicle {
        public void start() {
            System.out.println("Vehicle starts.");
        }
        public void stop() {
            System.out.println("Vehicle stops.");
        }
    }
class Car extends Vehicle {
        @Override
        public void start() {
            super.start();
            System.out.println("Car starts.");
        }
        @Override
        public void stop() {
            super.stop();
            System.out.println("Car stops.");
        }
}
class Bike extends Vehicle {
        @Override
        public void start() {
            super.start();
            System.out.println("Bike starts.");
        }
        @Override
        public void stop() {
            super.stop();
            System.out.println("Bike stops.");
        }
}
public class VehicleInheritanceHierarchy {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Car();
        Vehicle v3 = new Bike();
        v1.start();
        v1.stop();
        v2.start();
        v2.stop();
        v3.start();
        v3.stop();
    }
}
