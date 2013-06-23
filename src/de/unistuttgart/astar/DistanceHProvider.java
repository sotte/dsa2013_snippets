package de.unistuttgart.astar;

/**
 * An implementation of the {@link AStarHeuristicProvider} interface that uses the straight line distance to a destination.
 *
 * @param <E> The data type stored in the graph.
 */
public class DistanceHProvider<E> implements AStarHeuristicProvider<E> {
	
	/**
	 * Initializes a new instance.
	 * 
	 * @param destination the destination of the path search.
	 * @throws IllegalArgumentException if destination is null.
	 */
	public DistanceHProvider(ImmutableGraphNode<E> destination) {
		if (destination == null) {
			throw new IllegalArgumentException("destination must not be null.");
		}
		
		this.destination = destination;
	}
	
	/**
	 * The destination of the path search.
	 */
	private final ImmutableGraphNode<E> destination;
	
	/**
	 * Computes the H value for a given node.
	 * 
	 * @param node the node.
	 * @return the H value.
	 * @throws IllegalArgumentException if node is null.
	 */
	@Override
	public double computeH(ImmutableGraphNode<E> node) {
		if (node == null) {
			throw new IllegalArgumentException("node must not be null.");
		}
		
		return Math.sqrt(Math.pow(destination.getX() - node.getX(), 2) + Math.pow(destination.getY() - node.getY(), 2));
	}
}
