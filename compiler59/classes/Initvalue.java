package classes;

public class Initvalue {
    // Existing fields
    private String string;
    private String number;
    private IsBoolean isBoolean;
    private BodyList bodyList;
    private ObjectV objectV;

    // New field to store object keys
    private String objectKey;

    // Getters and setters
    public String getObjectKey() {
        return objectKey;
    }

    public void setObjectKey(String objectKey) {
        this.objectKey = objectKey;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public IsBoolean getIsBoolean() {
        return isBoolean;
    }

    public void setIsBoolean(IsBoolean isBoolean) {
        this.isBoolean = isBoolean;
    }

    public BodyList getBodyList() {
        return bodyList;
    }

    public void setBodyList(BodyList bodyList) {
        this.bodyList = bodyList;
    }

    public ObjectV getObjectV() {
        return objectV;
    }

    public void setObjectV(ObjectV objectV) {
        this.objectV = objectV;
    }

    @Override
    public String toString() {
        if(isBoolean != null) {
            return "\nInitvalue{"+
                    "\n " + isBoolean +
                    "\n}";
        }
        if(string != null) {
            return "\nInitvalue{" +
                    "\n string=" + string +
                    "\n}";
        }
        if(objectV != null) {
            return "\nInitvalue{" +
                    "\n " + objectV +
                    "\n}";
        }
        if(bodyList != null) {
            return "\nInitvalue{" +
                    "\n " + bodyList +
                    "\n}";
        }
        return "\nInitvalue{" +
                "\n number=" + number +
                "\n}";
    }
}