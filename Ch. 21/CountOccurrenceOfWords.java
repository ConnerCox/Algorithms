import java.util.*;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new HashMap<>();

		String[] words = text.split("[\\s+\\p{P}]");
		//go through all the lowercase words
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			//as long as there are more words
			if (key.length() > 0) {
				//if the map does not contain the current word (key), add it to the map, with  (value) of one
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				//if the map already contains the current word, get the value from the existing key, add one, and put it back
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		//make the list to hold the word occurrences
		ArrayList<WordOccurrence> aList = new ArrayList<WordOccurrence>();
		
		//take every key and value form the map and put them into word occurrences, then add them to the array list
		map.forEach((k,v)->{
			WordOccurrence word = new WordOccurrence(k,v);
			aList.add(word);
		});
		
		//sort the list
		Collections.sort(aList);
		
//		// Display key and value for each entry
//		map.forEach((k, v) -> System.out.println(k + "\t" + v));
		
		aList.forEach(word->System.out.println(word.word + "\t" + word.count));
	}
}