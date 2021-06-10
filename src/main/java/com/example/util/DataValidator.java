package com.example.util;

import java.util.Arrays;

public class DataValidator {

	private DataValidator() {
	}

	public static boolean isDataValid(String[] data) {
		return guardAgainstEmptyData(data) && guardAgainstMalFormedEdgeData(data);
	}

	private static boolean guardAgainstMalFormedEdgeData(String[] data) {
		return !Arrays.stream(data).map(edge -> edge.length() < 3).findFirst().orElse(true);
	}

	private static boolean guardAgainstEmptyData(String[] data) {
		return data.length != 0;
	}
}
