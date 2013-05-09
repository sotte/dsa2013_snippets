package de.unistuttgart.iteratoren;

public class Main {
	public static void main(String[] args) {
		// add 5 elements and print them
		SimpleList<Integer> l = new SimpleList<Integer>();
		l.prepend(5);
		l.prepend(4);
		l.prepend(3);
		l.prepend(2);
		l.prepend(1);

		// this does not use any iterators yet and is really annoying
		System.out.println("=================");
		System.out.println(
					"NO iterator: print the list directly accessing the node class (this is bad):");
		System.out.println(l.head.value);
		System.out.println(l.head.next.value);
		System.out.println(l.head.next.next.value);
		System.out.println(l.head.next.next.next.value);
		System.out.println(l.head.next.next.next.next.value);

		System.out.println("NO iterator: print the list (alternative way):");
		for (int i = 0; i < 5; i++) {
			System.out.println(l.at(i));
		}

		// let's use the iterator instead
		System.out.println("=================");
		System.out.println("Print the list WITH the ITERATOR");
		for (Integer i : l) {
			System.out.println(i);
		}

		// and now the reverse iterator
		System.out.println("=================");
		System.out.println("Print the list WITH the REVERSE ITERATOR");
		for (Integer i : l.reverseIterator()) {
			System.out.println(i);
		}
	}
}
