package app;

import model.Sentence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.*;


public class Parser {
    public static void main(String[] args){


        String fullSentence = "Mary had a little lamb.Peter called for the wolf , and Aesop came . Cinderella likes shoes..";

        List<String> listOne = getWordsList(0, fullSentence);
        Sentence sentence = new Sentence();
        List<Sentence> sentenceList = new ArrayList<>();
        sentence.setWords(listOne);

        List<String> listTwo = getWordsList(1, fullSentence);
        Sentence sentence1 = new Sentence();
        sentence1.setWords(listTwo);

        List<String> listTree = getWordsList(2, fullSentence);
        Sentence sentence2 = new Sentence();
        sentence2.setWords(listTree);

        sentenceList.add(sentence);
        sentenceList.add(sentence1);
        sentenceList.add(sentence2);
        System.out.println(sentenceList.get(1).getWords());
     ParseToXML(sentenceList);

    }

        public static List<String> getWordsList ( int numberOfSentence, String fullSentence){
            String[] inParts = fullSentence.split("\\.");
            String part = inParts[numberOfSentence];
            String[] arrayWithWords = part.split(" ");
            List<String> listWithWords = Arrays.stream(arrayWithWords).toList();

            return listWithWords;
        }


        public static void ParseToXML (List<Sentence> sentenceList){
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Sentence.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                File fileXML = new File("src\\parse.xml");
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(sentenceList, fileXML);
            } catch (JAXBException e) {
                e.printStackTrace();
            }


        }

    }


