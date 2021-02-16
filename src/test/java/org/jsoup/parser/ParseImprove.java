package org.jsoup.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseImprove {

    // ParseErrorList improve getMaxSize() ParseErrorList()
    @Test
    public void parseErrorListTest() {
        ParseErrorList testList = new ParseErrorList(16,3);
        ParseErrorList copyList = new ParseErrorList(testList);
        //Assert
        assertEquals(3,copyList.getMaxSize());
    }

    // parserTest improve setTreeBuilder() isTrackErrors() isContentForTagData()
    @Test
    public void parserTest() {
        TreeBuilder treeBuilder = new HtmlTreeBuilder();
        Parser testParser = new Parser(treeBuilder);
        TreeBuilder testTreeBuilder = new HtmlTreeBuilder();
        //Parser copyParser = new Parser(testParser);
        testParser.setTreeBuilder(testTreeBuilder);
        //Assert
        assertEquals(false,testParser.isTrackErrors());
        assertEquals(false,testParser.isContentForTagData("123"));
    }

    @Test
    public void parserTest2() {
        TreeBuilder treeBuilder = new HtmlTreeBuilder();
        Parser testParser = new Parser(treeBuilder);
        //Assert
        assertEquals(false,testParser.isContentForTagData("123"));
    }

    // TokenQueueTest improve peek() addFirst() matchesCS() matchesAny() advance() consumeTagName()
    @Test
    public void TokenQueueTest() {
        TokenQueue testTokenQueue =  new TokenQueue("abcdefg");
        //Assert
        assertEquals('a',testTokenQueue.peek());
        testTokenQueue.addFirst('z');
        //Assert
        assertEquals('z',testTokenQueue.peek());
    }

    @Test
    public void TokenQueueTest2() {
        TokenQueue testTokenQueue =  new TokenQueue("abcdefg");
        assertEquals(false, testTokenQueue.matchesCS("asc"));
        assertEquals(true, testTokenQueue.matchesAny('a'));
        assertEquals(false, testTokenQueue.matchesStartTag());

    }

    @Test
    public void TokenQueueTest3() {
        TokenQueue testTokenQueue =  new TokenQueue("abcdefg");
        testTokenQueue.advance();
        assertEquals("bcdefg",testTokenQueue.chompTo("qwe"));
        testTokenQueue.consumeTagName();
    }

}
