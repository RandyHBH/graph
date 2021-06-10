package com.example.functions.common;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class DirectPaths {

	private DirectPaths() {
	}

	public static List<GraphPath<Character, DefaultWeightedEdge>> getGraphPaths(SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> graph, char start, char end, int hops) {
		var allPaths = new AllDirectedPaths<>(graph);
		return allPaths
				   .getAllPaths(start, end, false, hops)
				   .stream()
				   .filter(path -> path.getEdgeList().size() != 0)
				   .collect(toList());
	}
}
