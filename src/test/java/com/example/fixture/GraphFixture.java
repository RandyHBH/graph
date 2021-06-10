package com.example.fixture;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class GraphFixture {

	public static String[] getGraphData() {
		return new String[]{"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
	}

	public static SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> getTestGraph() {
		SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');

		DefaultWeightedEdge edgeAB = graph.addEdge('A', 'B');
		graph.setEdgeWeight(edgeAB, 5);

		DefaultWeightedEdge edgeAD = graph.addEdge('A', 'D');
		graph.setEdgeWeight(edgeAD, 5);

		DefaultWeightedEdge edgeAE = graph.addEdge('A', 'E');
		graph.setEdgeWeight(edgeAE, 7);

		DefaultWeightedEdge edgeBC = graph.addEdge('B', 'C');
		graph.setEdgeWeight(edgeBC, 4);

		DefaultWeightedEdge edgeCD = graph.addEdge('C', 'D');
		graph.setEdgeWeight(edgeCD, 8);

		DefaultWeightedEdge edgeCE = graph.addEdge('C', 'E');
		graph.setEdgeWeight(edgeCE, 2);

		DefaultWeightedEdge edgeDC = graph.addEdge('D', 'C');
		graph.setEdgeWeight(edgeDC, 8);

		DefaultWeightedEdge edgeDE = graph.addEdge('D', 'E');
		graph.setEdgeWeight(edgeDE, 6);

		DefaultWeightedEdge edgeEB = graph.addEdge('E', 'B');
		graph.setEdgeWeight(edgeEB, 3);

		return graph;
	}
}
