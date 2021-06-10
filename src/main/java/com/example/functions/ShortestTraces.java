package com.example.functions;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.List;

import static com.example.functions.common.DirectPaths.getGraphPaths;
import static java.util.stream.Collectors.toList;


public class ShortestTraces {

	private ShortestTraces() {
	}

	public static Integer byLatency(SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> graph, Character start, Character end) {
		if (start == end) {
			List<GraphPath<Character, DefaultWeightedEdge>> paths = getGraphPaths(graph, start, end, graph.edgeSet().size());
			var path = paths.stream().findFirst();

			int weight = 0;
			if (path.isPresent()) {
				weight = (int) path.get().getWeight();
				System.out.println(weight);
			}

			return weight;
		} else {

			DijkstraShortestPath<Character, DefaultWeightedEdge> dijkstraAlg = new DijkstraShortestPath<>(graph);
			ShortestPathAlgorithm.SingleSourcePaths<Character, DefaultWeightedEdge> sourcePaths = dijkstraAlg.getPaths(start);

			int weight = (int) sourcePaths.getPath(end).getWeight();
			System.out.println(weight);
			return weight;
		}
	}

	public static Integer withLatencyLowerThan(SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> graph, char start, char end, int maxLatency) {
		if (maxLatency <= 0) return null;

		int hops = maxLatency / (maxLatency % graph.edgeSet().size());
		List<GraphPath<Character, DefaultWeightedEdge>> pathsLimitedByWeight = getGraphPaths(graph, start, end, hops);

		List<GraphPath<Character, DefaultWeightedEdge>> paths = pathsLimitedByWeight.stream()
																	.filter(graphPath -> graphPath.getWeight() < maxLatency)
																	.collect(toList());

		System.out.println(paths.size());
		return paths.size();
	}
}
