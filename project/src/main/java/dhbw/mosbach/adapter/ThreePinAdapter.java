package dhbw.mosbach.adapter;

public class ThreePinAdapter extends Telemetry implements IConnector{

    @Override
    public Pin[] getData() {
        double[] data = super.getTelemetryData();
        Pin p1 = new Pin();
        Pin p2 = new Pin();
        Pin p3 = new Pin();

        p1.setData(data[0]+data[3]);
        p2.setData(data[1]+data[4]);
        p3.setData(data[2]+data[5]);

        return new Pin[]{p1, p2, p3};

    }
}
