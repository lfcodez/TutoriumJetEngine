package dhbw.mosbach.adapter;

public class Pin {
    private double data;

    public void setData(double data) {
        this.data = data;
    }

    public String toString() {
        return "{ Pin : data = " + data + " }";
    }
}