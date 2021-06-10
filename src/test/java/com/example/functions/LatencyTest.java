package com.example.functions;

import com.example.fixture.GraphFixture;
import com.example.functions.common.DirectPaths;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
class LatencyTest {

	private SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> testGraph;

	@BeforeAll
	void beforeAll() {
		testGraph = GraphFixture.getTestGraph();
	}

	@Test
	void shouldReturnTheCorrectLatencyBetweenTwoVertexes() {
		Integer latency = Latency.averageLatencyByPath(testGraph, List.of('A', 'B'));
		assertEquals(5, latency, "The latency of from A->B should be equal to 5");
	}

	@Test
	void shouldReturnNullWhenNoPathIsProvided() {
		Integer latency = Latency.averageLatencyByPath(testGraph, List.of());
		assertNull(latency, "There is no latency when a path is not provided");
	}

	@Test
	void shouldReturnNullWhenAPathSizeOfOneIsProvided() {
		Integer latency = Latency.averageLatencyByPath(testGraph, List.of('A'));
		assertNull(latency, "We can't calculate latency when a path with one vertex is provided");
	}
}
