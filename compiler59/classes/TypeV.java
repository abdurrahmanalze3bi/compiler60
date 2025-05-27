package classes;

import java.util.List;

public class TypeV {
    String string_type  ;
    String number_type ;
    ListV listV ;
    String isboolean ;

    public String getIsboolean() {
        return isboolean;
    }

    public void setIsboolean(String isboolean) {
        this.isboolean = isboolean;
    }

    public String getString_type() {
        return string_type;
    }

    public void setString_type(String string_type) {
        this.string_type = string_type;
    }

    public String getNumber_type() {
        return number_type;
    }

    public void setNumber_type(String number_type) {
        this.number_type = number_type;
    }

    public ListV getListV() {
        return listV;
    }

    public void setListV(ListV listV) {
        this.listV = listV;
    }

    @Override
    public String toString() {
        if(number_type!=null){
            return "\nType{"+
                    "\n, number_type=" + number_type +
                    "\n}";
        }
        if(listV!=null){
            return "\nType{"+
                    "\n,list=" +listV +
                    "\n}";
        }
        if(isboolean!=null){
            return "\nType{"+
                   "\n,boolean_type =" + isboolean +
                  "\n}";


            }
        return   "\nType{"+
                "\n,string_type =" + string_type +
                "\n}";


    }}