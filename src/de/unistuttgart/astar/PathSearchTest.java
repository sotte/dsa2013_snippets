package de.unistuttgart.astar;

import java.util.Map;

public class PathSearchTest {

	public static void main(String[] args) {
		Map<Character, ImmutableGraphNode<Character>> graph = GraphFactory.createSimpleGraph();
		printPath(AStarPathFinder.findPath(graph.get('A'), graph.get('D'), new MyNodeExpander<Character>()));
	}
	
	private static <E> void printPath(ImmutableGraphNode<E>[] path) {
		if (path == null) {
			System.out.println("[no path]");
			return;
		}
		
		for (int i = 0; i < path.length; i++) {
			if (i > 0) {
				System.out.print(" -> ");
			}
			System.out.print(path[i].getValue().toString());
		}
		System.out.println();
	}
}
