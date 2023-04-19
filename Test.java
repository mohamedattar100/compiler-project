import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {

        String inputFile = "input.java";
        FileInputStream inputStream = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        TokenStreamRewriter rewriter = new TokenStreamRewriter(tokens);
        walker.walk(new addprakets(rewriter), tree);

        File output = new File("output1.java");
        output.createNewFile();
        FileWriter w = new FileWriter("output1.java");
        w.write(rewriter.getText());
        w.close();

        //add prakets
        inputFile = "output1.java";
        inputStream = new FileInputStream(inputFile);
        input = new ANTLRInputStream(inputStream);
        lexer = new JavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new JavaParser(tokens);
        tree = parser.compilationUnit();
        walker = new ParseTreeWalker();

        rewriter = new TokenStreamRewriter(tokens);
        //convert edit.java to out put.java that will produce text file having blocks visited
        walker.walk(new listenerextend(rewriter), tree);
         output = new File("output2.java");
        output.createNewFile();
        FileWriter wedit = new FileWriter("output2.java");
        wedit.write(rewriter.getText());
        wedit.close();

//for run code
       Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("java output2.java");
        try {
            pr.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    //for HTML
        //html file part

        inputFile = "output1.java";
        inputStream = new FileInputStream(inputFile);
        input = new ANTLRInputStream(inputStream);
        lexer = new JavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new JavaParser(tokens);
        tree = parser.compilationUnit();
        walker = new ParseTreeWalker();
        rewriter = new TokenStreamRewriter(tokens);

        for (int i = 0; i < tokens.getTokens().size(); i++) {
            Token token = tokens.getTokens().get(i);
            if (token.getText().equals( "<")) {
                rewriter.replace(token, "&lt;");
            } else if (token.getText().equals(">")) {
                rewriter.replace(token, "&gt;");
            }
        }
        walker.walk(new listnerhtml(rewriter), tree);
        File html = new File("output.html");
        html.createNewFile();
        FileWriter w2 = new FileWriter("output.html");
        w2.write(rewriter.getText());
        w2.close();
    }
}
