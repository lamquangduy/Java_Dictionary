package dictionary;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ReadXmlDomParser {
    private static String FILENAME = "Anh_Viet.xml";
    
    public static void setFileName(String filename) {
        FILENAME = filename;
    }
    
    public static List<Word> readXmlFile() {

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        List<Word> words = new ArrayList<>();

        try {

            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            InputStream inputStream= new FileInputStream(new File(FILENAME));
            Document doc = db.parse(inputStream, "UTF-8");

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            //System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            //System.out.println("------");

            // get <record>
            NodeList list = doc.getElementsByTagName("record");

            // list.getLength() = number of tag "dictionary"
            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                //avoid text and comment node
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get text
                    String word = element.getElementsByTagName("word").item(0).getTextContent();
                    String meaning = element.getElementsByTagName("meaning").item(0).getTextContent();

                    words.add(new Word(word, meaning));
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    // create a class to store the word and meaning
    public static class Word {
        private String word;
        private String meaning;

        public Word(String word, String meaning) {
            this.word = word;
            this.meaning = meaning;
        }

        public String getWord() {
            return word;
        }

        public String getMeaning() {
            return meaning;
        }
        
        public void setWord(String Word){
            this.word = Word;
        }
        
        public void setMeaning(String Meaning){
            this.meaning = Meaning;
        }
    }
    
    public static void addRecord(String word, String meaning) throws ParserConfigurationException, TransformerException {
        File file = new File(FILENAME);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc;
        Element root;
        if (file.exists()) {
            try {
                doc = dBuilder.parse(file);
                root = doc.getDocumentElement();
            } catch (IOException | SAXException e) {
                return;
            }
        } else {
            doc = dBuilder.newDocument();
            root = doc.createElement("dictionary");
            doc.appendChild(root);
        }
        
        Element record = doc.createElement("record");
        root.appendChild(record);
        
        Element wordElement = doc.createElement("word");
        wordElement.appendChild(doc.createTextNode(word));
        record.appendChild(wordElement);
        
        Element meaningElement = doc.createElement("meaning");
        meaningElement.appendChild(doc.createTextNode(meaning));
        record.appendChild(meaningElement);
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
        System.out.println("New word added successfully.");
    }          
    
    public static void saveDictionary(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILENAME));
        transformer.transform(source, result);
        System.out.println("Dictionary saved successfully.");
    }

    public static void removeRecord(String word) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        File file = new File(FILENAME);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("record");
        boolean removed = false;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String recordWord = element.getElementsByTagName("word").item(0).getTextContent();
                if (recordWord.equals(word)) {
                    element.getParentNode().removeChild(element);
                    removed = true;
                }
            }
        }
        if (removed) {
            saveDictionary(doc);
            System.out.println("Word \"" + word + "\" has been removed successfully.");
        } else {
            System.out.println("Word \"" + word + "\" not found.");
        }
    }
    
    public static void clearXmlFile() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        Element root = doc.createElement("dictionary");
        doc.appendChild(root);
        saveDictionary(doc);
    }

}

