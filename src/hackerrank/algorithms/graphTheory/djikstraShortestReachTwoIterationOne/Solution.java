package hackerrank.algorithms.graphTheory.djikstraShortestReachTwoIterationOne;

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

// INCOMPLETE CODE

class Node implements Comparable<Node> {
	public int identity;
	List<List<Integer>> connections = new ArrayList<>();

	HashSet<Node> connectedTo = new HashSet<>();

	public Node(int identity) {
		this.identity = identity;
	}

	public int getIdentity() {
		return this.identity;
	}

	public void setConnection(List<Integer> connection, Node n) {
		this.connections.add(connection);
		this.connectedTo.remove(n);

		this.connectedTo.add(n);
	}

	public List<List<Integer>> getConnections() {

		return this.connections;
	}

	public HashSet<Node> getConnectedTo() {

		return this.connectedTo;
	}

	@Override
	public int hashCode() {

		return this.identity;
	}

	@Override
	public int compareTo(Node o) {

		return this.identity - o.identity;
	}

	@Override
	public boolean equals(Object obj) {

		Node n = (Node) obj;
		return this.identity == n.identity;
	}
}

class Result {

	/*
	 * Complete the 'shortestReach' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY edges 3. INTEGER s
	 */
	static Map<Node, Node> map = new HashMap<>();

	public static List<Integer> connectedNodes(int n) {

		Node node = map.get(new Node(n));

		return node.getConnectedTo().stream().map(tempNode -> {
			return tempNode.getIdentity();
		}).collect(Collectors.toList());
	}

	public static List<Integer> pathFinder(Node n, Node start) {

		n.getConnectedTo().stream();
		return Collections.EMPTY_LIST;
	}

	public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
		// Write your code here
		Map<Node, Node> nodeMap = new HashMap<>();

		for (List<Integer> list : edges) {
			Node nodeStart = new Node(list.get(0));
			Node nodeEnd = new Node(list.get(1));

			if (!nodeMap.containsKey(nodeStart)) {
				nodeStart.setConnection(list, nodeEnd);
				nodeMap.put(nodeStart, nodeStart);
			} else if (nodeMap.containsKey(nodeStart)) {
				nodeMap.get(nodeStart).setConnection(list, nodeEnd);
			}

			if (!nodeMap.containsKey(nodeEnd)) {
				nodeEnd.setConnection(list, nodeStart);
				nodeMap.put(nodeEnd, nodeEnd);
			} else if (nodeMap.containsKey(nodeEnd)) {
				nodeMap.get(nodeEnd).setConnection(list, nodeStart);
			}

		}

		Node startNode = nodeMap.get(new Node(s));

		// map = nodeMap;

		return nodeMap.keySet().stream().map(temp -> {
			Node current = nodeMap.get(temp);
			List<Integer> distances = new ArrayList<>();
			boolean startNodeIsNotConnected = false;
			if (!current.equals(startNode)) {
				boolean startNodeIsConnected = startNode.getConnectedTo().contains(current);

				if (startNodeIsConnected) {
					int currentId = current.getIdentity();
					int startNodeId = startNode.getIdentity();
					List<List<Integer>> connections = startNode.getConnections();
					connections.stream().filter(list -> {
						return (list.get(0) == currentId || list.get(1) == currentId);
					}).map(connection -> {

						return connection.get(2);

					}).collect(Collectors.toList()).stream().forEach(distances::add);
				}

			}
			if (distances.isEmpty())
				return -5;
			else
				return distances.stream().min(Integer::compare).get();
		}).filter(i -> i != -5).collect(Collectors.toList());
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(new File("/home/me/Downloads/djikstrainput00.txt")));
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter(new File("/home/me/Downloads/djikstraop00.txt")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				int n = Integer.parseInt(firstMultipleInput[0]);

				int m = Integer.parseInt(firstMultipleInput[1]);

				List<List<Integer>> edges = new ArrayList<>();

				IntStream.range(0, m).forEach(i -> {
					try {
						edges.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
								.map(Integer::parseInt).collect(toList()));
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				});

				int s = Integer.parseInt(bufferedReader.readLine().trim());

				List<Integer> result = Result.shortestReach(n, edges, s);

				bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();

//		List<Integer> list1 = new ArrayList<>();
//		List<Integer> list2 = new ArrayList<>();
//		List<Integer> list3 = new ArrayList<>();
//		List<Integer> list4 = new ArrayList<>();
//		List<Integer> list5 = new ArrayList<>();

//		list1.add(3);
//		list1.add(6);
//		list1.add(12);
//		list2.add(7);
//		list2.add(2);
//		list2.add(12);
//		list3.add(1);
//		list3.add(2);
//		list3.add(12);
//		list4.add(5);
//		list4.add(1);
//		list4.add(12);
//		list5.add(5);
//		list5.add(2);
//		list5.add(12);
//		List<List<Integer>> list = new ArrayList<>();
//		list.add(list1);
//		list.add(list2);
//		list.add(list3);
//		list.add(list4);
//		list.add(list5);

//		List<Integer> returnL = Result.shortestReach(4, list, 4);
//
//		for (Integer i : returnL) {
//			System.out.println(i);
//		}
//
//		System.out.println("------------------");
//
//		List<Integer> secondList = Result.connectedNodes(2);
//
//		for (Integer i : secondList) {
//			System.out.println(i);
//		}
	}

}
