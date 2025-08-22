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
        String outputPath = "C:\\Users\\ALZOUBI\\ideaProjecte\\compiler2";

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

            // Create output directory if it doesn't exist
            java.io.File outputDir = new java.io.File(outputPath);
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            // CHANGED: Generate Vanilla Web components instead of Angular
            VanillaWebCodeGenerator codegen = new VanillaWebCodeGenerator(visitor.getSymbolTable());
            codegen.generateFromAST(doc, outputPath);

            System.out.println("Vanilla Web code generation completed successfully!");
            System.out.println("Files generated in: " + outputPath);
            System.out.println("Generated files: .html, .css, .js");

        } catch (IOException e) {
            System.err.println("Error: Unable to open file '" + source + "'");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error during code generation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}