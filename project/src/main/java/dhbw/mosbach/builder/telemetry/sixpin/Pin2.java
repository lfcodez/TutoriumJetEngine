package dhbw.mosbach.builder.telemetry.sixpin;

public class Pin2 {
    private double data1;
    private double data2;

    public void setData(double data1, double data2) {
        this.data1 = data1;
        this.data2 = data2;
    }



    public String toString() {
        return "{ Pin :\ndata = " + data1 + "\ndata = " + data2 + "\n}";
    }

}
