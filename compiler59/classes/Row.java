package classes;

public class Row {
    private String type;
    private String value;
    private int scopeId;
    private String scopeName;
    private String dataType;
    private Object initialValue;
    public Row() {
        this.scopeId = -1;
        this.scopeName = "UNKNOWN";
    }
    public Row(String type, String value, int scopeId, String scopeName) {
        this.type = type;
        this.value = value;
        this.scopeId = scopeId;
        this.scopeName = scopeName;
        this.dataType = inferTypeFromKind(type);
    }

    public Row(String type, String value, int scopeId, String scopeName, String dataType) {
        this.type = type;
        this.value = value;
        this.scopeId = scopeId;
        this.scopeName = scopeName;
        this.dataType = dataType != null ? dataType : inferTypeFromKind(type);
    }
    private String inferTypeFromKind(String kind) {
        switch (kind.toUpperCase()) {
            case "NUMBER_LITERAL": return "number";
            case "STRING_LITERAL": return "string";
            case "BOOLEAN_LITERAL": return "boolean";
            case "BOOLEAN_TYPE": return "boolean";
            case "NUMBER_TYPE": return "number";
            case "METHOD": case "FUNCTION": return "function";
            case "CLASS": return "class";
            case "INTERFACE": return "interface";
            default: return "any";
        }
    }
    public String getDataType() { return dataType; }
    public void setDataType(String dataType) { this.dataType = dataType; }
    public Object getInitialValue() { return initialValue; }
    public void setInitialValue(Object initialValue) { this.initialValue = initialValue; }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getScopeId() {
        return scopeId;
    }

    public void setScopeId(int scopeId) {
        this.scopeId = scopeId;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }


}