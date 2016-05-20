package com.linearRegression.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.linearRegression.utility.CalculateDeviation;

public class LeastSquareMethod {
	/**
	 * This is the Main Class
	 * 
	 * This is sample Code of Linear Regression.
	 * 
	 * In this we have taken data of some restaurant where Tip Amount for the
	 * given Bill Amount is predicted using LeastSquareMethod
	 * 
	 * @param args
	 * @throws IOException
	 * 
	 * @author Umesh Kumar Gattem
	 * @since 18-05-2016
	 */
	private static final Logger LOGGER = Logger.getLogger(LeastSquareMethod.class);
	static BufferedReader br = null;

	static List<Double> TipAmount = new ArrayList<>();
	static List<String> BillAmounts = new ArrayList<>();
	static List<String> TipAmounts = new ArrayList<>();
	static List<Double> BillAmount = new ArrayList<>();
	static double TotalBillAmount = 0;
	static double TotalTipAmount = 0;
	static List<Double> BillDeviation = new ArrayList<>();
	static List<Double> TipDeviation = new ArrayList<>();
	static double MeanOfTipAmount;
	static double MeanOfBillAmount;

	static List<Double> DeviationProduct = new ArrayList<>();
	static List<Double> BillDeviationSquare = new ArrayList<>();

	static double TotalDeviationProduct;
	static double TotalBillDeviationSquare;
	static String indent = "  ";
	static double SlopeOfLine;
	static double InterceptFormOfLine;
	static int choice;
	public static int NoOfValues;

	public static void main(String[] args) throws IOException {
		LOGGER.info("hai hai hai");
		System.out.println("No of values");
		br = new BufferedReader(new InputStreamReader(System.in));
		String val = br.readLine();
		NoOfValues = Integer.parseInt(val);
		insertBillAmountAndTipAmount(NoOfValues);

		BillDeviation = CalculateDeviation.calculateDeviation(NoOfValues, BillAmount, MeanOfBillAmount);
		TipDeviation = CalculateDeviation.calculateDeviation(NoOfValues, TipAmount, MeanOfTipAmount);

		TotalDeviationProduct = CalculateDeviation.calculateTotalDeviationProduct(NoOfValues, BillDeviation,
				TipDeviation);
		TotalBillDeviationSquare = CalculateDeviation.calculateTotalDeviationProduct(NoOfValues, BillDeviation,
				BillDeviation);

		SlopeOfLine = CalculateDeviation.calculateSlopeOfLine(TotalDeviationProduct, TotalBillDeviationSquare);
		InterceptFormOfLine = CalculateDeviation.calculateInterceptOfLine(MeanOfTipAmount, MeanOfBillAmount,
				SlopeOfLine);

		printAllDetails();
		do {
			System.out.println("\nEnter any Bill Amount to Predict Tip Amount : ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String Value = br.readLine();
			int GivenData = Integer.parseInt(Value);
			printPredictValue(GivenData);

		} while (choice == 1);

	}

	
	/**
	 * Here is the declaration of Print all details
	 * 
	 * 
	 */
	private static void printAllDetails() {
		// TODO Auto-generated method stub
		System.out.println("Bill Amount     " + " Tip Amount" + "       Bill Deviation" + "       Tip Deviation"
				+ "       Deviation Product" + "    Bill Deviation Square");
		for (int i = 0; i < NoOfValues; i++) {
			System.out.println("   " + BillAmount.get(i) + indent + indent + indent + indent + indent + indent
					+ TipAmount.get(i) + indent + indent + indent + indent + indent + indent + BillDeviation.get(i) + indent
					+ indent + indent + indent + indent + indent + indent + indent + TipDeviation.get(i) + indent + indent
					+ indent + indent + indent + indent + indent + indent + indent + DeviationProduct.get(i) + indent
					+ indent + indent + indent + indent + indent + indent + indent + BillDeviationSquare.get(i));
		}

	}


	/**
	 * Here is the declaration of inserting Sample Bill Amount and Tip Amount .
	 * In this declaration we are inserting our details and finding out the mean
	 * values.
	 * 
	 * @param NoOfValues
	 * @throws IOException
	 */

	private static void insertBillAmountAndTipAmount(int NoOfValues) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the data:  ");
		System.out.println("Enter the Bill Amount data");
		for (int i = 0; i < NoOfValues; i++) {
			br = new BufferedReader(new InputStreamReader(System.in));
			BillAmounts.get(i) = br.readLine();
			BillAmount[i] = Double.parseDouble(BillAmounts[i]);
			TotalBillAmount += BillAmount[i];
		}
		MeanOfBillAmount = TotalBillAmount / NoOfValues;

		System.out.println("Enter the Tip Amount data");
		for (int i = 0; i < NoOfValues; i++) {
			br = new BufferedReader(new InputStreamReader(System.in));
			TipAmounts[i] = br.readLine();
			TipAmount[i] = Double.parseDouble(TipAmounts[i]);
			TotalTipAmount += TipAmount[i];
		}
		MeanOfTipAmount = TotalTipAmount / NoOfValues;
	}

	/**
	 * Here is the declaration for Predicting value. It takes the given data as
	 * input and it gives the predicted value as output by using Slope-
	 * Intercept line equation.
	 * 
	 * @param x
	 * @return
	 * @throws IOException
	 */

	private static int printPredictValue(int GivenData) throws IOException {
		// TODO Auto-generated method stub
		int PredictedValue = (int) ((SlopeOfLine * GivenData) + InterceptFormOfLine);
		System.out.printf("Tip Amount Predicted for given Bill Amount is:  %d\n", +PredictedValue);
		System.out.println("\nWant to try for another Bill Amount : \n ");
		System.out.println("Presss 1 to Continue");
		br = new BufferedReader(new InputStreamReader(System.in));
		String ch = br.readLine();
		choice = Integer.parseInt(ch);
		return choice;

	}

}
