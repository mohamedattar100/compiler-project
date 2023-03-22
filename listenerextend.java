import org.antlr.v4.runtime.ParserRuleContext;

public class listenerextend extends CompilerBaseListener{

    int x=0;
    static String data="";

    @Override
    public void enterMainBlock(CompilerParser.MainBlockContext ctx) {
        super.enterMainBlock(ctx);
        System.out.println("{"+"// Block number "+x);
        data+="{"+"// Block number "+x+"\n";
        x++;
    }

    @Override
    public void exitMainBlock(CompilerParser.MainBlockContext ctx) {
        super.exitMainBlock(ctx);
        System.out.println("   } ");
        data+="} "+"\n";

    }

    @Override
    public void enterBlock(CompilerParser.BlockContext ctx) {
        super.enterBlock(ctx);
        System.out.println("{"+"// Block number "+x);
        data+="{"+"// Block number "+x+"\n";

        x++;

       // System.out.print("//block");
    }

    @Override
    public void exitBlock(CompilerParser.BlockContext ctx) {
        super.exitBlock(ctx);
        System.out.println("   } ");
        data+="} "+"\n";




    }
}
