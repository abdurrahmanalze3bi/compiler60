package classes;

public class Operator {
    String plus ;
    String minus ;
    String mult ;
    String div ;

    public String getPlus() {
        return plus;
    }

    public void setPlus(String plus) {
        this.plus = plus;
    }

    public String getMinus() {
        return minus;
    }

    public void setMinus(String minus) {
        this.minus = minus;
    }

    public String getMult() {
        return mult;
    }

    public void setMult(String mult) {
        this.mult = mult;
    }

    public String getDiv() {
        return div;
    }

    public void setDiv(String div) {
        this.div = div;
    }

    @Override
    public String toString() {
        if (plus != null) {
            return "operator{plus='" + plus + "'}";
        } else if (minus != null) {
            return "operator{minus='" + minus + "'}";
        } else if (mult != null) {
            return "operator{mult='" + mult + "'}";
        } else if (div != null) {
            return "operator{div='" + div + "'}";
        } else {
            return "operator{}";
        }
    }

}
