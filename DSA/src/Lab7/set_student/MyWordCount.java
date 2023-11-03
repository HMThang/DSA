package Lab7.set_student;

import java.io.FileNotFoundException;
import java.util.*;

public class MyWordCount {
    //  public static final String fileName = "data/hamlet.txt";
    public static final String fileName = "data/fit.txt";

    private List<String> words = new ArrayList<>();

    public MyWordCount(String s) {
        try {
            this.words.addAll(Utils.loadWords(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt)
    // In this method, we do not consider the order of tokens.
    public List<WordCount> getWordCounts() {
        List<WordCount> result = new ArrayList<>();
        for (String w : words) {
            WordCount word = new WordCount(w, countWord(w));
            if (!result.contains(word)) {
                result.add(word);
            }

        }
        return result;
    }

    public int countWord(String word) {
        int count = 0;
        for (String w : words) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }

    // Returns the words that their appearance are 1, do not consider duplidated
    // words
    public Set<String> getUniqueWords() {
        List<WordCount> temp = new ArrayList<>();
        for (String w : words) {
            temp.add(new WordCount(w, countWord(w)));
        }
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < temp.size(); i++) {
            WordCount w = temp.get(i);
            if (w.getCount() == 1) {
                set.add(temp.get(i).getWord());
            }
        }
        return set;
    }

    // Returns the words in the text file, duplicated words appear once in the
    // result
    public Set<String> getDistinctWords() {
        return new TreeSet<>(words);
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt) according ascending order of tokens
    // Example: An - 3, Bug - 10, ...
    public Set<WordCount> printWordCounts() {
        // Sort by ascending order of word
        List<WordCount> wordCounts = getWordCounts();
        Set<WordCount> sortedWordCounts = new TreeSet<>(new Comparator<WordCount>() {
            @Override
            public int compare(WordCount o1, WordCount o2) {
                return o1.getWord().compareTo(o2.getWord());
            }
        });
        sortedWordCounts.addAll(wordCounts);
        return sortedWordCounts;
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt) according descending order of occurences
    // Example: Bug - 10, An - 3, Nam - 2.
    public Set<WordCount> exportWordCountsByOccurence() {
        // Sort by ascending order of word counts
        List<WordCount> wordCounts = getWordCounts();
        wordCounts.sort(new Comparator<WordCount>() {
            @Override
            public int compare(WordCount o1, WordCount o2) {
                return Integer.compare(o2.getCount(), o1.getCount());
            }
        });
        return new LinkedHashSet<>(wordCounts);
    }

    // delete words begining with the given pattern (i.e., delete words begin with
    // 'A' letter
    public Set<String> filterWords(String pattern) {
        Set<String> result = new TreeSet<>();
        for (String w : words) {
            if (!w.startsWith(pattern)) {
                result.add(w);
            }
        }
        return result;
    }
}
