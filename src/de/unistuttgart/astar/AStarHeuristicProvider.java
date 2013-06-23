package de.unistuttgart.astar;

/**
 * An interface for objects that compute the H value of nodes.
 *
 * @param <E> The data type stored in the graph.
 */
public interface AStarHeuristicProvider<E> {
	
	/**
	 * Computes the H value for a given node.
	 * 
	 * @param node the node.
	 * @return the H value.
	 * @throws IllegalArgumentException if node is null.
	 */
	double computeH(ImmutableGraphNode<E> node);
}
