package hackerrank.algorithms.sorting.insertionSortAdvancedAnalysisIterationOne;

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
	 * Complete the 'insertionSort' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY arr as parameter.
	 */

	public static int insertionSort(List<Integer> arr) {
		int [] array = new int [arr.size()];
		Iterator<Integer> itr = arr.iterator();
		int arrayIndex =0;
		while(itr.hasNext()) {
			array[arrayIndex] = itr.next();
			arrayIndex++;
		}
		int count =0;
		
		
		for(int i =1; i<array.length; i++) {
			for(int j = i-1; j >=0; j--) {
				if(array[i] < array[j]) {
					count++;
				}
			}
		}
		return count;

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int t = Integer.parseInt(bufferedReader.readLine().trim());
		
		List<Integer> innerList1 = new ArrayList<>();
		innerList1.add(3);
		innerList1.add(5);
		innerList1.add(7);
		innerList1.add(11);
		innerList1.add(9);
//		innerList1.add(14);
//		innerList1.add(11);

//		IntStream.range(0, t).forEach(tItr -> {
//			try {
//				int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//				List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//						.map(Integer::parseInt).collect(toList());
//
//				int result = Result.insertionSort(arr);
//
//				bufferedWriter.write(String.valueOf(result));
//				bufferedWriter.newLine();
//			} catch (IOException ex) {
//				throw new RuntimeException(ex);
//			}
//		});
//
//		bufferedReader.close();
//		bufferedWriter.close();
		
		System.out.println(Result.insertionSort(innerList1));
	}
}
