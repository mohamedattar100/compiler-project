import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileWriter;

public class listenerextend extends JavaParserBaseListener{
    int counter=0;
    boolean term = false;
    int count=0;
    TokenStreamRewriter rewriter;
    public listenerextend(TokenStreamRewriter rewriter){
        this.rewriter = rewriter;
        this.counter=0;
    }
    @Override public void enterBlock(JavaParser.BlockContext ctx) {
        this.counter++;
        rewriter.insertAfter(ctx.getStart(),"//block number " + this.counter+"\n");//write after {
        if(counter==1) {//in main
            rewriter.insertAfter(ctx.getStart(), "\t" + "\t" + "try{\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"File output = new File(\"output.txt\");"+"\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"output.createNewFile();"+"\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"FileWriter w1 = new FileWriter(\"output.txt\");"+"\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"w1.write(\"block "+ this.counter + " is Visited\" +\"\\n\");"  +"\n");
            //rewriter.insertAfter(ctx.getStop(),"w1.close();"+"\n");
            rewriter.insertAfter(ctx.getStart(), "\t" + "\t" + "w1.close();" + "\n");

            rewriter.insertAfter(ctx.getStart(), "\t" + "\t" + "}catch (IOException e) {throw new RuntimeException(e);}\n");

        }
        else{
            rewriter.insertAfter(ctx.getStart(), "\t" + "\t" + "try{\n");

            rewriter.insertAfter(ctx.getStart(), "\t" + "\t" + "FileWriter w" + this.counter + " = new FileWriter(\"output.txt\",true);" + "\n");
            rewriter.insertAfter(ctx.getStart(), "\t" + "\t" + "w" + this.counter + ".write(\"block " + this.counter + " is Visited\"+\"\\n\");" + "\n");

            rewriter.insertAfter(ctx.getStart(), "\t" + "\t" + "w" + this.counter + ".close();" + "\n");
            rewriter.insertAfter(ctx.getStart(), "\t" + "\t" + "}catch (IOException e) {throw new RuntimeException(e);}\n");

        }

    }
    @Override
    public void enterCompilationUnit(JavaParser.CompilationUnitContext ctx) {
        rewriter.insertBefore(ctx.getStart(), "import java.io.*;" + "\n");
    }
    @Override public void enterClassBody(JavaParser.ClassBodyContext ctx) {
        rewriter.insertAfter(ctx.getStart(),"\n \n \t public static boolean check(int NoOfExpression) {\n" +
                "\t"  +   " try{FileWriter w = new FileWriter(\"the_visited_exp.txt\",true);\n" +
                "\t"  +"  w.write(\"exp\"+NoOfExpression+\"is visited\\n\");\n" +
                "\t"  +" w.close();\n}" +
                "\t"  +" catch(Exception e){}\n"+
                "\t"  +" return false;\n" +
                "\t"+"\t"  +" }\n");

    }
    @Override
    public void visitTerminal(TerminalNode node) {
        if(node.getText().equals("||")||node.getText().equals("&&"))
        {term=true;}
    }
    @Override
    public void enterParExpression(JavaParser.ParExpressionContext ctx)
    {term=true;}
    @Override
    public void enterExpression(JavaParser.ExpressionContext ctx) {
        if(term&&ctx.AND()==null&&ctx.OR()==null){

            count++;

            rewriter.insertBefore(ctx.getStart(),"(check("+count+")||");

            rewriter.insertAfter(ctx.getStop(),")");

            term=false;

            if(ctx.getText().charAt(0)=='(')term=true;
        }
    }



    }





