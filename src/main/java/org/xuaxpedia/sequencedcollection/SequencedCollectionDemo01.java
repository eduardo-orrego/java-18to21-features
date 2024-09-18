package org.xuaxpedia.sequencedcollection;

import java.util.ArrayList;
import java.util.SequencedCollection;

// Java 21 introduces the interfaces SequencedCollection, SequencedMap,
// and SequencedSet to improve the handling of ordered data, with methods
// like first(), last(), and subList() for collections, and firstEntry(),
// lastEntry(), and descendingMap() for maps. Classes like ArrayList, LinkedList,
// TreeMap, TreeSet, and ArrayDeque implement these interfaces, optimizing
// efficiency in managing sequential elements.

public class SequencedCollectionDemo01 {

    public static void main(String[] args) {

        SequencedCollection<String> sequenceCollectionNames = new ArrayList<>();
        sequenceCollectionNames.add("Eduardo");
        sequenceCollectionNames.add("Luis");
        sequenceCollectionNames.add("Patricia");
        sequenceCollectionNames.add("Irene");
        sequenceCollectionNames.add("Ulises");
        System.out.println("Sequenced collection:");
        System.out.println(sequenceCollectionNames);

        System.out.println("Get the first and last item:");
        System.out.println(sequenceCollectionNames.getFirst());
        System.out.println(sequenceCollectionNames.getLast());

        sequenceCollectionNames.addFirst("Doroteo");
        sequenceCollectionNames.addLast("Simona");
        System.out.println("Add items to the beginning and end:");
        System.out.println(sequenceCollectionNames);

        SequencedCollection<String> reversedSequenceCollection = sequenceCollectionNames.reversed();
        System.out.println("Reverse order:");
        System.out.println(reversedSequenceCollection);

        sequenceCollectionNames.removeFirst();
        sequenceCollectionNames.removeLast();
        System.out.println("Remove the first and last item:");
        System.out.println(sequenceCollectionNames);

        System.out.println("ConcurrentModificationException: ");
        for (String nome : sequenceCollectionNames) {
            if (nome.contains("Luis")) {
                sequenceCollectionNames.removeFirst();
            }
        }

    }

}