package app;

import model.Sentence;
import model.SentenceCSV;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void main() {
        //given
        Sentence sentence = new Sentence();
        List<String> stringList = new ArrayList<>();
        stringList.add("test1");
        stringList.add("test2");

        //when
        sentence.setWords(stringList);

        //then
        Assertions.assertNotNull(sentence, "Object is Null");

    }
}
