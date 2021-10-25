//rename: Input -> Word
public class Input {
    private String value;
    private int count;
    //rename: value -> word
    public Input(String w, int i){
        this.value =w;
        this.count =i;
    }


    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }


}
