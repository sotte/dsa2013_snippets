package de.unistuttgart.astar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Stores the values of node functions used by the A* algorithm.
 *
 * @param <E> The data type stored in the graph.
 */
public class NodeFunctions<E> {
	
	/**
	 * Initializes a new instance.
	 * 
	 * @param hProvider An object that can compute the H value for a node.
	 * @throws IllegalArgumentException if hProvider is null.
	 */
	public NodeFunctions(AStarHeuristicProvider<E> hProvider) {
		if (hProvider == null) {
			throw new IllegalArgumentException("hProvider must not be null.");
		}
		
		this.hProvider = hProvider;
	}
	
	/**
	 * An object that can compute the H value for a node.
	 */
	private final AStarHeuristicProvider<E> hProvider;
	
	/**
	 * Stores all the data available for a given node.
	 */
	private class NodeInfo {
		
		/**
		 * Initializes a new instance.
		 * 
		 * @param node The node this instance refers to.
		 * @throws IllegalArgumentException if node is null.
		 */
		public NodeInfo(ImmutableGraphNode<E> node) {
			if (node == null) {
				throw new IllegalArgumentException("node must not be null.");
			}
			
			this.node = node;
			this.h = hProvider.computeH(node);
		}
		
		/**
		 * The node this instance refers to.
		 */
		private final ImmutableGraphNode<E> node;
		
		/**
		 * Returns the node this instance refers to.
		 * @return
		 */
		public ImmutableGraphNode<E> getNode() {
			return node;
		}
		
		/**
		 * The F value of the node.
		 */
		private double f;
		
		/**
		 * Gets the F value of the node.
		 * 
		 * @return the F value of the node.
		 */
		public double getF() {
			return f;
		}
		
		/**
		 * Sets the F value of the node.
		 * 
		 * @param f The new F value of the node.
		 */
		public void setF(double f) {
			this.f = f;
		}
		
		/**
		 * The G value of the node.
		 */
		private double g;
		
		/**
		 * Gets the G value of the node.
		 * 
		 * @return the G value of the node.
		 */
		public double getG() {
			return g;
		}
		
		/**
		 * The H value of the node.
		 */
		private final double h;
		
		/**
		 * Gets the H value of the node.
		 * 
		 * @return the H value of the node.
		 */
		public double getH() {
			return h;
		}
		
		/**
		 * The predecessor of the node in the path to the node.
		 */
		private NodeInfo predecessor;
		
		/**
		 * Gets the predecessor of the node in the path to the node.
		 * 
		 * @return the predecessor node.
		 */
		public NodeInfo getPredecessor() {
			return predecessor;
		}
		
		/**
		 * Sets the predecessor of the node in the path to the node.
		 * The new predecessor can be either a node(-info object), or null.
		 * The G value is automatically updated based on the new path to the node.
		 * 
		 * @param predecessor The new predecessor of the node in the path to the node.
		 */
		public void setPredecessor(NodeInfo predecessor) {
			this.predecessor = predecessor;
			
			if (predecessor == null) {
				g = 0;
			} else {
				for (ImmutableGraphEdge<E> edge : predecessor.getNode().getOutboundEdges()) {
					if (edge.getTarget() == node) {
						g = predecessor.getG() + edge.getWeight();
						break;
					}
				}
			}
		}
	}
	
	/**
	 * The complete list of node info objects, accessible by the node IDs.
	 */
	private final Map<Integer, NodeInfo> itemsById = new TreeMap<Integer, NodeInfo>();
	
	/**
	 * Gets the F value of a given node.
	 * 
	 * @param node The node.
	 * @return the F value.
	 * @throws IllegalArgumentException if node is null.
	 */
	public double getF(ImmutableGraphNode<E> node) {
		if (node == null) {
			throw new IllegalArgumentException("node must not be null.");
		}
		
		NodeInfo item = itemsById.get(node.getId());
		if (item == null) {
			return 0;
		} else {
			return item.getF();
		}
	}
	
