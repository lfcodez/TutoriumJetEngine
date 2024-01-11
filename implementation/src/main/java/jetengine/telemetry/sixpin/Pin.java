package jetengine.telemetry.sixpin;

public class Pin {
    private double data;

    public void setData(double data) {
        this.data = data;
    }

    public String toString() {
        return "{ Pin : data = " + data + " }";
    }
}