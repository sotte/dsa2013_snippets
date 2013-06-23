package de.unistuttgart.astar;

import java.util.Set;

public class MyNodeExpander<E> implements NodeExpander<E> {

	/**
	 * A* vs Dijkstra
	 * 
	 * A* is like Dijkstra but is uses a heuristic to estimate the future way.
	 * 
	 * The "expand" step of A* is pretty much the same as the update of the
	 * priority queue Q in the Dijkstra algorithm. Here we don't simply update
	 * the distance according the next best node, but also use a heuristic to
	 * estimate the future way. Because we do so, we have to update these
	 * estimates, which makes a A* a bit more complicated than Dijkstra.
	 * 
	 * 
	 * Important Functions:
	 * 
	 * g(u) - costs from start to u: nodeFunctions.getG(u);
	 * 
	 * h(u) - heuristic for the costs from u to the goal: nodeFunctions.getH(u);
	 * 
	 * f(u) - costs from start to goal over u: g(u) + h(u):
	 * nodeFunctions.getF(u);
	 * 
	 * 
	 * Important data structures:
	 * 
	 * - open - list of nodes for which a (not necessary optimal) way exists.
	 * the node with the smallest f value is the potential best node.
	 * 
	 * - closed - nodes with known shortest way
	 * 
	 * 
	 * The implementation here follows the pseudo code in the script really
	 * closely.
	 */
	@Override
	public void expand(ImmutableGraphNode<E> u, NodeFunctions<E> nodeFunctions,
			OpenSet<E> open, Set<Integer> closed) {

		// we iterate over all succesors of u
		// for each {v | v \in Succesor(u) and v \notin closed}
		for (ImmutableGraphEdge<E> edge : u.getOutboundEdges()) {
			ImmutableGraphNode<E> v = edge.getTarget();
			// but we're only interested in the nodes which are not closed yet
			// i.e. only nodes which don't have a shortest path yet.
			if (closed.contains(v.getId())) {
				continue;
			}

			// we need an estimate for the length of the way, i.e. the
			// length to u + the length from u to v + the heuristic from v
			// to the goal
			// tf := g(u) + γ(u,v) + h(v);
			double tf = nodeFunctions.getG(u) + edge.getWeight()
					+ nodeFunctions.getH(v);

			// when the estimate tf is worth than the current F value for v
			// and v is in the set of the open edges
			// we skip the node v
			// if v \in OPEN and tf >= f(v) then continue; fi;
			if (tf >= nodeFunctions.getF(v) && open.contains(v)) {
				continue;
			}

			// because our estimate tells us that node v is a good one we
			// set u as the predecessor of v, meaning: currentBestWay -> u
			// -> v -> ?
			// v.pred = u
			nodeFunctions.setPredecessor(v, u);

			// updath f- und g-value of v
			// g is automatically updated during setPredecessor(v, u)
			double f = nodeFunctions.getG(v) + nodeFunctions.getH(v);
			nodeFunctions.setF(v, f);

			// if we haven't visited v yet, add it to the list of open nodes
			if (!open.contains(v)) {
				open.enqueue(v);
			} else {
				open.updateNodeF(v);
			}
		}
	}
}
