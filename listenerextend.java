import org.antlr.v4.runtime.ParserRuleContext;

public class listenerextend extends CompilerBaseListener{

    @Override
    public void enterBlock(CompilerParser.BlockContext ctx) {
        super.enterBlock(ctx);

       // System.out.print("//block");
    }

    @Override
    public void exitBlock(CompilerParser.BlockContext ctx) {
        super.exitBlock(ctx);
    }
}
