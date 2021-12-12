package model;

import java.util.List;

public class SentenceCSV {

    private List<String> word;

    public SentenceCSV() {
    }

    public SentenceCSV(List<String> word) {
        this.word = word;
    }

    public List<String> getWord() {
        return word;
    }

    public void setWord(List<String> word) {
        this.word = word;
    }
}
