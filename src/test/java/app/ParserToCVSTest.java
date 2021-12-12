package app;

import model.SentenceCSV;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserToCVSTest {

    @Test
    void main() {
        //given
        SentenceCSV sentenceCSV = new SentenceCSV();
        List<String> stringList = new ArrayList<>();
        stringList.add("test1");
        stringList.add("test2");

        //when
        sentenceCSV.setWord(stringList);

        //then
        Assertions.assertNotNull(sentenceCSV , "Object is Null");

    }

}