import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaLib {

    public static List<String> getWords(String inputFileName) {
        List<String> words = new ArrayList<String>();
        In in = new In(inputFileName);
        while (!in.isEmpty()) {
            String nextWord = in.readString();
            words.add(nextWord);
        }
        return words;
    }

    public static Set<String> countUniqueWords(List<String> words) {
        Set<String> lst = new HashSet<>();
        for (String s : words) {
            lst.add(s);
        }
        return lst;
    }

    public static Map<String,Integer> collectWordCount(List<String> words,List<String> targets) {
        Map<String,Integer> counts = new HashMap<>();
        for (String t:targets) {
            counts.put(t,0);
        }

        for (String word: words){
            if (counts.containsKey(word)) {
                counts.put(word,counts.get(word)+1);
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        List<String> w = getWords("libraryOfBabylon.txt");
        System.out.println(w.size());

        Set<String> wordSet = new HashSet<>();

        System.out.println(countUniqueWords(w).size());

        List<String> targets = new ArrayList<>();
        targets.add("lottery");
        targets.add("the");
        targets.add("babylon");
        System.out.println(collectWordCount(w,targets));
    }
}