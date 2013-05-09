package de.unistuttgart.iteratoren;

import java.util.Iterator;

public class SimpleIterator<T> implements Iterator<T> {
	private SimpleNode<T> next;

	public SimpleIterator(SimpleNode<T> node) {
		next = node;
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public T next() {
		T value = next.value;
		next = next.next;
		return value;
	}

	@Override
	public void remove() {
		throw new IllegalArgumentException();
	}
}
