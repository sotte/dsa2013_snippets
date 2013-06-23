package de.unistuttgart.astar;

import java.util.ArrayList;
import java.util.List;

/**
 * A naïve implementation of the {@link ImmutableGraphNode<E>} interface.
 * 
 * @param <E> The data type stored in the graph.
 */
public class SimpleGraphNode<E> implements ImmutableGraphNode<E> {
	
	/**
	 * Represents an edge that works with {@link SimpleGraphNode<E>} instances.
	 */
	private class Edge implements ImmutableGraphEdge<E> {
		
		/**
		 * Initializes a new instance.
		 * 
		 * @param target The destination node of the edge.
		 * @param weight The weight of the edge.
		 * @throws IllegalArgumentException if target is null.
		 */
		public Edge(ImmutableGraphNode<E> target, double weight) {
			if (target == null) {
				throw new IllegalArgumentException("target must not be null.");
			}
			
			this.target = target;
			this.weight = weight;
		}
		
		/**
		 * The destination node of the edge.
		 */
		private final ImmutableGraphNode<E> target;
		
		/**
		 * Gets the destination node of the edge.
		 */
		public ImmutableGraphNode<E> getTarget() {
			return target;
		}
		
		/**
		 * The weight of the edge.
		 */
		private final double weight;
		
		/**
		 * Gets the weight of the edge.
		 */
		public double getWeight() {
			return weight;
		}
	}
	
	/**
	 * Initializes a new instance.
	 * 
	 * @param x The X coordinate of the node.
	 * @param y The Y coordinate of the node.
	 * @param value The value stored in the node.
	 */
	public SimpleGraphNode(double x, double y, E value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
	/**
	 * The value stored in the node.
	 */
	private final E value;
	
	/**
	 * Returns the value stored in the node.
	 */
	@Override
	public E getValue() {
		return value;
	}
	
	/**
	 * The edges leading from this node to other nodes.
	 */
	private final List<ImmutableGraphEdge<E>> outboundEdges = new ArrayList<ImmutableGraphEdge<E>>();
	
	/**
	 * Returns a list of edges that lead from this node to other nodes.
	 */
	@Override
	public Iterable<ImmutableGraphEdge<E>> getOutboundEdges() {
		return outboundEdges;
	}
	
	/**
	 * Adds an edge that leads from this node to another node.
	 * 
	 * @param node The target node of the edge.
	 * @param weight The weight of the edge.
	 * @throws IllegalArgumentException if node is null.
	 */
	public void addEdge(ImmutableGraphNode<E> node, double weight) {
		outboundEdges.add(new Edge(node, weight));
	}
	
	/**
	 * The next ID to assign to a node of this class.
	 */
	private static int nextId = 0;
	
	/**
	 * The ID of the current node.
	 */
	private final int id = nextId++;
	
	/**
	 * Gets the ID of the current node.
	 */
	@Override
	public Integer getId() {
		return id;
	}
	
	/**
	 * The X coordinate of the node.
	 */
	private final double x;
	
	/**
	 * Gets the X coordinate of the node.
	 */
	@Override
	public double getX() {
		return x;
	}
	
	/**
	 * The Y coordinate of the node.
	 */
	private final double y;
	
	/**
	 * Gets the Y coordinate of the node.
	 */
	@Override
	public double getY() {
		return y;
	}

}
