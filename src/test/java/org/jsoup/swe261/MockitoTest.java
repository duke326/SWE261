package org.jsoup.swe261;

import org.jsoup.Jsoup;
import org.junit.Before;
import org.junit.Test;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockitoTest {
    private Element ele;
    private Document doc;

    @Before
    public void setup() {
        ele = mock(Element.class);
        doc = new Document("<html></html",ele);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mockitoTest1(){
        String exp ="<html>\n" +
                " <head></head>\n" +
                " <body>\n" +
                "  123 131\n" +
                "  <title>First!</title>\n" +
                "  <p>First post! <img src=\"foo.png\"></p>\n" +
                "  <p>Second post! <img src=\"foo2.png\"></p>\n" +
                " </body>\n" +
                "</html>";
        when(ele.childElementsList()).thenReturn(getEleList());
        when(ele.htmlel()).thenReturn(getEle());
        System.out.println(doc.normaliseDocumentNodes());
        assertThat(doc.normaliseDocumentNodes().toString()).isEqualTo(exp);
        verify(ele, times(4)).childElementsList();
        verify(ele, times(4)).htmlel();
    }

    public List<Element> getEleList(){
        String html = "<html><head>123 131</head><head><title>First!</title></head><body><p>First post! <img src=\"foo.png\" /></p><p>Second post! <img src=\"foo2.png\" /></p></body></html>";
        Document doc = Jsoup.parse(html);
        return doc.childElementsList().get(0).childElementsList();
    }

    public Element getEle(){
        String html = "<html><head>123 131</head><head><title>First!</title></head><body><p>First post! <img src=\"foo.png\" /></p><p>Second post! <img src=\"foo2.png\" /></p></body></html>";
        Document doc = Jsoup.parse(html);
        return doc.htmlEl();
    }

}
