import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AnagramFinder2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		System.out.println(" Welcome to Anagram Finder version 2");
		System.out.println("-------------------------------");
		long startTime = System.currentTimeMillis();
		String tempStr = null;
		Set<String> set = null;
		char[] charArray = null;
		String line = null;
		String fileName = args[0];
		File file = new File(fileName);
		FileReader reader;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " not found");
			return;
		}
		BufferedReader br = new BufferedReader(reader);
		Map<String, Set<String>> anagrams = new HashMap<String, Set<String>>();
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (!"".equals(line)) {
				line = line.toLowerCase();
				charArray = line.toCharArray();
				Arrays.sort(charArray);
				tempStr = String.valueOf(charArray);
				if (anagrams.containsKey(tempStr)) {
					set = anagrams.get(tempStr);
					set.add(line);
				} else {
					set = new HashSet<String>();
					set.add(line);
					anagrams.put(tempStr, set);
				}
			}
		}
		set.clear();
		reader.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Dictionary loaded in " + (endTime - startTime) + "ms");
		Scanner scanner = new Scanner(System.in);
		String word = null;
		while ((word = scanner.nextLine().trim()) != null) {
			if ("exit".equals(word))
				break;
			startTime = System.currentTimeMillis();
			if (word != null && word.length() > 0) {
				word = word.toLowerCase();
				charArray = word.toCharArray();
				Arrays.sort(charArray);
				tempStr = String.valueOf(charArray);
				if (anagrams.containsKey(tempStr)) {
					set.addAll(anagrams.get(tempStr));
				}
				endTime = System.currentTimeMillis();
				if (set.size() > 0) {
					System.out.println(
							set.size() + " Anagrams found for " + word + " in " + (endTime - startTime) + "ms");
					StringBuilder print = new StringBuilder();
					String prefix = "";
					for (String anagram : set) {
						print.append(prefix);
						prefix = ", ";
						print.append(anagram);
					}
					System.out.println(print);
					set.clear();
				} else {
					endTime = System.currentTimeMillis();
					System.out.println("No Anagrams found for " + word + " in " + (endTime - startTime) + "ms");
				}
			} else {
				System.out.println("Please enter a valid word..");
			}
		}
	}
}
