package org.jsoup.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLParserTest {

    @Test
    public void parsesSimpleDocument() {
        //String html = "<html><head><title>First!</title></head><body><p>First post! <img src=\"foo.png\" /></p></body></html>";

        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
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
        Document doc = Jsoup.parse(xml);
        // need a better way to verify these:

        Elements name = doc.getElementsByTag( "name" );
        //Element p = doc.body().child(0);


        //4.获取第一个name的Element对象
        Element element = name.get( 0 );
        //5.获取数据
        String text = element.text();
        System.out.println(text);
        assertEquals("tom", text);
//        Element p = doc.body().child(0);
//        assertEquals("p", p.tagName());
//        Element img = p.child(0);
//        assertEquals("foo.png", img.attr("src"));
//        assertEquals("img", img.tagName());
    }

}
