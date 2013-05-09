package de.unistuttgart.iteratoren;

import java.util.Iterator;

/**
 * The reverse iterator is a bit tricky, because the SimpleNodes only know their
 * next element, not the previous one. But we simply use the SimpleList directly
 * to implement our ReverseIterator. Therefore ReverseIterator must be Iterable
 * like the SimpleList.
 */
public class ReverseIterator<T> implements Iterator<T>, Iterable<T> {
	SimpleList<T> list;
	int currentPos;

	public ReverseIterator(SimpleList<T> list) {
		this.list = list;
		currentPos = list.size - 1;
	}

	@Override
	public boolean hasNext() {
		return currentPos > 0;
	}

	@Override
	public T next() {
		T value = list.at(currentPos);
		currentPos--;
		return value;
	}

	@Override
	public void remove() {
	}

	@Override
	public Iterator<T> iterator() {
		return this;
	}

}
