import java.io.*;
import java.util.Scanner;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.TerminalNode;
public class listnerhtml extends JavaParserBaseListener{

    int countexpr = 0, endexpr = 0,count=0;
    boolean term = false;
    TokenStreamRewriter rewriter;
    public listnerhtml(TokenStreamRewriter rewriter)  {
        this.rewriter = rewriter;
        this.count = 0;
    }

    @Override
    public void enterBlock(JavaParser.BlockContext ctx) {
        this.count++;
        boolean check=false;
        // Open the file
        File file = new File("output.txt");
        Scanner scanner = null;//intialize scanner
        try {// found the file to create scanner
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {// throw exception if file not found
            throw new RuntimeException(e);
        }
        // Read the file contents
        while (scanner.hasNextLine()) {//read each line in the file
            String line = scanner.nextLine();
            if (line.equals("block "+this.count+" is Visited")) {//check each line contain the string block {} is visted with number in {}
                check = true;

            }

        }
        scanner.reset();
        scanner.close();

        if(!check){//if block not found in txt file color it red
            rewriter.insertBefore(ctx.getStart(),"<pre style=\"background-color:#FF4A4A;\">");//color block red
            rewriter.insertAfter(ctx.getStop(),"</pre>\n");
        }
    }

    @Override
    public void enterCompilationUnit(JavaParser.CompilationUnitContext ctx) {//adding html tags and clor all body with green
        rewriter.insertBefore(ctx.getStart(),"<pre>\n");
        rewriter.insertBefore(ctx.getStart(),"<body style=\"background-color:#00EE7E;\">");//color block green
        rewriter.insertBefore(ctx.getStart(),"</head>\n");
        rewriter.insertBefore(ctx.getStart(),"<head>\n");
        rewriter.insertBefore(ctx.getStart(),"<html>\n");
        rewriter.insertAfter(ctx.getStop(),"</pre>\n");
        rewriter.insertAfter(ctx.getStop(),"</body>\n");
        rewriter.insertAfter(ctx.getStop(),"</html>\n");
    }
