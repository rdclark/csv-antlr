import org.testng.annotations.Test;
import org.antlr.runtime.*;

import java.io.*;
import java.util.List;

import com.sun.java_cup.internal.parser;

/**
 * Created by IntelliJ IDEA.
 * User: rdclark
 * Date: May 26, 2007
 * Time: 4:39:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class CSVTests {


    @Test
    public void testNewline() throws IOException, RecognitionException {
        CSVParser parser = createParser("\n");
        List<String> result = parser.line();
        assert result.isEmpty() : "Nothing to return";
    }

    @Test
    public void testCRLF() throws IOException, RecognitionException {
        CSVParser parser = createParser("\r\n");
        List<String> result = parser.line();
        assert result.isEmpty() : "Nothing to return";
    }

    @Test
    public void testSingleWord() throws IOException, RecognitionException {
        String result = parseField("Red");
        assert result.equals("Red") : "Expected Red, but found " + result;
    }

    @Test
    public void testQuotedString() throws IOException, RecognitionException {
        String result = parseField("\"Red, White, and Blue\"");
        assert result.equals("Red, White, and Blue") : "Expected <<Red, White, and Blue>>, but found <<" + result + ">>";
    }

    @Test
    public void testQuoteEscaping() throws IOException, RecognitionException {
        String result = parseField("\"Before\"\"After\"");
        assert result.equals("Before\"After") : "Expected <<Before\"After>>, but found <<" + result + ">>";
    }

    @Test
    public void testMultipleWords() throws IOException, RecognitionException {
        CSVParser parser = createParser("Red,Green,,Blue\n");
        List<String> result = parser.line();
        assert result.size() == 4 : "Expected 4 items";
        assert result.get(0).equals("Red") : "Expected Red";
        assert result.get(1).equals("Green") : "Expected Green";
        assert result.get(2).equals("") : "Expected empty";
        assert result.get(3).equals("Blue") : "Expected Blue";
    }

    @Test
    public void testSpaceRemoval() throws IOException, RecognitionException {
        CSVLexer lexer = createLexer("Red  ,   Green, ,Blue\n");
        CSVParser parser = createParser(lexer);
        List<String> result = parser.line();
        assert result.size() == 4 : "Expected 4 items";
        assert result.get(0).equals("Red") : "Expected Red";
        assert result.get(1).equals("Green") : "Expected Green";
        assert result.get(2).equals("") : "Expected empty";
        assert result.get(3).equals("Blue") : "Expected Blue";
        // Now make sure we didn't have any lexing errors, which were failing silently earlier
        // The parser drives the lexer, so check for exceptions after
        // parsing.
        List<RecognitionException> lexerExceptions = lexer.getExceptions();
        assert lexerExceptions.isEmpty() : "Lexer threw exceptions -- see output";

    }

    private CSVParser createParser(CSVLexer lexer) throws IOException {
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CSVParser parser = new CSVParser(tokens);
        return parser;
    }

    private CSVParser createParser(String testString) throws IOException {
        CSVLexer lexer = createLexer(testString);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CSVParser parser = new CSVParser(tokens);
        return parser;
    }

    private CSVLexer createLexer(String testString) throws IOException {
        CharStream stream = new ANTLRStringStream(testString);
        CSVLexer lexer = new CSVLexer(stream);
        return lexer;
    }

    private String parseField(String testString) throws IOException, RecognitionException {
        CSVParser parser = createParser(testString + "\n");
        List<String> result = parser.line();
        return result.get(0);
    }

}

