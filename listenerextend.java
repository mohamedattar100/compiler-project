import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileWriter;

public class listenerextend extends JavaParserBaseListener{
    int counter;
    TokenStreamRewriter rewriter;
    public listenerextend(TokenStreamRewriter rewriter){
        this.rewriter = rewriter;
        this.counter=0;
    }
    
}
