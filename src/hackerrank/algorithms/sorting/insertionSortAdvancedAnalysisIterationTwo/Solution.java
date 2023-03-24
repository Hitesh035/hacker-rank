package hackerrank.algorithms.sorting.insertionSortAdvancedAnalysisIterationTwo;

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
	 * 
	 */

	public static boolean isSorted(List<Integer> arr) {
		boolean flag = true;

		for (int i = 0; i + 1 < arr.size(); i++) {
			if (arr.get(i + 1) > arr.get(i))
				continue;
			else {
				flag = false;
				return flag;
			}
		}

		return flag;
	}

	public static int insertionSort(List<Integer> arr) {
//		int [] array = new int [arr.size()];
//		Iterator<Integer> itr = arr.iterator();
//		int arrayIndex =0;
//		while(itr.hasNext()) {
//			array[arrayIndex] = itr.next();
//			arrayIndex++;
//		}

		if (Result.isSorted(arr)) {
			System.out.println(Result.isSorted(arr));
			return 0;
		}

		int count = 0;
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 1; i < arr.size(); i++) {
			int tempCount = 0;

			if (map.containsKey(arr.get(i))) {
				tempCount = map.get(arr.get(i)).get(1);
				for (int j = i - 1; j >= map.get(arr.get(i)).get(0); j--) {
					if (arr.get(i) < arr.get(j))
						tempCount++;
				}
				count += tempCount;
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(i);
				tempList.add(tempCount);
				map.put(arr.get(i), tempList);
			}

			else {
				for (int j = i - 1; j >= 0; j--) {
					if (arr.get(i) < arr.get(j))
						tempCount++;
				}

				count += tempCount;
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(i);
				tempList.add(tempCount);
				map.put(arr.get(i), tempList);
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
		innerList1.add(1);
		innerList1.add(2);
		innerList1.add(1);
		innerList1.add(2);
		innerList1.add(2);
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
