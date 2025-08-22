package classes;

public class Initvalue {
    private String string;
    private String number;
    private IsBoolean isBoolean;
    private BodyList bodyList;
    private ObjectV objectV;
    private String objectKey;

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
        if (isBoolean != null) {
            return isBoolean.toString();
        }
        if (string != null) {
            return string;
        }
        if (number != null) {
            return number;
        }
        if (objectV != null) {
            return objectV.toString();
        }
        if (bodyList != null) {
            return bodyList.toString();
        }
        return "null";
    }
}