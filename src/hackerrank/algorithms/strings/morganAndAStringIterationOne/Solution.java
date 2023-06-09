package hackerrank.algorithms.strings.morganAndAStringIterationOne;

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
	 * Complete the 'morganAndString' function below.
	 *
	 * The function is expected to return a STRING. The function accepts following
	 * parameters: 1. STRING a 2. STRING b
	 */
	
	//THIS ITERATION HAS A FEW BUGS IN THE CODE
	
	
	public static String morganAndString(String a, String b) {
		// Write your code here

		Stack<Character> jack = new Stack<>();
		Stack<Character> daniel = new Stack<>();

		char[] toReturnArray = new char[a.length() + b.length()];

		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
			if (i >= 0) {
				jack.push(a.charAt(i));
			}
			if (j >= 0) {
				daniel.push(b.charAt(j));
			}
		}
		int arrayIndex = 0;
		while (!jack.isEmpty() || !daniel.isEmpty()) {
			if (!jack.isEmpty() && !daniel.isEmpty()) {
				if (jack.peek() >= daniel.peek()) {
					if (jack.peek() > daniel.peek()) {
						toReturnArray[arrayIndex] = daniel.pop();
						arrayIndex++;
					} else if (jack.peek().equals(daniel.peek())) {
						toReturnArray[arrayIndex] = jack.pop();
						arrayIndex++;
					}
				} else if (jack.peek() <= daniel.peek()) {
					toReturnArray[arrayIndex] = jack.pop();
					arrayIndex++;
				}
			} else if (jack.isEmpty() && !daniel.isEmpty()) {

				toReturnArray[arrayIndex] = daniel.pop();
				arrayIndex++;
			} else if (!jack.isEmpty() && daniel.isEmpty()) {

				toReturnArray[arrayIndex] = jack.pop();
				arrayIndex++;
			}

		}

		return new String(toReturnArray);
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//		IntStream.range(0, t).forEach(tItr -> {
//			try {
//				String a = bufferedReader.readLine();
//
//				String b = bufferedReader.readLine();
//
//				String result = Result.morganAndString(a, b);
//
//				bufferedWriter.write(result);
//				bufferedWriter.newLine();
//			} catch (IOException ex) {
//				throw new RuntimeException(ex);
//			}
//		});
//
//		bufferedReader.close();
//		bufferedWriter.close();

		System.out.println(Result.morganAndString("ABC", "XYZZZZAASDE"));

	}
}
