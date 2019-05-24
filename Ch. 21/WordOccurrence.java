class WordOccurrence implements Comparable<WordOccurrence> {
	//variables
	String word;
	int count;
	
	//constructor
	public WordOccurrence(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	@Override
	public int compareTo(WordOccurrence o) {
		if(this.count > o.count) {
			return 1;
		}
		else if(this.count < o.count) {
			return -1;
		}
		return 0;
	}
	@Override
	public String toString() {
		return "test";
	}
	
}
