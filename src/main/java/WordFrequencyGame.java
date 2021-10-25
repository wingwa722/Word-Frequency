import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public static final String FREQUENCY_ONE = " 1";
    public static final String SPACE_PATTERN = "\\s+";
    public static final String DELIMITER = "\n";

    public String getResult(String sentence) {

        if (sentence.split(SPACE_PATTERN).length == 1) {
            return sentence + FREQUENCY_ONE;
        } else {

            try {
                //split the input string with 1 to n pieces of spaces

                List<Word> wordList = countWordFrequency(sentence);

                wordList.sort((word1, word2) -> word2.getWordCount() - word1.getWordCount());

                StringJoiner joiner = new StringJoiner(DELIMITER);

                for (Word word : wordList) {
                    String s = word.getWord() + " " + word.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }

    private List<Word> countWordFrequency(String sentence) {

        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<String>distinctWords = words.stream().distinct().collect(Collectors.toList());

        List<Word> wordList = new ArrayList<>();
        distinctWords.forEach(distinctWord -> {
            int count = (int) words.stream().filter(word -> word.equals(distinctWord)).count();
            Word word = new Word(distinctWord, count);
            wordList.add(word);
        });
        return wordList;
        }



    private Map<String, List<Word>> getListMap(List<Word> wordList) {
        Map<String, List<Word>> map = new HashMap<>();
        for (Word word : wordList) {
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(word.getWord())) {
                ArrayList arr = new ArrayList<>();
                arr.add(word);
                map.put(word.getWord(), arr);
            } else {
                map.get(word.getWord()).add(word);
            }
        }


        return map;
    }


}
