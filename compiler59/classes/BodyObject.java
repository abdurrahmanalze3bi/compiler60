package classes;

import java.util.ArrayList;
import java.util.List;

public class BodyObject {
    List<Initvalue>initvalues =new ArrayList<>();

    public List<Initvalue> getInitvalues() {
        return initvalues;
    }

    public void setInitvalues(List<Initvalue> initvalues) {
        this.initvalues = initvalues;
    }

    @Override
    public String toString() {
        return "\nBodyObject{" +
                "\n" + initvalues +
                "\n}";
    }
}
