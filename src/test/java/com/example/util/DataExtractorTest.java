package com.example.util;

import com.example.fixture.GraphFixture;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.example.fixture.GraphFixture.getGraphData;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DataExtractorTest {

	@Test
	void shouldBuildAGraphWhenTheGraphDataIsProvided() {
		var graphData = getGraphData();
		var file = new File("graphData.txt");

		var listOfGraphData = DataExtractor.extractedDataFrom(file);

		assertEquals(1, listOfGraphData.size());
		assertEquals(Arrays.toString(graphData), Arrays.toString(listOfGraphData.get(0)));
	}


}
