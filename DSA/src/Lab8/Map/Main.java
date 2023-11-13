package Lab8.Map;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MyWordCountApp wordCountApp = new MyWordCountApp();
        System.out.println("wordCountApp:");
        // Load data from the file
        wordCountApp.loadData();

        // Count of unique tokens
        int uniqueTokens = wordCountApp.countUnique();
        System.out.println("\nNumber of Unique Tokens: " + uniqueTokens);

        // Print word counts
        System.out.println("\nWord Counts:");
        wordCountApp.printWordCounts();

        // Print word counts in alphabetical order
        System.out.println("\nWord Counts in Alphabetical Order:");
        wordCountApp.printWordCountsAlphabet();
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        System.out.println("textAnalyzer:");
        // Load the text file
        textAnalyzer.load("data/short.txt");

        // Display words with positions
        System.out.println("Displaying Words with Positions:");
        textAnalyzer.displayWords();

        // Display text content
        System.out.println("\nDisplaying Text Content:");
        textAnalyzer.displayText();

        // Find the most frequent word
        String mostFrequent = textAnalyzer.mostFrequentWord();
        System.out.println("\nMost Frequent Word: " + mostFrequent);
    }
}
