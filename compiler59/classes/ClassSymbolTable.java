package classes;

import java.util.*;

/**
 * Class Symbol Table using MAP
 * Optimized for class name lookups, namespace management, and conflict detection
 */
public class ClassSymbolTable implements ErrorSymbolTable {
    // MAP: Class name -> ClassInfo for fast lookups
    private Map<String, ClassInfo> classRegistry;
    // MAP: Namespace -> Set of class names for namespace management
    private Map<String, Set<String>> namespaceToClasses;
    // MAP: Lowercase class name -> Original class name (for case-sensitivity)
    private Map<String, String> caseInsensitiveMap;
    // MAP: Class name -> Set of similar names for suggestion
    private Map<String, Set<String>> similarNamesCache;

    public ClassSymbolTable() {
        this.classRegistry = new HashMap<>();
        this.namespaceToClasses = new HashMap<>();
        this.caseInsensitiveMap = new HashMap<>();
        this.similarNamesCache = new HashMap<>();
    }

    @Override
    public void addSymbol(String symbol, String type, String scope, int line, int column) {
        ClassInfo info = new ClassInfo(symbol, type, scope, line, column);
        classRegistry.put(symbol, info);

        // Add to namespace mapping
        namespaceToClasses.computeIfAbsent(scope, k -> new HashSet<>()).add(symbol);

        // Add to case-insensitive mapping
        caseInsensitiveMap.put(symbol.toLowerCase(), symbol);

        // Update similar names cache
        updateSimilarNamesCache(symbol);
    }

    public List<String> getConflictingNamespaces(String className) {
        List<String> conflicts = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : namespaceToClasses.entrySet()) {
            if (entry.getValue().contains(className)) {
                conflicts.add(entry.getKey());
            }
        }
        return conflicts.size() > 1 ? conflicts : new ArrayList<>();
    }

    public List<String> suggestAlternativeNames(String className) {
        Set<String> suggestions = new HashSet<>();

        // Add numbered variations
        for (int i = 1; i <= 3; i++) {
            String suggestion = className + i;
            if (!classRegistry.containsKey(suggestion)) {
                suggestions.add(suggestion);
            }
        }

        // Add prefixed variations
        String[] prefixes = {"Abstract", "Base", "Default"};
        for (String prefix : prefixes) {
            String suggestion = prefix + className;
            if (!classRegistry.containsKey(suggestion)) {
                suggestions.add(suggestion);
            }
        }

        // Add suffixed variations
        String[] suffixes = {"Impl", "Class", "Type"};
        for (String suffix : suffixes) {
            String suggestion = className + suffix;
            if (!classRegistry.containsKey(suggestion)) {
                suggestions.add(suggestion);
            }
        }

        return new ArrayList<>(suggestions);
    }

    public String findCaseSensitiveConflict(String className) {
        String lowerCase = className.toLowerCase();
        String existing = caseInsensitiveMap.get(lowerCase);
        if (existing != null && !existing.equals(className)) {
            return existing;
        }
        return null;
    }

    public boolean isClassDefined(String className, String namespace) {
        Set<String> classesInNamespace = namespaceToClasses.get(namespace);
        return classesInNamespace != null && classesInNamespace.contains(className);
    }

    private void updateSimilarNamesCache(String className) {
        Set<String> similar = new HashSet<>();
        for (String existing : classRegistry.keySet()) {
            if (!existing.equals(className) && areNamesSimilar(className, existing)) {
                similar.add(existing);
                // Add bidirectional similarity
                similarNamesCache.computeIfAbsent(existing, k -> new HashSet<>()).add(className);
            }
        }
        similarNamesCache.put(className, similar);
    }

    private boolean areNamesSimilar(String name1, String name2) {
        // Simple similarity check - Levenshtein distance of 1-2
        if (Math.abs(name1.length() - name2.length()) > 2) return false;
        int distance = calculateLevenshteinDistance(name1, name2);
        return distance <= 2;
    }

    private int calculateLevenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1),
                            dp[i-1][j-1] + (s1.charAt(i-1) == s2.charAt(j-1) ? 0 : 1)
                    );
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    @Override
    public boolean hasRelevantSymbols() {
        return !classRegistry.isEmpty();
    }

    @Override
    public String getFormattedSymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Class Registry Context:\n");
        for (Map.Entry<String, ClassInfo> entry : classRegistry.entrySet()) {
            ClassInfo info = entry.getValue();
            sb.append(String.format("    - Class '%s' [%s] in namespace '%s' (Line %d)\n",
                    entry.getKey(), info.type, info.namespace, info.line));
        }

        // Show namespace distribution
        sb.append("  Namespace Distribution:\n");
        for (Map.Entry<String, Set<String>> entry : namespaceToClasses.entrySet()) {
            sb.append(String.format("    - %s: %s\n",
                    entry.getKey(), String.join(", ", entry.getValue())));
        }
        return sb.toString();
    }

    @Override
    public void clear() {
        classRegistry.clear();
        namespaceToClasses.clear();
        caseInsensitiveMap.clear();
        similarNamesCache.clear();
    }

    @Override
    public int getSymbolCount() {
        return classRegistry.size();
    }

    static class ClassInfo {
        String className;
        String type; // class type (abstract, final, etc.)
        String namespace;
        int line;
        int column;
        Set<String> methods;
        Set<String> properties;

        ClassInfo(String className, String type, String namespace, int line, int column) {
            this.className = className;
            this.type = type;
            this.namespace = namespace;
            this.line = line;
            this.column = column;
            this.methods = new HashSet<>();
            this.properties = new HashSet<>();
        }
    }
}