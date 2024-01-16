package dhbw.mosbach.builder.telemetry;

import java.security.SecureRandom;

public class Telemetry extends ATelemetry {
    private double[] data;

    public Telemetry() {
        data = new double[6];

        SecureRandom randomGenerator = new SecureRandom();
        for (int i = 0; i < data.length; i++) {
            data[i] = randomGenerator.nextDouble();
        }
    }

    public double[] getData() {
        return data;
    }
}