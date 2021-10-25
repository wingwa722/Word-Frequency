//rename: Input -> Word
public class Word {
    private String word;
    private int count;
    //rename: value -> word
    public Word(String word, int count){
        this.word =word;
        this.count =count;
    }


    public String getWord() {
        return this.word;
    }

    public int getWordCount() {
        return this.count;
    }


}
