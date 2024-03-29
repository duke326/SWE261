package org.jsoup.swe261;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class XMLParserTest {
    static final int maxBufferLen = 1024 * 32; // visible for testing
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

    @Test
    public void handleSuperLargeTagNames() {
        // unlikely, but valid. so who knows.

        StringBuilder sb = new StringBuilder(maxBufferLen);
        do {
            sb.append("LargeTagName");
        } while (sb.length() < maxBufferLen);
        String tag = sb.toString();
        String xml = "<" + tag + ">One</" + tag + ">";
        Document doc = Parser.xmlParser().settings(ParseSettings.preserveCase).parseInput(xml, "");
        Elements els = doc.select(tag);
        assertEquals(1, els.size());
        Element el = els.first();
        assertNotNull(el);
        assertEquals("One", el.text());
        assertEquals(tag, el.tagName());
    }

}
