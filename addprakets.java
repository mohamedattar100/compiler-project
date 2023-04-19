import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.TerminalNode;

public class addprakets extends JavaParserBaseListener{
    TokenStreamRewriter rewriter;
    boolean checkFORelse ;

    public addprakets(TokenStreamRewriter rewriter) {
        this.rewriter = rewriter;
        this.checkFORelse = false;
    }
    @Override
    public void visitTerminal(TerminalNode node) {
        if (node.getText().equals("else")) checkFORelse = true;
       // if (node.getText().equals("if")) checkFORelse = false;
    }


    @Override
    public void enterStatement(JavaParser.StatementContext ctx) {
        String str = ctx.getStart().getText();
        if (str.equals("if") || str.equals("while") || str.equals("do") || str.equals("for")) {
            if (!ctx.statement(0).start.getText().equals("{")) {
                rewriter.insertBefore(ctx.statement(0).start, "{");
                rewriter.insertAfter(ctx.statement(0).stop, "}");
            }
        } else if (checkFORelse) {
            checkFORelse = false;
            if (ctx.getText().length() >= 3 && ctx.getText().substring(0, 3).equals("if(")) return;
            if (ctx.getText().charAt(0) != '{') {
                rewriter.insertBefore(ctx.getStart(), "{");
                rewriter.insertAfter(ctx.getStop(), "}");
            }
        }

    }



}
