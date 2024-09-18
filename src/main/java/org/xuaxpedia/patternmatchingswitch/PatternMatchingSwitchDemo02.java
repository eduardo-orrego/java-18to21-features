package org.xuaxpedia.patternmatchingswitch;

// Java 21 enhances pattern matching in switch, allowing the object type
// to be inferred and its data to be extracted directly in the expression.
// This simplifies the writing of complex cases with more expressive patterns,
// improving code readability and maintainability.

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

