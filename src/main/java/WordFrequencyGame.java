import java.util.*;

public class WordFrequencyGame {
    public String getResult(String sentence){

        if (sentence.split("\\s+").length==1) {
            return sentence + " 1";
        } else {

            try {
                //split the input string with 1 to n pieces of spaces
                String[] seperateWord = sentence.split("\\s+");

                List<Word> wordList = new ArrayList<>();
                for (String s : seperateWord) {
                    Word word = new Word(s, 1);
                    wordList.add(word);
                }

                //get the map for the next step of sizing the same word
                Map<String, List<Word>> map =getListMap(wordList);

                List<Word> list = new ArrayList<>();
                for (Map.Entry<String, List<Word>> entry : map.entrySet()){
                    Word word = new Word(entry.getKey(), entry.getValue().size());
                    list.add(word);
                }
                wordList = list;

                wordList.sort((word1, word2) -> word2.getWordCount() - word1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (Word word : wordList) {
                    String s = word.getValue() + " " +word.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }


    private Map<String,List<Word>> getListMap(List<Word> wordList) {
        Map<String, List<Word>> map = new HashMap<>();
        for (Word word : wordList){
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(word.getValue())){
                ArrayList arr = new ArrayList<>();
                arr.add(word);
                map.put(word.getValue(), arr);
            }

            else {
                map.get(word.getValue()).add(word);
            }
        }


        return map;
    }


}
