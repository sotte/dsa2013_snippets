package de.unistuttgart.iteratoren;

public class SimpleNode<T> {
	SimpleNode<T> next;
	T value;

	SimpleNode(T val) {
		this.value = val;
	}
}
