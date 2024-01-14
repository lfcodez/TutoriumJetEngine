package dhbw.mosbach.builder.telemetry.sixpin;

import dhbw.mosbach.builder.telemetry.Telemetry;

import java.util.Arrays;

public class SixPinConnector {
    private Telemetry telemetry;
    private Pin[] pins;

    public SixPinConnector() {
        pins = new Pin[6];
        for (int i = 0; i < 6; i++) {
            pins[i] = new Pin();
        }
    }

    public void connect(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public Pin[] getData() {
        for (int i = 0; i < pins.length; i++) {
            pins[i].setData(telemetry.getData()[i]);
        }

        return pins;
    }

    public String toString() {
        return Arrays.toString(pins);
    }
}