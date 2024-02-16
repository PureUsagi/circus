package circus;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Parrot;
import circus.animal.Tiger;
import circus.animal.Elephant;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.Arrays;
import java.util.ArrayList;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        printCircusSize();
        //animals[3] = new Duck("Louie");
        //System.out.println("Number of animals in Circus: " + animals.length);
        //makeAnimalsTalk();
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));

        printAllAnimals(animalArrayList);
        printCircusSize();

        animalArrayList.add(new Duck("Louie"));

        Elephant strongOne = new Elephant("StrongOne");
        Parrot andy = new Parrot("Andy");

        animalArrayList.add(strongOne);
        animalArrayList.add(andy);

        System.out.println("Before sorting...");
        printAllAnimals(animalArrayList);
        printCircusSize();

        System.out.println("After sorting...");
        animalArrayList.sort(Animal.AninalNameComparator);
        printAllAnimals(animalArrayList);

        System.out.println("Strong One is at position: " + animalArrayList.indexOf(strongOne));

        //System.out.println("Total value of animals " + calculateAssetValue(animals));
        //System.out.println("Total value of equipments " + calculateAssetValue(equipments));
    }

    private static void printCircusSize() {
        System.out.println("Number of animals in Circus: " + animals.length);
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a: animalArrayList) {
            System.out.println(a);
        }
    }
}
