package classes;

import java.util.ArrayList;
import java.util.List;

public class BodyList {
List<Initvalue> initvalues =new ArrayList<>();

    public List<Initvalue> getInitvalues() {
        return initvalues;
    }

    public void setInitvalues(List<Initvalue> initvalues) {
        this.initvalues = initvalues;
    }

    @Override
    public String toString() {
        return "\nBodyList{" +
                "\n" + initvalues +
                "\n}";
    }
}
