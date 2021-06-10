package com.example.functions;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Latency {

	private Latency() {
	}

	public static Integer averageByPath(SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> graph, List<Character> path) {
		if (path == null) return null;
		if (path.isEmpty()) return null;
		if (path.size() == 1) return null;

		int latency = 0;
		for (int i = 0, pathSize = path.size() - 1; i < pathSize; i++) {
			var nextVertex = path.get(i + 1);

			var defaultWeightedEdges = new ArrayList<>(graph.outgoingEdgesOf(path.get(i)));
			var currentVertexTargets = defaultWeightedEdges.stream().map(graph::getEdgeTarget).collect(toList());

			if (!currentVertexTargets.isEmpty() && currentVertexTargets.contains(nextVertex)) {
				var index = currentVertexTargets.indexOf(nextVertex);
				latency += (int) graph.getEdgeWeight(defaultWeightedEdges.get(index));
			} else {
				System.out.println("NO SUCH TRACE");
				return null;
			}
		}
		System.out.println(latency);
		return latency;
	}
}
