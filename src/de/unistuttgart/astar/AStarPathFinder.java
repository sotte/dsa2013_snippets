package de.unistuttgart.astar;

import java.util.Set;
import java.util.TreeSet;

/**
 * A class that can execute the A* path finding algorithm.
 */
public final class AStarPathFinder {
	
	/**
	 * Hidden constructor.
	 */
	private AStarPathFinder() {
	}
	
	/**
	 * Finds the shortest path between two nodes in a graph, if they are connected.
	 * 
	 * @param origin The node to start from.
	 * @param destination The destination node.
	 * @param expander An object that executes the expand routine of the A* algorithm.
	 * @return A path from origin to destination in the form of an array of traversed graph nodes, or null if no path could be found.
	 * @throws IllegalArgumentException if any of the arguments is null.
	 */
	public static <E> ImmutableGraphNode<E>[] findPath(ImmutableGraphNode<E> origin, ImmutableGraphNode<E> destination, NodeExpander<E> expander) {
		if (origin == null) {
			throw new IllegalArgumentException("origin must not be null.");
		}
		if (destination == null) {
			throw new IllegalArgumentException("destination must not be null.");
		}
		if (expander == null) {
			throw new IllegalArgumentException("expander must not be null.");
		}
		
		NodeFunctions<E> nodeFunctions = new NodeFunctions<E>(new DistanceHProvider<E>(destination));
		OpenSet<E> open = new OpenSet<E>(nodeFunctions);
		Set<Integer> closed = new TreeSet<Integer>();
		
		open.enqueue(origin);
		while (!open.isEmpty()) {
			ImmutableGraphNode<E> n = open.extractMinimal();
			if (n == destination) {
				return nodeFunctions.getPath(destination);
			}
			expander.expand(n, nodeFunctions, open, closed);
			closed.add(n.getId());
		}
		return null;
	}
}
