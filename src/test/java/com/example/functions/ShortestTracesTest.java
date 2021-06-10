package com.example.functions;

import com.example.fixture.GraphFixture;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
class ShortestTracesTest {
	private SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> testGraph;

	@BeforeAll
	void beforeAll() {
		testGraph = GraphFixture.getTestGraph();
	}

	@Test
	void shouldReturnTheLengthOfTheShortestTraceByLatency() {
		Integer traces = ShortestTraces.withLatencyLowerThan(testGraph, 'A', 'E', 12);

		assertEquals(3, traces);
	}

	@Test
	void shouldReturnNullIfMaxLatencyIsZero() {
		Integer traces = ShortestTraces.withLatencyLowerThan(testGraph, 'A', 'E', -12);

		assertNull(traces);
	}

	@Test
	void shouldReturnTheWeightOfTheShortestTraceByLatency() {
		Integer weight = ShortestTraces.byLatency(testGraph, 'A', 'E');

		assertEquals(7, weight);
	}
}
