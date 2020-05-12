import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParseMovie extends DefaultHandler{

    List<BaseMv> store_mv;
    private String tempVal;
    private BaseMv temp_mv;
    private String director_name;
    private List<String> all_genre;

    public ParseMovie() {
        store_mv = new ArrayList<BaseMv>();
    }

    public void runExample() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        parseDocument();
//        printData();
    }

    private void parseDocument() {

        //get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {

            //get a new instance of parser
            javax.xml.parsers.SAXParser sp = spf.newSAXParser();

            //parse the file and also register this class for call backs
            sp.parse("mains243.xml", this);

        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }


    private void printData() {

        System.out.println("No of Actor '" + store_mv.size() + "'.");

        Iterator<BaseMv> it = store_mv.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    //Event Handlers
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //reset
        tempVal = "";
        if (qName.equalsIgnoreCase("film")) {
            //create a new instance of employee
            all_genre = new ArrayList<String>();
            temp_mv = new BaseMv();
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("dirname")){
            director_name = tempVal;
        }
        else if (qName.equalsIgnoreCase("film")) {
            //add it to the list
            temp_mv.setDirectorName(director_name);
            if (all_genre.size() != 0){
                temp_mv.setGenre(all_genre);
                store_mv.add(temp_mv);
            }
        } else if (qName.equalsIgnoreCase("t")) {
            if(tempVal.contains(",")){
                temp_mv.setTitle(tempVal.split(",")[0]);
            }
            else{
                temp_mv.setTitle(tempVal);
            }

        } else if (qName.equalsIgnoreCase("year")) {
            try{
                temp_mv.setYear(Integer.parseInt(tempVal));
            }
            catch (Exception e){
            }

        } else if (qName.equalsIgnoreCase("cat")) {
            all_genre.add(tempVal);
        }
    }

}
