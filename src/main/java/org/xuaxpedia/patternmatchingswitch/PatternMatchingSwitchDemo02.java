package org.xuaxpedia.patternmatchingswitch;

/*
* Example demonstrating pattern matching in switch statements with enums.
*/

public class PatternMatchingSwitchDemo02 {

    enum Vehicule {
        CAR,
        PLANE,
        TRAIN
    }

    public static void main(String[] args) {

        Vehicule vehicule = Vehicule.CAR;

        switch (vehicule) {
            case CAR -> System.out.println("Car");
            case PLANE -> System.out.println("Plane");
            case TRAIN -> System.out.println("Train");
            default -> System.out.println("Not Found");
        }

    }

}

