package edu.macalester.comp124.wordcounter;

/**
 * A counter that keeps track of counts for all words
 * 
 * @author shilad
 *
 */
public class AllWordsCounter {

    public static final int MAX_WORDS = 10000; //declaration

	// TODO: initialize instance variable to hold MAX_WORDS objects
    SingleWordCounter counters[] = new SingleWordCounter[MAX_WORDS]; //make an array, size of 10,000

    public int getNumWords() { //distinct words
        int numWords = 0;
        for (int i = 0; i < counters.length; i ++)
        {
            if (counters[i] != null)
                numWords ++;
        }
        return numWords;
    }
	
	/**
	 * Increment the count for the specified word.  Remember that this may
     * be the first time the word counter has seen this particular word.
	 * 
	 * @param word
	 */
	public void count(String word) {
        int n = getNumWords();
        for (int i = 0; i < n; i++) {
            if(counters[i].wordMatches(word))
            {
                counters[i].incrementCount();
                return;
            }
        }
        counters[n] = new SingleWordCounter(word);
        counters[n].incrementCount();
	}
	
	/**
	 * Return the count for the particular word.  Remember that the
	 * word may not have been seen before.
	 * @param word
	 * @return
	 */
	public int getCount(String word) {
        int n = getNumWords();
        for (int i = 0; i < n; i++) {
            if(counters[i].wordMatches(word))
            {
                return counters[i].getCount();
            }
        }
        return 0;
	}
	
	/**
	 * @return The an array of all words that have been counted
	 * (just the words, not the values).
	 */
	public String []  getAllWords() {
        int n = getNumWords();
        String words[] = new String[n];
        for (int i = 0; i < n; i++ )
        {
            words[i] = counters[i].getWord();
        }
        return words;
	}
}
