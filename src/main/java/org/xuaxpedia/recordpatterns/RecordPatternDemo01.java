package org.xuaxpedia.recordpatterns;

// Java 21 enhances records with advanced pattern matching,
// now usable in switch, instanceof, and assignments.
// This simplifies unpacking and extracting values from
// records, making data handling clearer and more concise.

public class RecordPatternDemo01 {

    record Point(int x, int y) {
    }

    public static void main(String[] args) {

        Point point = new Point(1, 2);
        printSum(point);

    }

    public static void printSum(Object o) {
        if (o instanceof Point(int x, int y)) {
            System.out.println(x + y);
        }
    }

}
