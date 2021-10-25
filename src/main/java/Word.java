//rename: Input -> Word
public class Word {
    private String value;
    private int count;
    //rename: value -> word
    public Word(String word, int count){
        this.value =word;
        this.count =count;
    }


    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }


}
