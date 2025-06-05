package classes;

import java.util.List;
import java.util.stream.Collectors;

public class ASTTreePrinter {
    public static void printTree(Program program) {
        System.out.println("=== Abstract Syntax Tree ===");
        printNode(program, "", true);
        System.out.println("============================");
    }

    private static void printNode(Object node, String prefix, boolean isTail) {
        if (node == null) return;

        String nodeName = getNodeName(node);
        String connector = isTail ? "└── " : "├── ";
        System.out.println(prefix + connector + nodeName);

        String childPrefix = prefix + (isTail ? "    " : "│   ");
        List<?> children = getChildren(node);

        if (children != null && !children.isEmpty()) {
            for (int i = 0; i < children.size(); i++) {
                boolean childIsTail = (i == children.size() - 1);
                printNode(children.get(i), childPrefix, childIsTail);
            }
        }
    }

    private static String getNodeName(Object node) {
        if (node == null) return "null";

        if (node instanceof Program) {
            Program program = (Program) node;
            int statementCount = program.getStatments().size();
            return "Program (" + statementCount + " statement" + (statementCount != 1 ? "s" : "") + ")";
        } else if (node instanceof Statment) {
            Statment stmt = (Statment) node;
            if (stmt.getImportDeclaration() != null) return "ImportStatement";
            if (stmt.getClassDeclaration() != null) return "ClassDeclaration";
            if (stmt.getInterfaceDeclaration() != null) return "InterfaceDeclaration";
            if (stmt.getComponentDeclaration() != null) return "ComponentDeclaration";
            if (stmt.getMethodDeclaration() != null) return "MethodDeclaration";
            return "Statement";
        } else if (node instanceof ImportDeclaration) {
            ImportDeclaration imp = (ImportDeclaration) node;
            String id = imp.getId() != null ? imp.getId() : "(default)";
            String source = imp.getString_lit() != null ? imp.getString_lit() : "(unknown)";
            return "Import: " + id + " from " + source;
        } else if (node instanceof ClassDeclaration) {
            return "Class: " + ((ClassDeclaration) node).getNameClass();
        } else if (node instanceof InterfaceDeclaration) {
            return "Interface: " + ((InterfaceDeclaration) node).getNameInterface();
        } else if (node instanceof ComponentDeclaration) {
            return "ComponentDeclaration";
        } else if (node instanceof ComponentDeclarationBody) {
            ComponentDeclarationBody body = (ComponentDeclarationBody) node;
            int elementCount = body.getComponentBodyElements().size();
            return "ComponentBody (" + elementCount + " element" + (elementCount != 1 ? "s" : "") + ")";
        } else if (node instanceof ComponentBodyElement) {
            ComponentBodyElement elem = (ComponentBodyElement) node;
            if (elem.getSelector() != null) return "Selector";
            if (elem.getStandalone() != null) return "Standalone";
            if (elem.getImportDeclaration() != null) return "Import";
            if (elem.getTemplate() != null) return "Template";
            if (elem.getStyles() != null) return "Styles";
            return "ComponentBodyElement";
        } else if (node instanceof Selector) {
            return "Selector: " + ((Selector) node).getSTRING_LIT();
        } else if (node instanceof Standalone) {
            return "Standalone: " + ((Standalone) node).isIsboolean().getTruev();
        } else if (node instanceof Template) {
            List<Element> elements = ((Template) node).getElement();
            int elementCount = elements.size();
            return "Template (" + elementCount + " root elements)";
        } else if (node instanceof Element) {
            Element elem = (Element) node;
            if (elem.getHtmlName() != null) {
                return "Element: <" + elem.getHtmlName() + ">";
            }
            return "Element";
        } else if (node instanceof Interpolation) {
            return "Interpolation: {{ " + ((Interpolation) node).getNAME_HTML() + " }}";
        } else if (node instanceof PropertyDeclaration) {
            PropertyDeclaration prop = (PropertyDeclaration) node;
            return "Property: " + String.join(", ", prop.getID()) +
                    (prop.getTypeV() != null ? " : " + getTypeName(prop.getTypeV()) : "");
        } else if (node instanceof InterfaceMember) {
            InterfaceMember member = (InterfaceMember) node;
            if (member.getPropertyDeclaration() != null) {
                PropertyDeclaration prop = member.getPropertyDeclaration();
                return "Interface Property: " + String.join(", ", prop.getID()) +
                        (prop.getTypeV() != null ? " : " + getTypeName(prop.getTypeV()) : "");
            } else if (member.getMethodDeclaration() != null) {
                return "Interface Method: " + member.getMethodDeclaration().getName();
            }
            return "InterfaceMember";
        } else if (node instanceof ClassMember) {
            ClassMember member = (ClassMember) node;
            if (member.getPropertyDeclaration() != null) {
                PropertyDeclaration prop = member.getPropertyDeclaration();
                return "Class Property: " + String.join(", ", prop.getID()) +
                        (prop.getTypeV() != null ? " : " + getTypeName(prop.getTypeV()) : "");
            } else if (member.getMethodDeclaration() != null) {
                return "Class Method: " + member.getMethodDeclaration().getName();
            }
            return "ClassMember";
        } else if (node instanceof MethodDeclaration) {
            MethodDeclaration method = (MethodDeclaration) node;
            return "Method: " + method.getName() +
                    (method.getTypeReturn() != null ? " : " + getTypeName(method.getTypeReturn()) : "");
        } else if (node instanceof MethodBody) {
            MethodBody body = (MethodBody) node;
            int statementCount = body.getStatementMethods().size();
            return "MethodBody (" + statementCount + " statement" + (statementCount != 1 ? "s" : "") + ")";
        } else if (node instanceof StatementMethod) {
            StatementMethod stmt = (StatementMethod) node;
            if (stmt.getVariable() != null && !stmt.getVariable().isEmpty()) {
                return "Assignment: " + String.join(", ", stmt.getVariable()) + " = ...";
            } else if (stmt.isIsreturn()) {
                return "Return statement";
            } else if (stmt.getExpression() != null) {
                return "Expression statement";
            }
            return "StatementMethod";
        } else if (node instanceof Styles) {
            return "Styles";
        } else if (node instanceof CssBody) {
            CssBody cssBody = (CssBody) node;
            int ruleCount = cssBody.getCssObjects() != null ?
                    cssBody.getCssObjects().getCssElementlist().size() : 0;
            return "CSS Body (" + ruleCount + " rule" + (ruleCount != 1 ? "s" : "") + ")";
        } else if (node instanceof CssElement) {
            return "CSS Rule";
        } else if (node instanceof Bodyelement) {
            Bodyelement decl = (Bodyelement) node;
            return "CSS Property: " + decl.getId_css();
        }
        return node.getClass().getSimpleName();
    }

