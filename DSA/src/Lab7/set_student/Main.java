package Lab7.set_student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        MyWordCount wordCounter = new MyWordCount("data/fit.txt");
        System.out.println("--------------------------------------------------------------------------------------");
        // Test getWordCounts
        List<WordCount> wordCounts = wordCounter.getWordCounts();
        System.out.println("Word Counts:");
        for (WordCount wc : wordCounts) {
            System.out.println(wc);
        }
        // Test getUniqueWords
        Set<String> uniqueWords = wordCounter.getUniqueWords();
        System.out.println("\nUnique Words:");
        uniqueWords.forEach(System.out::println);

        // Test getDistinctWords
        Set<String> distinctWords = wordCounter.getDistinctWords();
        System.out.println("\nDistinct Words:");
        distinctWords.forEach(System.out::println);

        // Test printWordCounts
        Set<WordCount> sortedWordCounts = wordCounter.printWordCounts();
        System.out.println("\nPrint Word Counts (Ascending Order):");
        sortedWordCounts.forEach(wc -> System.out.println(wc.getWord() + " - " + wc.getCount()));

        // Test exportWordCountsByOccurrence
        Set<WordCount> sortedWordCountsByOccurrence = wordCounter.exportWordCountsByOccurence();
        System.out.println("\nExport Word Counts by Occurrence (Descending Order):");
        sortedWordCountsByOccurrence.forEach(wc -> System.out.println(wc.getWord() + " - " + wc.getCount()));

        // Test filterWords
        String pattern = "A";
        Set<String> filteredWords = wordCounter.filterWords(pattern);
        System.out.println("\nFiltered Words (Removed Words Starting with '" + pattern + "'): ");
        filteredWords.forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------------------------");
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        // Testing remove method
        Predicate<Integer> evenPredicate = new Even();
        evenPredicate.test(2);
        MyPredicates.remove(numbers, evenPredicate);
        System.out.println("After removing even numbers: " + numbers); // Should print [1, 3, 5]

        // Reset numbers
        numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // Testing retain method
        MyPredicates.retain(numbers, evenPredicate);
        System.out.println("After retaining even numbers: " + numbers); // Should print [2, 4, 6]

        // Reset numbers
        numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // Testing collect method
        Set<Integer> collectedNumbers = MyPredicates.collect(numbers, evenPredicate);
        System.out.println("Collected even numbers: " + collectedNumbers); // Should print [2, 4, 6]

        // Testing find method
        int index = MyPredicates.find(numbers, evenPredicate);
        if (index != -1) {
            System.out.println("Index of the first even number: " + index); // Should print 1
        } else {
            System.out.println("No even number found.");
        }

    }
}