	/**
	 * Sets the F value of a given node.
	 * 
	 * @param node The node.
	 * @param f The new F value.
	 * @throws IllegalArgumentException if node is null.
	 */
	public void setF(ImmutableGraphNode<E> node, double f) {
		if (node == null) {
			throw new IllegalArgumentException("node must not be null.");
		}
		
		retrieveItem(node).setF(f);
	}
	
	/**
	 * Gets the G value of a given node.
	 * 
	 * @param node The node.
	 * @return the G value.
	 * @throws IllegalArgumentException if node is null.
	 */
	public double getG(ImmutableGraphNode<E> node) {
		if (node == null) {
			throw new IllegalArgumentException("node must not be null.");
		}
		
		NodeInfo item = itemsById.get(node.getId());
		if (item == null) {
			return 0;
		} else {
			return item.getG();
		}
	}
	
	/**
	 * Gets the H value of a given node.
	 * 
	 * @param node The node.
	 * @return the H value.
	 * @throws IllegalArgumentException if node is null.
	 */
	public double getH(ImmutableGraphNode<E> node) {
		if (node == null) {
			throw new IllegalArgumentException("node must not be null.");
		}
		
		return retrieveItem(node).getH();
	}
	
	/**
	 * Gets the predecessor of a given node in the path to that node.
	 * 
	 * @param node The node.
	 * @return the predecessor node.
	 * @throws IllegalArgumentException if node is null.
	 */
	public ImmutableGraphNode<E> getPredecessor(ImmutableGraphNode<E> node) {
		if (node == null) {
			throw new IllegalArgumentException("node must not be null.");
		}
		
		NodeInfo item = itemsById.get(node.getId());
		if (item == null) {
			return null;
		} else {
			NodeInfo predItem = item.getPredecessor();
			if (predItem == null) {
				return null;
			} else {
				return predItem.getNode();
			}
		}
	}
	
	/**
	 * Sets the predecessor of a given node in a path to that node.
	 * 
	 * @param node The node.
	 * @param predecessor The predecessor of the node, or null if there is no predecessor.
	 * @throws IllegalArgumentException if node is null.
	 */
	public void setPredecessor(ImmutableGraphNode<E> node, ImmutableGraphNode<E> predecessor) {
		if (node == null) {
			throw new IllegalArgumentException("node must not be null.");
		}
		
		NodeInfo item = itemsById.get(node.getId());
		if (item == null) {
			item = new NodeInfo(node);
			itemsById.put(node.getId(), item);
		}
		if (predecessor == null) {
			item.setPredecessor(null);
		} else {
			item.setPredecessor(retrieveItem(predecessor));
		}
	}
	
	/**
	 * Gets the complete path to a node, expressed as an array of traversed nodes.
	 * 
	 * @param destination The last node in the path.
	 * @return The path to the destination node.
	 * @throws IllegalArgumentException if destination is null.
	 */
	@SuppressWarnings("unchecked")
	public ImmutableGraphNode<E>[] getPath(ImmutableGraphNode<E> destination) {
		if (destination == null) {
			throw new IllegalArgumentException("destination must not be null.");
		}
		
		List<ImmutableGraphNode<E>> result = new ArrayList<ImmutableGraphNode<E>>();
		
		for (ImmutableGraphNode<E> current = destination; current != null; current = getPredecessor(current)) {
			result.add(0, current);
		}
		
		return result.toArray((ImmutableGraphNode<E>[])Array.newInstance(ImmutableGraphNode.class, result.size()));
	}
	
	/**
	 * Retrieves a node info object for a given node and forces its creation if it does not exist yet.
	 * 
	 * @param node The graph node.
	 * @return the node info object.
	 * @throws IllegalArgumentException if node is null.
	 */
	private NodeInfo retrieveItem(ImmutableGraphNode<E> node) {
		if (node == null) {
			throw new IllegalArgumentException("node must not be null.");
		}
		
		NodeInfo result = itemsById.get(node.getId());
		if (result == null) {
			result = new NodeInfo(node);
			itemsById.put(node.getId(), result);
		}
		return result;
	}
}
