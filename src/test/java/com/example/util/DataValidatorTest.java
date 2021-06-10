package com.example.util;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataValidatorTest {


	@Test
	void graphDataProvidedShouldBeValid() {
		var graphData = new String[]{"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
		var result = DataValidator.isDataValid(graphData);
		assertTrue(result);
	}

	@Test
	void graphDataProvidedShouldNotBeValid() {
		var graphData = new String[]{"AB", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
		var result = DataValidator.isDataValid(graphData);
		assertFalse(result);
	}

	@Test
	void emptyGraphDataProvidedShouldNotBeValid() {
		var graphData = new String[]{""};
		var result = DataValidator.isDataValid(graphData);
		assertFalse(result);
	}
}
