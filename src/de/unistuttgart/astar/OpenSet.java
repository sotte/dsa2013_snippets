package de.unistuttgart.astar;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Stores the set of nodes to which a path has already been determined by the A* algorithm.
 *
 * @param <E> The data type stored in the graph.
 */
public class OpenSet<E> {
	
	/**
	 * Initializes a new instance.
	 * 
	 * @param nodeFunctions An object that stores the values of the node functions used by the A* algorithm.
	 * @throws IllegalArgumentException if nodeFunctions is null. 
	 */
	public OpenSet(NodeFunctions<E> nodeFunctions) {
		if (nodeFunctions == null) {
			throw new IllegalArgumentException("nodeFunctions must not be null.");
		}
		
		this.nodeFunctions = nodeFunctions;
	}
	
	/**
	 * An object that stores the values of the node functions used by the A* algorithm.
	 */
	private final NodeFunctions<E> nodeFunctions;
	
	/**
	 * A class that compares two graph nodes based on their F values.
	 */
	private class NodeComparer implements Comparator<ImmutableGraphNode<E>> {
		
		/**
		 * Compares two graph nodes based on their F values.
		 */
		@Override
		public int compare(ImmutableGraphNode<E> o1, ImmutableGraphNode<E> o2) {
			double f1 = nodeFunctions.getF(o1);
			double f2 = nodeFunctions.getF(o2);
			return Double.compare(f1, f2);
		}
	}
	
	/**
	 * The priority queue that stores nodes based on their F value.
	 */
	private final PriorityQueue<ImmutableGraphNode<E>> items = new PriorityQueue<ImmutableGraphNode<E>>(2, new NodeComparer());
	
	/**
	 * A set that allows quick checking of whether a given node ID is contained in the OPEN set.
	 */
	private final Set<Integer> containedIds = new TreeSet<Integer>();
	
	/**
	 * Removes and returns the node with the smallest F value stored in the OPEN set.
	 * 
	 * @return The node with the smallest F value.
	 * @throws IllegalStateException if the OPEN set is empty.
	 */
	public ImmutableGraphNode<E> extractMinimal() {
		if (items.isEmpty()) {
			throw new IllegalStateException("The OPEN set is empty.");
		}
		
		ImmutableGraphNode<E> result = items.poll();
		containedIds.remove(result.getId());
		return result;
	}
	
	/**
	 * Adds a node to the OPEN set.
	 * 
	 * @param node The node to add.
	 * @throws IllegalArgumentException if node is null.
	 */
	public void enqueue(ImmutableGraphNode<E> node) {
		if (node == null) {
			throw new IllegalArgumentException("node must not be null.");
		}
		
		if (!containedIds.contains(node.getId())) {
			items.add(node);
			containedIds.add(node.getId());
		}
	}
	
	/**
	 * Updates the F value of a node.
	 * This is required when the F value has changed to correctly determine the minimum F value in {@link #extractMinimal()}.
	 * 
	 * @param node The node whose F value has changed.
	 * @throws IllegalArgumentException if node is null.
	 */
	public void updateNodeF(ImmutableGraphNode<E> node) {
		if (node == null) {
			throw new IllegalArgumentException("node must not be null.");
		}
		
		if (containedIds.contains(node.getId())) {
			items.remove(node);
			items.add(node);
		}
	}
	
	/**
	 * Checks whether the OPEN set is empty.
	 * 
	 * @return A value that indicates whether the set is empty.
	 */
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	/**
	 * Checks whether the OPEN set contains a given node.
	 * 
	 * @param node The node to check for.
	 * @return A value that indicates whether the node is contained in the set.
	 * @throws IllegalArgumentException if node is null.
	 */
	public boolean contains(ImmutableGraphNode<E> node) {
		if (node == null) {
			throw new IllegalArgumentException("node must not be null.");
		}
		
		return containedIds.contains(node.getId());
	}
}
