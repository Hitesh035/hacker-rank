package hackerrank.algorithms.strings.determiningDnaHealthIterationOne;

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

	public static int possibleNumberOfGenes(String dna, String gene) {

		int possibleNumber = 0;
		char [] dnaArray = dna.toCharArray();
		char [ ] geneArray = gene.toCharArray();
		for(int i = 0; i< dnaArray.length; i++) {
			if (dnaArray[i] == geneArray[0]){
				boolean flag = true;
				int k =0;
				for(int j =i; j < dnaArray.length && k < geneArray.length; j++,k++) {
					
					if(flag && dnaArray[j] == geneArray[k] ) continue;
					else {
						flag =false;
					}
				}
				
				if(flag && k == geneArray.length) possibleNumber++;
			}
		}

		return possibleNumber;
	}

	public static int health(List<Integer> health, List<String> genes, int first, int last, String d) {
		int healthReturn = 0;

		Map<String, ArrayList<Integer>> map = new HashMap<>();

//		Iterator<String> genesItr = genes.iterator();
//		Iterator<Integer> healthItr = health.iterator();
//		
//		while(genesItr.hasNext()) {
//			String currentGene = genesItr.next();
//			Integer currentGeneHealth = healthItr.next();
//			if(map.containsKey(currentGene)) {
//				ArrayList<Integer> tempList = map.get(currentGene);
//				tempList.add(currentGeneHealth);
//				map.put(currentGene, tempList);
//			}
//			else {
//				ArrayList<Integer> tempList =  new ArrayList<>();
//				tempList.add(currentGeneHealth);
//				map.put(currentGene, tempList);
//			}
//			
//		}

		for (int i = first; i <= last; i++) {
			String currentGene = genes.get(i);
			Integer currentGeneHealth = health.get(i);
			if (map.containsKey(currentGene)) {
				ArrayList<Integer> tempList = map.get(currentGene);
				tempList.add(currentGeneHealth);
				map.put(currentGene, tempList);
			} else {
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(currentGeneHealth);
				map.put(currentGene, tempList);
			}

		}
		
		Set<String> keySet = map.keySet();
		
		Iterator<String> keySetItr = keySet.iterator();
		
		while(keySetItr.hasNext()) {
			
			String gene = keySetItr.next();
			Integer totalNumberOfGenes = Result.possibleNumberOfGenes(d, gene);
			
			int tempHealth =0;
			ArrayList<Integer> healthList = map.get(gene);
			for(Integer healthItr: healthList) {
				tempHealth+= (totalNumberOfGenes*healthItr);
			}
			healthReturn+= tempHealth;
		}
		
		
		

		return healthReturn;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//		int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//		List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList());
//
//		List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//				.map(Integer::parseInt).collect(toList());
//
//		int s = Integer.parseInt(bufferedReader.readLine().trim());
//
//		IntStream.range(0, s).forEach(sItr -> {
//			try {
//				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//				int first = Integer.parseInt(firstMultipleInput[0]);
//
//				int last = Integer.parseInt(firstMultipleInput[1]);
//
//				String d = firstMultipleInput[2];
//			} catch (IOException ex) {
//				throw new RuntimeException(ex);
//			}
//		});
//
//		bufferedReader.close();
		
		System.out.println(Result.possibleNumberOfGenes("aaaaa", "aaa"));
	}
}
