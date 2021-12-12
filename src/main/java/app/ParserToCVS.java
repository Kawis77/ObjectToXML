package app;

import model.SentenceCSV;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserToCVS {
    public static void main(String[] args) {
        String completeSentence = "Mary had a little lamb.Peter called for the wolf , and Aesop came . Cinderella likes shoes..";
        ArrayList<SentenceCSV> sentenceList = new ArrayList<SentenceCSV>();
        List<String> listOfWords = toList(completeSentence);
        sentenceList.add(new SentenceCSV(listOfWords));
        writeToCSV(sentenceList);
    }

    private static final String CSV_SEPARATOR = ",";

    public static List<String> toList(String sentence) {
        String[] arrayWithWords = sentence.split(" ");
        List<String> words = Arrays.stream(arrayWithWords).toList();
        return words;
    }


    public static void writeToCSV(ArrayList<SentenceCSV> sentencesList) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("parseCSV.csv"), "UTF-8"));
            for (SentenceCSV sentenceCSV : sentencesList) {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(sentenceCSV.getWord().size() == 0 ? "" : sentenceCSV.getWord());
                oneLine.append(CSV_SEPARATOR);
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
}
