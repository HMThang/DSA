package Lab8.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyWordCountApp {
    // public static final String fileName = "data/hamlet.txt";
    public static final String fileName = "data/fit.txt";
    // <word, its occurences>
    private Map<String, Integer> map = new HashMap<String, Integer>();

    // Load data from fileName into the above map (containing <word, its occurences>)
    // using the guide given in TestReadFile.java
    public void loadData() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNext()) {
            String word = sc.next();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        sc.close();
        System.out.println(map);
    }

    // Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
    public int countUnique() {
        return map.size();
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt)
    // In this method, we do not consider the order of tokens.
    public void printWordCounts() throws FileNotFoundException {
        System.out.println(map);
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt) according to ascending order of tokens
    // Example: An - 3, Bug - 10, ...
    public void printWordCountsAlphabet() {
        TreeMap<String, Integer> tree = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        tree.putAll(map);
        System.out.println(tree);
    }
}
