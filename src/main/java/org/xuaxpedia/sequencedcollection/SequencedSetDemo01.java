package org.xuaxpedia.sequencedcollection;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedSet;

// Java 21 introduces the interfaces SequencedCollection, SequencedMap,
// and SequencedSet to improve the handling of ordered data, with methods
// like first(), last(), and subList() for collections, and firstEntry(),
// lastEntry(), and descendingMap() for maps. Classes like ArrayList, LinkedList,
// TreeMap, TreeSet, and ArrayDeque implement these interfaces, optimizing
// efficiency in managing sequential elements.

public class SequencedSetDemo01 {

    public static void main(String[] args) {

        SequencedSet<Integer> sequencedSetNumbers = new LinkedHashSet<>(List.of(2, 3, 4));
        System.out.println("Sequenced set:");
        System.out.println(sequencedSetNumbers);

        System.out.println("Get the first and last item:");
        System.out.println(sequencedSetNumbers.getFirst());
        System.out.println(sequencedSetNumbers.getLast());

        sequencedSetNumbers.addFirst(5);
        sequencedSetNumbers.addLast(1);
        System.out.println("Add items to the beginning and end:");
        System.out.println(sequencedSetNumbers);

        SequencedSet<Integer> reversedSequence = sequencedSetNumbers.reversed();
        System.out.println("Reverse order:");
        System.out.println(reversedSequence);

        sequencedSetNumbers.removeFirst();
        sequencedSetNumbers.removeLast();
        System.out.println("Remove the first and last item:");
        System.out.println(sequencedSetNumbers);

        System.out.println("ConcurrentModificationException: ");
        for (Integer number : sequencedSetNumbers) {
            if (number.equals(2)) {
                sequencedSetNumbers.removeFirst();
            }
        }

    }

}