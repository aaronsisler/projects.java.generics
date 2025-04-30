package com.ebsolutions.projects.java.generics;

import com.ebsolutions.projects.java.generics.interfaces.Animal;
import com.ebsolutions.projects.java.generics.interfaces.Bird;
import com.ebsolutions.projects.java.generics.interfaces.FlightEnabled;
import com.ebsolutions.projects.java.generics.interfaces.Jet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
//  public static void main(String[] args) {
//    SpringApplication.run(Application.class, args);
//  }

  public static void main(String[] args) {
    Bird bird = new Bird();
    Animal animal = bird;
    FlightEnabled flier = bird;

    List<FlightEnabled> flightEnableds = new ArrayList<>();
    flightEnableds.add(bird);
    flightEnableds.add(new Jet());

    for (FlightEnabled flightEnabled : flightEnableds) {
      flightEnabled.takeOff();
      flightEnabled.fly();
      flightEnabled.land();

    }
  }

//    public static void main(String[] args) {
//    List<Animal> animals = new ArrayList<>();
//    Animal wolf = new Dog("Wolf", "large", 50);
//    Animal horse = new Horse("Mustang", "extra large", 930);
//    animals.add(wolf);
//    animals.add(horse);
//
//    for (Animal animal : animals) {
//      doAnimalStuff(animal);
//      if (animal instanceof Mammal currentMammal) {
//        currentMammal.shedHair();
//      }
//    }
//  }

//  private static void doAnimalStuff(Animal animal) {
//    animal.move("slow");
//    animal.makeNoise();
//  }
}
