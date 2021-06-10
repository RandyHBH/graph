package com.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

	@Test
	void shouldBuildAGraphWhenTheGraphDataIsProvided() {
		var graphData = new String[]{"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
		var graph = new Graph(graphData);

		assertEquals(5, graph.getGraph().vertexSet().size());
		assertEquals(graphData.length, graph.getGraph().edgeSet().size());
	}
}
