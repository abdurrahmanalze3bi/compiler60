package classes;

public class KeyValue {
    private String key;
    private Initvalue value;

    public KeyValue() {
    }

    public KeyValue(String key, Initvalue value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Initvalue getValue() {
        return value;
    }

    public void setValue(Initvalue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + ": " + (value != null ? value.toString() : "null");
    }

}