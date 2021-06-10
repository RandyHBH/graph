package com.example.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class DataExtractor {

	private DataExtractor() {
	}

	public static List<String[]> extractedDataFrom(File file) {
		try (Stream<String> linesStream = Files.lines(file.toPath())) {
			return linesStream
					   .map(graphData -> graphData.split("\\s*,\\s*"))
					   .collect(toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emptyList();
	}
}
