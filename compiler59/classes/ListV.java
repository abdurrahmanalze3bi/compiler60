package classes;

public class ListV {
String nameList ;

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    @Override
    public String toString() {
        return "\nListV{" +
                "\nnameList='" + nameList + '\'' +
                "\n}";
    }
}
