package org.jsoup.swe261;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestableDesign {

    @Test
    public void childListTest(){
        String html = "<html><head><title>First!</title></head><body><p>First post! <img src=\"foo.png\" /></p><p>Second post! <img src=\"foo2.png\" /></p></body></html>";
        Document doc = Jsoup.parse(html);
        Element ele = doc.body();
        System.out.println(ele.childElementsV2().get(0));
        System.out.println(ele.childElementsV2().get(1));
        String exp = "<p>First post! <img src=\"foo.png\"></p>";
        String exp2 = "<p>Second post! <img src=\"foo2.png\"></p>";
        assertEquals(2,ele.childElementsV2().size());
        assertEquals(exp,ele.childElementsV2().get(0).toString());
        assertEquals(exp2,ele.childElementsV2().get(1).toString());
    }
}
