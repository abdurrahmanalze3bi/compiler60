package classes;

import java.util.*;

public class BodyObject {
    private final Map<String, Initvalue> properties = new LinkedHashMap<>();

    // ✅ Add a key-value pair
    public void addProperty(String key, Initvalue value) {
        properties.put(key, value);
    }

    // ✅ Get all values (legacy support)
    public List<Initvalue> getInitvalues() {
        return new ArrayList<>(properties.values());
    }

    // ✅ Get all key-values
    public Map<String, Initvalue> getProperties() {
        return properties;
    }

    // ✅ Get property by key
    public Initvalue getProperty(String key) {
        return properties.get(key);
    }

    // ✅ Check if property exists
    public boolean hasProperty(String key) {
        return properties.containsKey(key);
    }

    // ✅ Get all keys
    public Set<String> getKeys() {
        return properties.keySet();
    }

    // ✅ Clear all properties
    public void clear() {
        properties.clear();
    }

    // ✅ Set from list (legacy support)
    public void setInitvalues(List<Initvalue> initvalues) {
        properties.clear();
        for (int i = 0; i < initvalues.size(); i++) {
            Initvalue val = initvalues.get(i);
            if (val.getObjectKey() != null) {
                properties.put(val.getObjectKey(), val);
            } else {
                // Use index as key if no explicit key
                properties.put(String.valueOf(i), val);
            }
        }
    }}