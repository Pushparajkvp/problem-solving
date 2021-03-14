package dev.pushparaj.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WordCount {


	public static void count(String filePath) throws InterruptedException, IOException {
		File file = new File(filePath);

		//Using streams
		Map<String, Long> resultMap = Files.lines(file.toPath())
					.parallel()
					.map((x) -> x.split(" "))
					.flatMap(x -> Stream.of(x))
					.collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		for(Map.Entry<String, Long> entry :  resultMap.entrySet()) {
			System.out.println("key " + entry.getKey() + " count " + entry.getValue());
		}

		//Using iteration
		HashMap<String, Integer> frequency = new HashMap<>();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder stringBuilder = new StringBuilder();

		int read;
		while( (read = reader.read()) != -1) {
			char letter = (char) read;
			if(Character.isAlphabetic(letter)) {
				stringBuilder.append(letter);
			} else {
				if(stringBuilder.toString().equals("")) {
					continue;
				}

				String curr = stringBuilder.toString();
				if(frequency.containsKey(curr)) {
					frequency.put(curr, frequency.get(curr) + 1);
				} else {
					frequency.put(stringBuilder.toString(), 1);
				}

				stringBuilder = new StringBuilder();
			}
		}

		if(!stringBuilder.toString().equals("")) {
			String curr = stringBuilder.toString();
			if(frequency.containsKey(curr)) {
				frequency.put(curr, frequency.get(curr) + 1);
			} else {
				frequency.put(stringBuilder.toString(), 1);
			}
		}

		for(Map.Entry<String, Integer> entry :  frequency.entrySet()) {
			System.out.println("key " + entry.getKey() + " count " + entry.getValue());
		}
	}
}
