package classes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BodyObject {
    private List<Initvalue> initvalues = new ArrayList<>();
    private Map<String, Initvalue> properties = new LinkedHashMap<>();

    public List<Initvalue> getInitvalues() {
        return new ArrayList<>(properties.values());
    }

    public void setInitvalues(List<Initvalue> initvalues) {
        this.initvalues = initvalues;
    }

    public void addProperty(String key, Initvalue value) {
        properties.put(key, value);
    }

    public Map<String, Initvalue> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        List<String> propStrings = new ArrayList<>();
        for (Map.Entry<String, Initvalue> entry : properties.entrySet()) {
            String formattedValue = formatValue(entry.getValue());
            propStrings.add(entry.getKey() + ": " + formattedValue);
        }
        sb.append(String.join(", ", propStrings));
        sb.append("}");
        return sb.toString();
    }

    private String formatValue(Initvalue value) {
        if (value == null) return "null";

        if (value.getString() != null) {
            return "\"" + value.getString().replace("\"", "") + "\"";
        }
        if (value.getNumber() != null) {
            return value.getNumber();
        }
        if (value.getIsBoolean() != null) {
            return value.getIsBoolean().toString();
        }
        if (value.getObjectV() != null) {
            return value.getObjectV().toString();
        }
        if (value.getBodyList() != null) {
            return value.getBodyList().toString();
        }
        return "null";
    }
}