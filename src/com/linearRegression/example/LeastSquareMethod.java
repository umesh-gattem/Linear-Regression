package com.linearRegression.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

	static BufferedReader br = null;

	static double TipAmount[] = new double[20];
	static String TipAmounts[] = new String[20];
	static String BillAmounts[] = new String[20];
	static double BillAmount[] = new double[20];
	static double TotalBillAmount = 0;
	static double TotalTipAmount = 0;
	static double BillDeviation[] = new double[20];
	static double TipDeviation[] = new double[20];
	static double MeanOfTipAmount;
	static double MeanOfBillAmount;
	static double DeviationProduct[] = new double[20];
	static double BillDeviationSquare[] = new double[20];
	static double TotalDeviationProduct;
	static double TotalBillDeviationSquare;
	static String indent = "  ";
	static double SlopeOfLine;
	static double InterceptFormOfLine;
	static int choice;
	static int NoOfValues;

	public static void main(String[] args) throws IOException {

		System.out.println("No of values");
		br = new BufferedReader(new InputStreamReader(System.in));
		String val = br.readLine();
		NoOfValues = Integer.parseInt(val);
		insertBillAmountAndTipAmount(NoOfValues);
		calculateBillAndTipDeviation(NoOfValues);
		printAllDetails();
		calcuateSlopeAndIntercept();
		do {
			System.out.println("\nEnter any Bill Amount to Predict Tip Amount : ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String Value = br.readLine();
			int GivenData = Integer.parseInt(Value);
			printPredictValue(GivenData);

		} while (choice == 1);

	}

	/**
	 * 
	 * Here is the Declaration to Calculate the Slope and Intercept of the Line
	 * 
	 */
	private static void calcuateSlopeAndIntercept() {
		// TODO Auto-generated method stub
		SlopeOfLine = TotalDeviationProduct / TotalBillDeviationSquare;
		System.out.printf("Slope of line is  %.4f\n", +SlopeOfLine);

		InterceptFormOfLine = MeanOfTipAmount - (SlopeOfLine * MeanOfBillAmount);

		System.out.printf("Intercept form of a line is: %.4f \n", +InterceptFormOfLine);

		System.out.printf("Equation of Line is : %.4fx+(%.4f)\n", +SlopeOfLine, +InterceptFormOfLine);
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
			System.out.println("   " + BillAmount[i] + indent + indent + indent + indent + indent + indent
					+ TipAmount[i] + indent + indent + indent + indent + indent + indent + BillDeviation[i] + indent
					+ indent + indent + indent + indent + indent + indent + indent + TipDeviation[i] + indent + indent
					+ indent + indent + indent + indent + indent + indent + indent + DeviationProduct[i] + indent
					+ indent + indent + indent + indent + indent + indent + indent + BillDeviationSquare[i]);
		}

	}

	/**
	 * Here is the declaration of Calculate the Bill Deviation and Tip Deviation
	 * 
	 * 
	 * @param NoOfValues
	 */
	private static void calculateBillAndTipDeviation(int NoOfValues) {
		// TODO Auto-generated method stub
		for (int i = 0; i < NoOfValues; i++) {
			BillDeviation[i] = BillAmount[i] - MeanOfBillAmount;
			TipDeviation[i] = TipAmount[i] - MeanOfTipAmount;
		}
		for (int i = 0; i < NoOfValues; i++) {
			DeviationProduct[i] = BillDeviation[i] * TipDeviation[i];
			BillDeviationSquare[i] = BillDeviation[i] * BillDeviation[i];
			TotalDeviationProduct += DeviationProduct[i];
			TotalBillDeviationSquare += BillDeviationSquare[i];
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
			BillAmounts[i] = br.readLine();
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
