package de.unistuttgart.iteratoren;

import java.util.Iterator;

/**
 * Minimal implementation of a linked list.
 */
public class SimpleList<T> implements Iterable<T> {
	SimpleNode<T> head;
	int size;

	void prepend(T value) {
		size++;
		SimpleNode<T> newNode = new SimpleNode<T>(value);
		if (head == null) {
			head = newNode;
		} else {
			// the old head is the next element of the new head
			newNode.next = head;
			head = newNode;
		}
	}

	T at(int pos) {
		if (pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		SimpleNode<T> current = head;
		for (int i = 0; i < pos; i++) {
			current = current.next;
		}
		return current.value;
	}

	@Override
	public Iterator<T> iterator() {
		return new SimpleIterator<T>(head);
	}

	public Iterable<T> reverseIterator() {
		return (Iterable<T>) new ReverseIterator<T>(this);
	}
}