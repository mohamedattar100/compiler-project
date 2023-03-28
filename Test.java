import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {
        int[] Array;
        String inputFile = "input.java";
        FileInputStream inputStream = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        TokenStreamRewriter rewriter = new TokenStreamRewriter(tokens);
        walker.walk(new listenerextend(rewriter), tree);

        File output = new File("output.java");
        output.createNewFile();
        FileWriter w = new FileWriter("output.java");
        w.write(rewriter.getText());
        w.close();
    }
}
