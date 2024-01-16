package dhbw.mosbach.builder.telemetry;

import dhbw.mosbach.builder.telemetry.sixpin.Pin;

public interface IConnector {
    public Pin[] getData();
}
