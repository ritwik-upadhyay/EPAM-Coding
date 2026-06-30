import java.util.*;

abstract class Animal {
    public abstract void makeSound();
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}
class Cow extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Mooooooooooooooooooooooooooooooooooo!");
    }
}

public class AnimalSoundSimulator {
    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(
            new Dog(),
            new Cat(),
            new Cow()
        );
        for(Animal a : animals) {
            a.makeSound();
        }
    }
}
