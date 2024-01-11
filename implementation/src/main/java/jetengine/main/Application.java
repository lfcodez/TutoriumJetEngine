package jetengine.main;

import jetengine.engine.JetEngine;
import jetengine.engine.Manufacturer;
import jetengine.engine.Model;
import jetengine.telemetry.sixpin.Pin;

import java.util.Arrays;

public class Application {
    public static void main(String... args) {
        JetEngine jetEngine = new JetEngine();
        jetEngine.setManufacturer(Manufacturer.RollsRoyce);
        jetEngine.setModel(Model.TrentXWB);

        jetEngine.build();
        System.out.println(jetEngine);

        jetEngine.exportParameterConfiguration();
        jetEngine.importParameterConfiguration();

        Pin[] pins = jetEngine.getSixPinConnector().getData();
        System.out.println(Arrays.toString(pins));
    }
}