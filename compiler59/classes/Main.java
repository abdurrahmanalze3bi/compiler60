package classes;

import gen.typescriptlexer;
import gen.typescriptparser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
//myTextLanguage1
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        String source = "myTextLanguage.txt";
//        String source2 ="myTextLanguage1.txt";
        try {
            // Attempt to read the file
            CharStream cs = CharStreams.fromFileName(source);
            typescriptlexer lexer = new typescriptlexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            typescriptparser parser = new typescriptparser(token);

            ParseTree tree = parser.program();
            MyVisitor visitor=new MyVisitor();
            Program doc = (Program) visitor.visit(tree);
            System.out.println(doc);

        } catch (IOException e) {
            System.err.println("Error: Unable to open file '" + source + "'");
            e.printStackTrace(); // Optional: Print stack trace for detailed error info
        }
    }
    }
