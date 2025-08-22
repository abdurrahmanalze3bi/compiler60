package classes;

import java.util.*;

/**
 * Method Symbol Table using MAP
 * Optimized for method signature lookups and overloading detection
 */
public class MethodSymbolTable implements ErrorSymbolTable {
    // MAP: Method signature -> MethodInfo for fast lookups
    private Map<String, MethodInfo> methodSignatures;
    // MAP: Method name -> List of signatures (for overloading analysis)
    private Map<String, List<String>> methodOverloads;
    // MAP: Scope -> Methods in that scope
    private Map<String, Set<String>> scopeMethods;

    public MethodSymbolTable() {
        this.methodSignatures = new HashMap<>();
        this.methodOverloads = new HashMap<>();
        this.scopeMethods = new HashMap<>();
    }

    @Override
    public void addSymbol(String symbol, String type, String scope, int line, int column) {
        // symbol is method signature, type is return type
        MethodInfo info = new MethodInfo(symbol, type, scope, line, column);
        methodSignatures.put(symbol, info);

        // Extract method name for overload tracking
        String methodName = extractMethodName(symbol);
        methodOverloads.computeIfAbsent(methodName, k -> new ArrayList<>()).add(symbol);

        // Add to scope tracking
        scopeMethods.computeIfAbsent(scope, k -> new HashSet<>()).add(symbol);
    }

    public boolean canBeOverloaded(String methodName, List<String> parameterTypes) {
        List<String> existingSignatures = methodOverloads.get(methodName);
        if (existingSignatures == null) return true;

        // Check if parameter types are different enough for overloading
        for (String signature : existingSignatures) {
            List<String> existingParams = extractParameterTypes(signature);
            if (!canOverload(parameterTypes, existingParams)) {
                return false;
            }
        }
        return true;
    }

    public List<String> getConflictingSignatures(String signature) {
        String methodName = extractMethodName(signature);
        List<String> conflicts = new ArrayList<>();
        List<String> overloads = methodOverloads.get(methodName);

        if (overloads != null) {
            for (String existingSignature : overloads) {
                if (!existingSignature.equals(signature) && hasSignatureConflict(signature, existingSignature)) {
                    conflicts.add(existingSignature);
                }
            }
        }
        return conflicts;
    }

    private String extractMethodName(String signature) {
        int parenIndex = signature.indexOf('(');
        return parenIndex > 0 ? signature.substring(0, parenIndex) : signature;
    }

    private List<String> extractParameterTypes(String signature) {
        int startParen = signature.indexOf('(');
        int endParen = signature.indexOf(')');
        if (startParen == -1 || endParen == -1 || startParen >= endParen) {
            return new ArrayList<>();
        }
        String params = signature.substring(startParen + 1, endParen);
        return params.isEmpty() ? new ArrayList<>() : Arrays.asList(params.split(","));
    }

    private boolean canOverload(List<String> params1, List<String> params2) {
        if (params1.size() != params2.size()) return true;
        for (int i = 0; i < params1.size(); i++) {
            if (!params1.get(i).equals(params2.get(i))) return true;
        }
        return false;
    }

    private boolean hasSignatureConflict(String sig1, String sig2) {
        // Simple conflict detection - in reality this would be more sophisticated
        return sig1.equals(sig2);
    }

    @Override
    public boolean hasRelevantSymbols() {
        return !methodSignatures.isEmpty();
    }

    @Override
    public String getFormattedSymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Method Context:\n");
        for (Map.Entry<String, MethodInfo> entry : methodSignatures.entrySet()) {
            MethodInfo info = entry.getValue();
            sb.append(String.format("    - %s returns %s in scope '%s' (Line %d)\n",
                    entry.getKey(), info.returnType, info.scope, info.line));
        }
        return sb.toString();
    }

    @Override
    public void clear() {
        methodSignatures.clear();
        methodOverloads.clear();
        scopeMethods.clear();
    }

    @Override
    public int getSymbolCount() {
        return methodSignatures.size();
    }

    static class MethodInfo {
        String signature;
        String returnType;
        String scope;
        int line;
        int column;

        MethodInfo(String signature, String returnType, String scope, int line, int column) {
            this.signature = signature;
            this.returnType = returnType;
            this.scope = scope;
            this.line = line;
            this.column = column;
        }
    }}