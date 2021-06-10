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
class TracesByHopsTest {
	private SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> testGraph;

	@BeforeAll
	void beforeAll() {
		testGraph = GraphFixture.getTestGraph();
	}

	@Test
	void shouldReturnTheCorrectAmountOfTraces() {
		Integer traces = TracesByHops.tracesWithAmountOfHops(testGraph, 'C', 'C', 0, 3);

		assertEquals(2, traces, "The amount of traces should");
	}

	@Test
	void shouldReturnNullIfMinAmountOfHopsIsNegative() {
		Integer traces = TracesByHops.tracesWithAmountOfHops(testGraph, 'C', 'C', -1, 3);

		assertNull(traces, "Can not work with negative amounts of hops");
	}

	@Test
	void shouldReturnNullIfMaxAmountOfHopsIsNegative() {
		Integer traces = TracesByHops.tracesWithAmountOfHops(testGraph, 'C', 'C', 0, -3);

		assertNull(traces, "Can not work with negative amounts of hops");
	}

	@Test
	void shouldReturnNullIfMinIsHigherThanMax() {
		Integer traces = TracesByHops.tracesWithAmountOfHops(testGraph, 'C', 'C', 3, 2);

		assertNull(traces, "Minimum amounts of hops can not be higher than the Maximum amounts");
	}
}
