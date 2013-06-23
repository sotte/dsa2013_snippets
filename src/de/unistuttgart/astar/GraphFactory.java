package de.unistuttgart.astar;

import java.util.Map;
import java.util.TreeMap;

/**
 * Provides example graph data.
 */
public final class GraphFactory {
	
	/**
	 * Hidden constructor.
	 */
	private GraphFactory() {
	}
	
	/**
	 * Creates a simple graph consisting of about 15 nodes.
	 * 
	 * @return A map that contains all nodes of the graph, which can be retrieved via their (unique) names (letters).
	 */
	public static Map<Character, ImmutableGraphNode<Character>> createSimpleGraph() {
		SimpleGraphNode<Character> nodeA = new SimpleGraphNode<Character>(0, 1, 'A');
		SimpleGraphNode<Character> nodeB = new SimpleGraphNode<Character>(1, 0, 'B');
		SimpleGraphNode<Character> nodeC = new SimpleGraphNode<Character>(3, 0, 'C');
		SimpleGraphNode<Character> nodeD = new SimpleGraphNode<Character>(4, 0, 'D');
		SimpleGraphNode<Character> nodeE = new SimpleGraphNode<Character>(1, 2, 'E');
		SimpleGraphNode<Character> nodeF = new SimpleGraphNode<Character>(1, 1, 'F');
		SimpleGraphNode<Character> nodeG = new SimpleGraphNode<Character>(2, 1, 'G');
		SimpleGraphNode<Character> nodeH = new SimpleGraphNode<Character>(2, 2, 'H');
		SimpleGraphNode<Character> nodeI = new SimpleGraphNode<Character>(3, 2, 'I');
		SimpleGraphNode<Character> nodeJ = new SimpleGraphNode<Character>(4, 2, 'J');
		SimpleGraphNode<Character> nodeK = new SimpleGraphNode<Character>(3, 1, 'K');
		SimpleGraphNode<Character> nodeL = new SimpleGraphNode<Character>(4, 1, 'L');
		SimpleGraphNode<Character> nodeM = new SimpleGraphNode<Character>(5, 1, 'M');
		
		nodeA.addEdge(nodeB, 1);
		nodeA.addEdge(nodeE, 1);
		
		nodeB.addEdge(nodeC, 2);
		
		nodeC.addEdge(nodeD, 1);
		
		nodeE.addEdge(nodeF, 1);
		nodeE.addEdge(nodeG, 1);
		
		nodeG.addEdge(nodeH, 1);
		
		nodeH.addEdge(nodeI, 1);
		
		nodeI.addEdge(nodeJ, 1);
		nodeI.addEdge(nodeK, 1);
		
		nodeJ.addEdge(nodeK, 1);
		
		nodeK.addEdge(nodeL, 1);
		
		nodeL.addEdge(nodeM, 1);
		
		nodeM.addEdge(nodeD, 1);
		
		Map<Character, ImmutableGraphNode<Character>> result = new TreeMap<Character, ImmutableGraphNode<Character>>();
		result.put('A', nodeA);
		result.put('B', nodeB);
		result.put('C', nodeC);
		result.put('D', nodeD);
		result.put('E', nodeE);
		result.put('F', nodeF);
		result.put('G', nodeG);
		result.put('H', nodeH);
		result.put('I', nodeI);
		result.put('J', nodeJ);
		result.put('K', nodeK);
		result.put('L', nodeL);
		result.put('M', nodeM);
		return result;
	}
}
