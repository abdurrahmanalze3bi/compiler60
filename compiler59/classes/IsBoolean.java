package classes;

public class IsBoolean {
String truev ;
String  falsev;

    public String getTruev() {
        return truev;
    }

    public void setTruev(String truev) {
        this.truev = truev;
    }

    public String getFalsev() {
        return falsev;
    }

    public void setFalsev(String falsev) {
        this.falsev = falsev;
    }

    @Override
    public String toString() {

        if(truev!=null){
            return  "\nIsBoolean{" +
                    "\ntrue='" + truev + '\'' +
                     "}\n";
        }

        return "\nIsBoolean{" +
                "\n,false='" + falsev + '\'' +
                 "}\n";
    }
}
