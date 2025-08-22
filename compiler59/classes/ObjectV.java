package classes;

public class ObjectV {
    private BodyObject bodyObject;

    public BodyObject getBodyObject() {
        return bodyObject;
    }

    public void setBodyObject(BodyObject bodyObject) {
        this.bodyObject = bodyObject;
    }

    @Override
    public String toString() {
        return bodyObject != null ? bodyObject.toString() : "{}";
    }
}