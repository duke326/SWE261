package org.jsoup.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLParserTest {

    public static final String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
            "\n" +
            "<students>\n" +
            "\t<student number=\"0001\">\n" +
            "\t\t<name>tom</name>\n" +
            "\t\t<age>18</age>\n" +
            "\t\t<sex>male</sex>\n" +
            "\t</student>\n" +
            "\t<student number=\"0002\">\n" +
            "\t\t<name>jack</name>\n" +
            "\t\t<age>18</age>\n" +
            "\t\t<sex>female</sex>\n" +
            "\t</student>\n" + "</students>";

    @Test
    public void parsesDocumentSize() {
        Document doc = Jsoup.parse(xml);
        Elements name = doc.getElementsByTag( "name" );
        assertEquals(2, name.size());
    }

    @Test
    public void parsesSimpleDocumentElement() {
        Document doc = Jsoup.parse(xml);
        Elements name = doc.getElementsByTag( "name" );
        Element element = name.get( 0 );
        String text = element.text();
        assertEquals("tom", text);
    }

    @Test
    public void parsesNullExistDocumentElement() {
        Document doc = Jsoup.parse(xml);
        Elements id = doc.getElementsByTag( "id" );
        assertEquals(0, id.size());
    }


    @Test
    public void parsesSimpleDocumentElementAttr() {
        Document doc = Jsoup.parse(xml);
        Elements name=doc.getElementsByTag("student");
        Element element = name.get( 0 );
        //System.out.println(element.text());
        String studentNumber=element.attr("number");
        //System.out.println(studentNumber);
        assertEquals("0001", studentNumber);
    }

}
