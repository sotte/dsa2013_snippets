package de.unistuttgart.astar;

/**
 * An interface that provides read-only access to a graph node with a position.
 * 
 * @param <E> The value type stored in the graph.
 */
public interface ImmutableGraphNode<E> {
	
	/**
	 * Returns the value of the node.
	 * 
	 * @return the value.
	 */
	E getValue();
	
	/**
	 * Returns an enumeration of all outbound edges starting at this node.
	 * 
	 * @return the outbound edges.
	 */
	Iterable<ImmutableGraphEdge<E>> getOutboundEdges();
	
	/**
	 * Returns a unique identifier of the node.
	 * 
	 * @return the identifier.
	 */
	Integer getId();
	
	/**
	 * Gets the X coordinate of the node.
	 * 
	 * @return the X coordinate.
	 */
	double getX();
	
	/**
	 * Gets the Y coordinate of the node.
	 * 
	 * @return the Y coordinate.
	 */
	double getY();
}
