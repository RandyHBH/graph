package com.example.functions;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.List;

import static com.example.functions.common.DirectPaths.getGraphPaths;

public class Traces {

	private Traces() {
	}

	public static Integer byAmountOfHops(SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> graph, char start, char end, int minHops, int maxHops) {
		if (minHops < 0 || maxHops < 0) return null;
		if (minHops > maxHops) return null;

		List<GraphPath<Character, DefaultWeightedEdge>> paths = getGraphPaths(graph, start, end, maxHops);

		int size;
		if (minHops == maxHops) {
			size = (int) paths.stream().filter(path -> path.getLength() == maxHops).count();
		} else if (minHops > 0) {
			size = (int) paths.stream().filter(path -> path.getLength() >= minHops && path.getLength() <= maxHops).count();
		} else {
			size = (int) paths.stream().filter(path -> path.getLength() <= maxHops).count();
		}
		System.out.println(size);
		return size;
	}
}
