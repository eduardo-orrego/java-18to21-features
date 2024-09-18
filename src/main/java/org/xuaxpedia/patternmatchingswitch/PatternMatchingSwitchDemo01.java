package org.xuaxpedia.patternmatchingswitch;

// Java 21 enhances pattern matching in switch, allowing the object type
// to be inferred and its data to be extracted directly in the expression.
// This simplifies the writing of complex cases with more expressive patterns,
// improving code readability and maintainability.

public class PatternMatchingSwitchDemo01 {

    record Person(String name, int age) {
    }

    public static void main(String[] args) {

        String result1 = checkObject(new Person("Edward", 38));
        System.out.println(result1);
        String result2 = checkObject(new Figure("Circle", 100.00));
        System.out.println(result2);

    }

    public static String checkObject(Object obj) {

        return switch (obj) {
            case Person person -> "Name: %s, age: %s".formatted(person.name(), person.age());
            case Figure figure -> "Name: %s, perimeter: %s".formatted(figure.name, figure.perimeter);
            case null -> "It is null";
            default -> "It is an object";
        };

    }

}

class Figure {

    String name;
    double perimeter;

    Figure(String name, double perimeter) {
        this.name = name;
        this.perimeter = perimeter;
    }

}