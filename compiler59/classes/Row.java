package classes;

public class Row {
    private String type;
    private String value;
    private int scopeId;
    private String scopeName;

    public Row() {
        this.scopeId = -1;
        this.scopeName = "UNKNOWN";
    }

    public Row(String type, String value, int scopeId, String scopeName) {
        this.type = type;
        this.value = value;
        this.scopeId = scopeId;
        this.scopeName = scopeName;
    }

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