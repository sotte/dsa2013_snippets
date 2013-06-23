package de.unistuttgart.astar;

import java.util.Set;

/**
 * An interface for classes that provide an expand routine for the A* algorithm.
 *
 * @param <E> The data type stored in the graph.
 */
public interface NodeExpander<E> {
	
	/**
	 * Executes the expand operation of the A* algorithm.
	 * 
	 * @param u The graph node to expand.
	 * @param nodeFunctions The stored function values used by the A* algorithm.
	 * @param open The OPEN set, which contains all nodes to which a path has already been determined.
	 * @param closed The CLOSED set, which contains the IDs of all nodes to which the shortest possible path is known.
	 * @throws IllegalArgumentException if any of the arguments is null.
	 */
	void expand(ImmutableGraphNode<E> u, NodeFunctions<E> nodeFunctions, OpenSet<E> open, Set<Integer> closed);
}
