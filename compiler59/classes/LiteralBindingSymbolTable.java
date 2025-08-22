package classes;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Literal Binding Symbol Table using LIST
 * Optimized for tracking binding patterns and providing recommendations
 */
public class LiteralBindingSymbolTable implements ErrorSymbolTable {
    // LIST: For tracking binding patterns in order of occurrence
    private List<BindingPatternInfo> bindingPatterns;
    // LIST: For common property patterns that should use binding
    private List<String> commonPropertyPatterns;
    // LIST: For tracking recommendations based on patterns
    private List<BindingRecommendation> recommendations;
    // MAP: For quick lookup of pattern frequency
    private Map<String, Integer> patternFrequency;

    public LiteralBindingSymbolTable() {
        this.bindingPatterns = new ArrayList<>();
        this.commonPropertyPatterns = Arrays.asList(
                "src", "href", "value", "id", "class", "style",
                "disabled", "checked", "selected", "hidden"
        );
        this.recommendations = new ArrayList<>();
        this.patternFrequency = new HashMap<>();
        initializeRecommendations();
    }

    @Override
    public void addSymbol(String symbol, String type, String scope, int line, int column) {
        BindingPatternInfo pattern = new BindingPatternInfo(symbol, type, scope, line, column);
        bindingPatterns.add(pattern);

        // Update pattern frequency
        String patternKey = symbol + ":" + type;
        patternFrequency.put(patternKey, patternFrequency.getOrDefault(patternKey, 0) + 1);
    }

    public void addBindingPattern(String attributeName, String value, String bindingType, int line) {
        BindingPatternInfo pattern = new BindingPatternInfo(attributeName, bindingType, "TEMPLATE", line, 0);
        pattern.setValue(value);
        bindingPatterns.add(pattern);

        // Update frequency
        String patternKey = attributeName + ":" + bindingType;
        patternFrequency.put(patternKey, patternFrequency.getOrDefault(patternKey, 0) + 1);
    }

    public boolean isCommonPropertyPattern(String attributeName, String value) {
        // Check if attribute is in common patterns and value looks like a property reference
        return commonPropertyPatterns.contains(attributeName) &&
                (value.matches("[a-zA-Z_][a-zA-Z0-9_]*") || // Simple identifier
                        value.contains(".") && !value.startsWith("http")); // Property access
    }

    public List<String> getBindingRecommendations(String attributeName) {
        List<String> recs = new ArrayList<>();
        for (BindingRecommendation rec : recommendations) {
            if (rec.appliesTo(attributeName)) {
                recs.add(rec.getRecommendation(attributeName));
            }
        }
        return recs;
    }

    public String suggestInterpolation(String value) {
        // Suggest interpolation if value looks like a property reference
        if (value.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            return "{{ " + value + " }}";
        }

        // Suggest interpolation for expressions
        if (value.contains("+") || value.contains("*") || value.contains("/")) {
            return "{{ " + value + " }}";
        }

        return null;
    }

    public List<BindingPatternInfo> getPatternHistory() {
        return new ArrayList<>(bindingPatterns);
    }

    public Map<String, Integer> getPatternFrequencies() {
        return new HashMap<>(patternFrequency);
    }

    public List<String> getMostFrequentPatterns(int limit) {
        return patternFrequency.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private void initializeRecommendations() {
        // Initialize common binding recommendations
        recommendations.add(new BindingRecommendation(
                attr -> commonPropertyPatterns.contains(attr),
                attr -> "Use property binding [" + attr + "] for dynamic values"
        ));

        recommendations.add(new BindingRecommendation(
                attr -> attr.equals("class") || attr.equals("style"),
                attr -> "Consider [ngClass] or [ngStyle] for dynamic " + attr
        ));

        recommendations.add(new BindingRecommendation(
                attr -> attr.startsWith("data-"),
                attr -> "Data attributes can use property binding [attr." + attr + "]"
        ));
    }

    @Override
    public boolean hasRelevantSymbols() {
        return !bindingPatterns.isEmpty();
    }

    @Override
    public String getFormattedSymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Binding Pattern Context:\n");
        for (int i = 0; i < bindingPatterns.size(); i++) {
            BindingPatternInfo pattern = bindingPatterns.get(i);
            sb.append(String.format("    %d. Attribute '%s' = '%s' [%s] (Line %d)\n",
                    i + 1, pattern.attributeName, pattern.value, pattern.bindingType, pattern.line));
        }

        // Show pattern frequency
        sb.append("  Pattern Frequency:\n");
        getMostFrequentPatterns(5).forEach(pattern -> {
            int frequency = patternFrequency.get(pattern);
            sb.append(String.format("    - %s: %d times\n", pattern, frequency));
        });

        return sb.toString();
    }

    @Override
    public void clear() {
        bindingPatterns.clear();
        patternFrequency.clear();
        // Keep recommendations as they are reusable
    }

    @Override
    public int getSymbolCount() {
        return bindingPatterns.size();
    }

    static class BindingPatternInfo {
        String attributeName;
        String bindingType;
        String scope;
        int line;
        int column;
        String value;

        BindingPatternInfo(String attributeName, String bindingType, String scope, int line, int column) {
            this.attributeName = attributeName;
            this.bindingType = bindingType;
            this.scope = scope;
            this.line = line;
            this.column = column;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    static class BindingRecommendation {
        private Predicate<String> condition;
        private Function<String, String> recommendation;

        BindingRecommendation(Predicate<String> condition, Function<String, String> recommendation) {
            this.condition = condition;
            this.recommendation = recommendation;
        }

        public boolean appliesTo(String attributeName) {
            return condition.test(attributeName);
        }

        public String getRecommendation(String attributeName) {
            return recommendation.apply(attributeName);
        }
    }
}