    private static String getTypeName(TypeV type) {
        if (type == null) return "any";
        if (type.getIsboolean() != null) return "boolean";
        if (type.getNumber_type() != null) return "number";
        if (type.getString_type() != null) return type.getString_type();
        if (type.getListV() != null) {
            String elementType = type.getListV().getNameList() != null ?
                    type.getListV().getNameList() : "any";
            return "Array<" + elementType + ">";
        }
        return "any";
    }

    private static List<?> getChildren(Object node) {
        if (node instanceof Program) {
            return ((Program) node).getStatments();
        } else if (node instanceof Statment) {
            Statment stmt = (Statment) node;
            if (stmt.getImportDeclaration() != null) return List.of(stmt.getImportDeclaration());
            if (stmt.getClassDeclaration() != null) return List.of(stmt.getClassDeclaration());
            if (stmt.getInterfaceDeclaration() != null) return List.of(stmt.getInterfaceDeclaration());
            if (stmt.getComponentDeclaration() != null) return List.of(stmt.getComponentDeclaration());
            if (stmt.getMethodDeclaration() != null) return List.of(stmt.getMethodDeclaration());
        } else if (node instanceof ClassDeclaration) {
            return List.of(((ClassDeclaration) node).getClassDeclarationBody());
        } else if (node instanceof ClassDeclarationBody) {
            return ((ClassDeclarationBody) node).getClassMembers();
        } else if (node instanceof InterfaceDeclaration) {
            return ((InterfaceDeclaration) node).getInterfaceMembers();
        } else if (node instanceof ComponentDeclaration) {
            return List.of(((ComponentDeclaration) node).getComponentDeclarationBody());
        } else if (node instanceof ComponentDeclarationBody) {
            return ((ComponentDeclarationBody) node).getComponentBodyElements();
        } else if (node instanceof ComponentBodyElement) {
            ComponentBodyElement elem = (ComponentBodyElement) node;
            if (elem.getSelector() != null) return List.of(elem.getSelector());
            if (elem.getStandalone() != null) return List.of(elem.getStandalone());
            if (elem.getImportDeclaration() != null) return List.of(elem.getImportDeclaration());
            if (elem.getTemplate() != null) return List.of(elem.getTemplate());
            if (elem.getStyles() != null) return List.of(elem.getStyles());
        } else if (node instanceof Template) {
            return ((Template) node).getElement();
        } else if (node instanceof Styles) {
            return List.of(((Styles) node).getCssBody());
        } else if (node instanceof CssBody) {
            return List.of(((CssBody) node).getCssObjects());
        } else if (node instanceof CssObjects) {
            return ((CssObjects) node).getCssElementlist();
        } else if (node instanceof CssElement) {
            return ((CssElement) node).getBodyCssElements();
        } else if (node instanceof MethodDeclaration) {
            return List.of(((MethodDeclaration) node).getMethodBody());
        } else if (node instanceof MethodBody) {
            return ((MethodBody) node).getStatementMethods();
        } else if (node instanceof InterfaceMember) {
            InterfaceMember member = (InterfaceMember) node;
            if (member.getPropertyDeclaration() != null) return List.of(member.getPropertyDeclaration());
            if (member.getMethodDeclaration() != null) return List.of(member.getMethodDeclaration());
        } else if (node instanceof ClassMember) {
            ClassMember member = (ClassMember) node;
            if (member.getPropertyDeclaration() != null) return List.of(member.getPropertyDeclaration());
            if (member.getMethodDeclaration() != null) return List.of(member.getMethodDeclaration());
        } else if (node instanceof StatementMethod) {
            return null;
        }
        return null;
    }
}