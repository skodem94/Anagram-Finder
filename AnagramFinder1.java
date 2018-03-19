

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class AnagramFinder1 {
	public static void main(String[] args) throws IOException {
		System.out.println(" Welcome to Anagram Finder version 1");
		System.out.println("-------------------------------");
		long startTime = System.currentTimeMillis();
		String fileName = args[0];
		FileReader reader = null;
		File file = new File(fileName);
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " not found");
			return;
		}
		BufferedReader br = new BufferedReader(reader);
		HashSet<String> set = new HashSet<String>();
		String line;
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (!"".equals(line))
				set.add(line.toLowerCase());
		}
		reader.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Dictionary loaded in " + (endTime - startTime) + "ms");
		@SuppressWarnings("resource")

		String word = new Scanner(System.in).nextLine().trim();
		startTime = System.currentTimeMillis();
		if (word != null && word.length() > 0) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (Character c : word.toCharArray()) {
				if (map.containsKey(c))
					map.put(c, map.get(c) + 1);
				else
					map.put(c, 1);
			}
			ArrayList<String> result = new ArrayList<String>();
			HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
			int count = 0;
			int tempcount = 0;
			boolean found = true;
			for (String dicword : set) {
				temp.putAll(map);
				count = temp.size();
				for (Character c : dicword.toCharArray()) {
					if (temp.containsKey(c)) {
						tempcount = temp.get(c);
						temp.put(c, tempcount - 1);
						if (tempcount == 1) {
							--count;
						} else if (tempcount == 0) {
							found = false;
							break;
						}
					} else {
						found = false;
						break;
					}
				}
				if (count == 0 && found)
					result.add(dicword);
				found = true;
				temp.clear();
			}
			endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			if (result.size() > 0) {
				System.out.println(result.size() + " Anagrams found for " + word + " in " + totalTime + " " + "ms");
				StringBuilder print = new StringBuilder();
				String prefix = "";
				for (String anagram : result) {
					print.append(prefix);
					prefix = ", ";
					print.append(anagram);
				}
				System.out.println(print);
			} else {
				System.out.println("No Anagrams found for " + word + " in " + totalTime + " " + "ms");
			}
		} else {
			System.out.println("Please enter a valid word..");
		}
	}
}
