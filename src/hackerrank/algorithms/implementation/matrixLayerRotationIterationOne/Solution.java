package hackerrank.algorithms.implementation.matrixLayerRotationIterationOne;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'matrixRotation' function below.
	 *
	 * The function accepts following parameters: 1. 2D_INTEGER_ARRAY matrix 2.
	 * INTEGER r
	 */

	public static void matrixRotation(List<List<Integer>> matrix, int r) {

		Integer rows = matrix.size();
		Integer columns = matrix.get(0).size();
		Integer[][] matrixArr = new Integer[rows][columns];
		Integer[][] currentRotationArray = new Integer[rows][columns];
		Integer[][] resultArray = new Integer[rows][columns];

		// Transferring the integers into a 2-D Integer array.

//		Integer rowCount = 0;
//		for (List<Integer> tempList : matrix) {
//			columns = tempList.size();
//			Integer[] tempArr = (Integer[]) tempList.toArray();
//
//			Integer columnCount = 0;
//			for (Integer tempInt : tempArr) {
//				matrixArr[rowCount][columnCount] = tempInt;
//				columnCount++;
//			}
//			rowCount++;
//		}

		Iterator<List<Integer>> outerItr = matrix.iterator();
		Integer rowCount = 0;
		while (outerItr.hasNext()) {

			ArrayList<Integer> tempList = (ArrayList<Integer>) outerItr.next();

			Iterator<Integer> innerItr = tempList.iterator();
			Integer columnCount = 0;
			while (innerItr.hasNext()) {
				matrixArr[rowCount][columnCount] = innerItr.next();
				columnCount++;
			}
			rowCount++;
		}

		// Initiating array manipulation
		for (int rotations = 1; rotations <= r; rotations++) {

			if (rotations == 1) {

				currentRotationArray = matrixArr;
			} else {
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < columns; j++) {
						currentRotationArray[i][j] = resultArray[i][j];
					}

				}

			}
			currentRotationArray = matrixArr;
			int currentLayerRows = rows;
			int currentLayerColumns = columns;
			for (int layer = 1; layer <= ((rows >= columns) ? columns : rows) / 2; layer++) {
				int i = layer - 1; // rowIndex
				int j = layer - 1; // columnIndex
				int layerMaxRowIndex = rows - layer;
				int layerMaxColumnIndex = columns - layer;
				int layerMinRowIndex = layer - 1;
				int layerMinColumnIndex = layer - 1;

				int chiefLine = currentLayerColumns >= currentLayerRows ? currentLayerColumns : currentLayerRows;
				int secondaryLine = currentLayerColumns <= currentLayerRows ? currentLayerColumns : currentLayerRows;
				int currentLayerElements = (chiefLine * 2) + ((secondaryLine - 2) * 2);

				for (int elements = 1; elements <= currentLayerElements; elements++) {
					if (i + 1 <= layerMaxRowIndex && j == layerMinColumnIndex) {
						resultArray[i + 1][j] = currentRotationArray[i][j];
						i++;
					} else if (i + 1 > layerMaxRowIndex && j + 1 <= layerMaxColumnIndex) {
						resultArray[i][j + 1] = currentRotationArray[i][j];
						j++;
					} else if (j + 1 > layerMaxColumnIndex && i - 1 >= layerMinRowIndex) {
						resultArray[i - 1][j] = currentRotationArray[i][j];
						i--;
					} else if (i - 1 < layerMinRowIndex && j - 1 >= layerMinColumnIndex) {
						resultArray[i][j - 1] = currentRotationArray[i][j];
						j--;
					}
				}
				currentLayerColumns -= 2;
				currentLayerRows -= 2;

			}

		}

		// Initiating Array printing. Need to print resultArray.

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(resultArray[i][j] + " ");

			}
			System.out.println();
		}

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//		int m = Integer.parseInt(firstMultipleInput[0]);
//
//		int n = Integer.parseInt(firstMultipleInput[1]);
//
//		int r = Integer.parseInt(firstMultipleInput[2]);

		List<Integer> innerList1 = new ArrayList<>();
		innerList1.add(1);
		innerList1.add(2);
		innerList1.add(3);
		innerList1.add(4);

		List<Integer> innerList2 = new ArrayList<>();
		innerList2.add(5);
		innerList2.add(6);
		innerList2.add(7);
		innerList2.add(8);

		List<Integer> innerList3 = new ArrayList<>();
		innerList3.add(9);
		innerList3.add(10);
		innerList3.add(11);
		innerList3.add(12);

		List<Integer> innerList4 = new ArrayList<>();
		innerList4.add(13);
		innerList4.add(14);
		innerList4.add(15);
		innerList4.add(16);

		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add(innerList1);
		matrix.add(innerList2);
		matrix.add(innerList3);
		matrix.add(innerList4);

		int r = 12;

//		IntStream.range(0, m).forEach(i -> {
//			try {
//				matrix.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//						.map(Integer::parseInt).collect(toList()));
//			} catch (IOException ex) {
//				throw new RuntimeException(ex);
//			}
//		});

		Result.matrixRotation(matrix, r);

//		bufferedReader.close();
	}
}
