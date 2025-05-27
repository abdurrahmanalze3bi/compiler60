package classes;

public class ObjectV {
    BodyObject bodyObject ;

    public BodyObject getBodyObject() {
        return bodyObject;
    }

    public void setBodyObject(BodyObject bodyObject) {
        this.bodyObject = bodyObject;
    }

    @Override
    public String toString() {
        return "\nObjectV{" +
                "\n=" + bodyObject +
                "\n}";
    }
}
