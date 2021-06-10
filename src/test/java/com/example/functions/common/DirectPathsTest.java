package com.example.functions.common;

import com.example.fixture.GraphFixture;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
class DirectPathsTest {

	private SimpleDirectedWeightedGraph<Character, DefaultWeightedEdge> testGraph;

	@BeforeAll
	void beforeAll() {
		testGraph = GraphFixture.getTestGraph();
	}

	@Test
	void shouldGetPathsFromAVertexToAnotherVertexOfTheGraphWithTheAmountOfHopsDefined() {
		List<GraphPath<Character, DefaultWeightedEdge>> pathList = DirectPaths.getGraphPaths(testGraph, 'A', 'B', 1);

		assertEquals(1, pathList.size(), "The size amount of the path from A->B should be equal to 1");
		assertEquals(5, pathList.stream().mapToDouble(GraphPath::getWeight).sum(), "The path weight from A->B should be equal to 5");
	}

	@Test
	void shouldReturnZeroIfNoPathsFromAVertexToAnotherVertexOfTheGraphWithTheAmountOfHopsDefinedExist() {
		List<GraphPath<Character, DefaultWeightedEdge>> pathList = DirectPaths.getGraphPaths(testGraph, 'A', 'C', 1);

		assertEquals(0, pathList.size(), "The size amount of the path from A->C should be equal to 0");
		assertEquals(0, pathList.stream().mapToDouble(GraphPath::getWeight).sum(), "The path weight from A->C should be equal to 0");
	}
}
