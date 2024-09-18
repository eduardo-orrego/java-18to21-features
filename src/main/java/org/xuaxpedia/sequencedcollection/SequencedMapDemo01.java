package org.xuaxpedia.sequencedcollection;

import java.util.LinkedHashMap;
import java.util.SequencedMap;

// Java 21 introduces the interfaces SequencedCollection, SequencedMap,
// and SequencedSet to improve the handling of ordered data, with methods
// like first(), last(), and subList() for collections, and firstEntry(),
// lastEntry(), and descendingMap() for maps. Classes like ArrayList, LinkedList,
// TreeMap, TreeSet, and ArrayDeque implement these interfaces, optimizing
// efficiency in managing sequential elements.

public class SequencedMapDemo01 {

    public static void main(String[] args) {

        SequencedMap<Integer, String> sequenceMapNames = new LinkedHashMap<>();
        sequenceMapNames.put(2, "Eduardo");
        sequenceMapNames.put(3, "Luis");
        sequenceMapNames.put(4, "Patricia");
        sequenceMapNames.put(5, "Irene");
        sequenceMapNames.put(6, "Ulises");
        System.out.println("Sequenced Map:");
        System.out.println(sequenceMapNames);

        System.out.println("Get the first and last item:");
        System.out.println(sequenceMapNames.firstEntry());
        System.out.println(sequenceMapNames.lastEntry());

        sequenceMapNames.putFirst(7, "Doroteo");
        sequenceMapNames.putLast(1, "Simona");
        System.out.println("Add items to the beginning and end:");
        System.out.println(sequenceMapNames);

        SequencedMap<Integer, String> reversedSequenceMap = sequenceMapNames.reversed();
        System.out.println("Reverse order:");
        System.out.println(reversedSequenceMap);

        sequenceMapNames.pollFirstEntry();
        sequenceMapNames.pollLastEntry();
        System.out.println("Remove the first and last item:");
        System.out.println(sequenceMapNames);

        System.out.println("ConcurrentModificationException: ");
        for (String nome : sequenceMapNames.values()) {
            if (nome.contains("Luis")) {
                sequenceMapNames.pollFirstEntry();
            }
        }

    }

}