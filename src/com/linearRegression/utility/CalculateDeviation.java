package com.linearRegression.utility;

import java.util.ArrayList;
import java.util.List;

public class CalculateDeviation {

	public static List<Double> calculateDeviation(List<Double> givenData, double meanOfGivenData) {
		List<Double> Deviation = new ArrayList<>();
		for (Double i :givenData) {
			Deviation.add(i - meanOfGivenData);
		}

		return Deviation;

	}

	public static double calculateTotalDeviationProduct(List<Double> dataDeviation,
			List<Double> predictedDeviation) throws Exception {
		double TotalDeviationProduct = 0;
		List<Double> DeviationProduct = new ArrayList<>();
		if(dataDeviation.size()!=predictedDeviation.size()) {
			throw new Exception("Data Deviation size and Predicted Deviation size are not equal");
		}
		for (int i = 0; i < dataDeviation.size(); i++) {
			DeviationProduct.add( dataDeviation.get(i) * predictedDeviation.get(i));
			TotalDeviationProduct += DeviationProduct.get(i);
		}
		return TotalDeviationProduct;
	}

	public static double calculateSlopeOfLine(double TotalDeviationProduct, double TotalDataDeviationSquare) {
		double SlopeOfLine = TotalDeviationProduct / TotalDataDeviationSquare;

		return SlopeOfLine;
	}

	public static double calculateInterceptOfLine(double MeanOfPredictedData, double MeanOfGivenData,
			double SlopeOfLine) {
		double InterceptFormOfLine = MeanOfPredictedData - (SlopeOfLine * MeanOfGivenData);

		return InterceptFormOfLine;
	}
}