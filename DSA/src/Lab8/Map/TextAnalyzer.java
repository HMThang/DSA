package Lab8.Map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
    // <word, its positions>
    private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

    // load words in the text file given by fileName and store into map by using add
    // method in Task 2.1.
    // Using BufferedReader reffered in file TextFileUtils.java
    public void load(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int position = 1; // Initialize position counter

            while ((line = reader.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line, " ");

                while (tokens.hasMoreTokens()) {
                    String word = tokens.nextToken();
                    if (!tokens.hasMoreTokens()) {
                        add(word, -position);
                    } else {
                        add(word, position);
                    }
                    position++;
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // In the following method, if the word is not in the map, then adding that word
    // to the map containing the position of the word in the file. If the word is
    // already in the map, then its word position is added to the list of word
    // positions for this word.
    // Remember to negate the word position if the word is at the end of a line in
    // the text file

    public void add(String word, int position) {
        if (!map.containsKey(word)) {
            map.put(word, new ArrayList<>());
        }
        map.get(word).add(position);
    }

    // This method should display the words of the text file along with the
    // positions of each word, one word per line, in alphabetical order
    public void displayWords() {
        System.out.println("Word\tWord Position(s)");
        System.out.println("===========================");

        // Sort the map by keys (words)
        List<String> sortedWords = new ArrayList<>(map.keySet());
        Collections.sort(sortedWords);

        for (String word : sortedWords) {
            System.out.print(word + "\t");
            for (Integer position : map.get(word)) {
                System.out.print(position + ", ");
            }
            System.out.println();
        }
        
    }

    // This method will display the content of the text file stored in the map
    public void displayText() {
        System.out.println("Text File Content:");
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ":");
            for (Integer position : entry.getValue()) {
                System.out.print(position + ", ");
            }
            System.out.println();
        }
    }

    // This method will return the word that occurs most frequently in the text file
    public String mostFrequentWord() {
        String mostFreq = null;
        int maxFreq = 0;
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            int freq = entry.getValue().size();
            if (freq > maxFreq) {
                maxFreq = freq;
                mostFreq = entry.getKey();
            }
        }
        return mostFreq;
    }

}
