package com.example.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.Arrays;

public class Graph {

	SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> graph;

	public Graph(String[] graphData) {
		graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		addNodesToGraph(graphData);
	}

	private void addNodesToGraph(String[] graphData) {
		var edgeSources = new DefaultWeightedEdge[graphData.length];

		Arrays.stream(graphData)
			.map(s -> s.charAt(0))
			.forEach(graph::addVertex);

		for (int i = 0, graphDataLength = graphData.length; i < graphDataLength; i++) {
			String edge = graphData[i];

			char sourceVertex = edge.charAt(0);
			char targetVertex = edge.charAt(1);
			double weight = Double.parseDouble(edge.substring(2));

			edgeSources[i] = graph.addEdge(sourceVertex, targetVertex);
			graph.setEdgeWeight(edgeSources[i], weight);
		}
	}

	public SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> getGraph() {
		return this.graph;
	}
}
