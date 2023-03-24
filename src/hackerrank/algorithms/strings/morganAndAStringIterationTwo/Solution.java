package hackerrank.algorithms.strings.morganAndAStringIterationTwo;

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

	public static String morganAndString(String a, String b) {
		// Write your code here

		Deque<Character> jack = new ArrayDeque<>();
		Deque<Character> daniel = new ArrayDeque<>();

		Deque<Character> jackTemp = new ArrayDeque<>();
		Deque<Character> danielTemp = new ArrayDeque<>();

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
						while ((!jack.isEmpty() && !daniel.isEmpty()) && jack.peek().equals(daniel.peek())) {

							jackTemp.push(jack.pop());
							danielTemp.push(daniel.pop());

						}
						boolean flag = true;
						if ((!jack.isEmpty() && !daniel.isEmpty()) && jack.peek() > daniel.peek()) {
							flag = false;
						} else if ((!jack.isEmpty() && !daniel.isEmpty()) && jack.peek() < daniel.peek()) {
							flag = true;
						} else if (jack.isEmpty() && !daniel.isEmpty())
							flag = true;
						else if (!jack.isEmpty() && daniel.isEmpty())
							flag = false;
						else if (jack.isEmpty() && daniel.isEmpty())
							flag = true;

						while (!jackTemp.isEmpty() || !danielTemp.isEmpty()) {

							if (!jackTemp.isEmpty()) {
								jack.push(jackTemp.pop());
							} else if (!danielTemp.isEmpty()) {
								daniel.push(danielTemp.pop());
							}
						}

						if (flag) {
							toReturnArray[arrayIndex] = jack.pop();
							arrayIndex++;
						} else if (!flag) {
							toReturnArray[arrayIndex] = daniel.pop();
							arrayIndex++;
						}

					}
				} else if (jack.peek() <= daniel.peek()) {
					if (jack.peek() < daniel.peek()) {
						toReturnArray[arrayIndex] = jack.pop();
						arrayIndex++;
					} else if (jack.peek().equals(daniel.peek())) {
						while ((!jack.isEmpty() && !daniel.isEmpty()) && jack.peek().equals(daniel.peek())) {
							jackTemp.push(jack.pop());
							danielTemp.push(daniel.pop());

						}
						boolean flag = true;
						if ((!jack.isEmpty() && !daniel.isEmpty()) && jack.peek() > daniel.peek()) {
							flag = false;
						} else if ((!jack.isEmpty() && !daniel.isEmpty()) && jack.peek() < daniel.peek()) {
							flag = true;
						} else if (jack.isEmpty() && !daniel.isEmpty())
							flag = true;
						else if (!jack.isEmpty() && daniel.isEmpty())
							flag = false;
						else if (jack.isEmpty() && daniel.isEmpty())
							flag = true;

						while (!jackTemp.isEmpty() || !danielTemp.isEmpty()) {

							if (!jackTemp.isEmpty()) {
								jack.push(jackTemp.pop());
							} else if (!danielTemp.isEmpty()) {
								daniel.push(danielTemp.pop());
							}
						}

						if (flag) {
							toReturnArray[arrayIndex] = jack.pop();
							arrayIndex++;
						} else if (!flag) {
							toReturnArray[arrayIndex] = daniel.pop();
							arrayIndex++;
						}
					}
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
		File file = new File("/home/me/Downloads/input17.txt");	
		File fileOp = new File("/home/me/Downloads/output17.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOp));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				String a = bufferedReader.readLine();

				String b = bufferedReader.readLine();

				String result = Result.morganAndString(a, b);

				bufferedWriter.write(result);
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		System.out.println("SUCCESS");
		bufferedReader.close();
		bufferedWriter.close();

		
	}
}
