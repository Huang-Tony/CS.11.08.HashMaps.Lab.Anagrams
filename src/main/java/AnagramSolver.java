import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramSolver {

    private AnagramSolver() {};

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename) {
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            try (Scanner scanner = new Scanner(new File(filename))) {
                while (scanner.hasNextLine()) {
                    String word = scanner.nextLine();
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    String key = new String(chars);

                    map.putIfAbsent(key, new ArrayList<>());
                    map.get(key).add(word);
                }
            } catch (FileNotFoundException e) {
                System.out.println("there was a error reading the file");
            }
            return map;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> maxList = new ArrayList<>();
        for (ArrayList<String> list : anagrams.values()) {
            if (list.size() > maxList.size()) {
                maxList = list;
            }
        }
        return maxList;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        for (String key : anagrams.keySet()) {
            ArrayList<String> words = anagrams.get(key);
            System.out.println(key + ": " + words);
        }
    }

}
