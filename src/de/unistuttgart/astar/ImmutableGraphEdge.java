package de.unistuttgart.astar;

/**
 * An interface that provides read-only access to a weighted graph edge.
 * 
 * @param <E> The value type stored in the graph.
 */
public interface ImmutableGraphEdge<E> {
	
	/**
	 * Gets the target node of the edge.
	 * 
	 * @return the destination of the edge.
	 */
	ImmutableGraphNode<E> getTarget();
	
	/**
	 * Gets the weight of the edge.
	 * 
	 * @return the weight.
	 */
	double getWeight();
}
