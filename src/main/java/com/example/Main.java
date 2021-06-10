package com.example;

import com.example.domain.Graph;
import com.example.functions.Latency;
import com.example.functions.ShortestTraces;
import com.example.functions.Traces;
import com.example.util.DataValidator;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.io.File;
import java.util.List;

import static com.example.util.DataExtractor.extractedDataFrom;

public class Main {


	public static void main(String[] args) {

		if (args.length == 0 || args[0].trim().length() == 0) {
			System.out.println("File address is missing.");
			System.out.println("Try to execute the app passing the dir to the file.");
			System.out.println("Try to execute the app passing the dir to the file.");
			System.out.println("ex: java -jar graph /path/to/file.");
			return;
		}

		File file = new File(args[0].trim());
		List<String[]> listOfGraphData = extractedDataFrom(file);

		for (String[] graphData : listOfGraphData) {
			if (!DataValidator.isDataValid(graphData)) break;

			SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> graph = new Graph(graphData).getGraph();

			Latency.averageByPath(graph, List.of('A', 'B', 'C'));
			Latency.averageByPath(graph, List.of('A', 'D'));
			Latency.averageByPath(graph, List.of('A', 'D', 'C'));
			Latency.averageByPath(graph, List.of('A', 'E', 'B', 'C', 'D'));
			Latency.averageByPath(graph, List.of('A', 'E', 'D'));

			Traces.byAmountOfHops(graph, 'C', 'C', 0, 3);
			Traces.byAmountOfHops(graph, 'A', 'C', 4, 4);

			ShortestTraces.byLatency(graph, 'A', 'C');
			ShortestTraces.byLatency(graph, 'B', 'B');

			ShortestTraces.withLatencyLowerThan(graph, 'C', 'C', 30);
		}
	}
}
