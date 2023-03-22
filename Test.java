import java.io.FileInputStream;
import java.io.FileWriter;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
    public class Test {
        public static void main(String[] args) throws Exception {
            String inputFile = "testin";
            FileInputStream in = new FileInputStream(inputFile);
            ANTLRInputStream input = new ANTLRInputStream(in);
            CompilerLexer lexer = new CompilerLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CompilerParser parser = new CompilerParser(tokens);
            ParseTree tree = parser.mainBlock(); // begin parsing at init rule
           // System.out.println (tree.toStringTree (parser)); // print LISP-style tree
            ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
            parseTreeWalker.walk(new listenerextend(), tree);
            FileWriter fileWriter = new FileWriter("result.txt");
          //  fileWriter.write("ddshfkjdh");
            fileWriter.write(listenerextend.data);
            fileWriter.close();



        }
    }
