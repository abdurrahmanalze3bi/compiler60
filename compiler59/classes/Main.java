package classes;

import gen.typescriptlexer;
import gen.typescriptparser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String source = "myTextLanguage.txt";

        try {
            // Attempt to read the file
            CharStream cs = CharStreams.fromFileName(source);
            typescriptlexer lexer = new typescriptlexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            typescriptparser parser = new typescriptparser(token);

            ParseTree tree = parser.program();
            MyVisitor visitor = new MyVisitor();
            Program doc = (Program) visitor.visit(tree);

            // Print in tree format instead of toString()
            ASTTreePrinter.printTree(doc);

        } catch (IOException e) {
            System.err.println("Error: Unable to open file '" + source + "'");
            e.printStackTrace();
        }
    }
}