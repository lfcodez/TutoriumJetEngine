package dhbw.mosbach.builder;

import com.fasterxml.jackson.databind.ObjectMapper;
import dhbw.mosbach.adapter.SixPinConnector;
import dhbw.mosbach.adapter.Telemetry;
import dhbw.mosbach.observer.chamber.CombustionChamber;
import dhbw.mosbach.builder.configuration.ParameterConfiguration;
import dhbw.mosbach.builder.shaft.HighPressureDriveShaft;
import dhbw.mosbach.builder.shaft.LowPressureDriveShaft;
import dhbw.mosbach.visitor.IEnginePart;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class JetEngine {
    private Manufacturer manufacturer;
    private Model model;
    private String serialNumber;

    public int getCurrentRPM() {
        return currentRPM;
    }

    public boolean isStarted() {
        return isStarted;
    }

    private ParameterConfiguration configuration;
    private LowPressureDriveShaft lowPressureDriveShaft;
    private HighPressureDriveShaft highPressureDriveShaft;
    private CombustionChamber[] combustionChambers;
    private boolean isStarted;
    private int currentRPM;

    public Model getModel() {
        return model;
    }

    private SixPinConnector sixPinConnector;

    private JetEngine(Builder builder) {
        this.manufacturer = builder.manufacturer;
        this.model = builder.model;
        this.serialNumber = builder.serialNumber;
        this.configuration = builder.configuration;
        this.lowPressureDriveShaft = builder.lowPressureDriveShaft;
        this.highPressureDriveShaft = builder.highPressureDriveShaft;
        this.combustionChambers = builder.combustionChambers;
        this.isStarted = builder.isStarted;
        this.currentRPM = builder.currentRPM;
        this.sixPinConnector = builder.sixPinConnector;
    }

    public void exportParameterConfiguration() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("parameter.json"), configuration);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void importParameterConfiguration() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readValue(new File("parameter.json"), ParameterConfiguration.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        if (!isStarted) {
            System.out.println("Start!");
            isStarted = true;

        } else{
            System.out.println("Already started!");
        }
    }

    public void setSpeed(int speedMPH) {
        System.out.println("Speed set to: "+ speedMPH + " MPH!");
        combustionChambers[0].setTemperature(speedMPH * 1.25);
        combustionChambers[1].setTemperature(speedMPH * 1.25);
    }

    public void shutdown() {
        if (isStarted) {
            System.out.println("Shutdown!");
            isStarted = false;
        } else{
            System.out.println("Already turned off!");
        }
    }

    public void emergencyShutdown() {
        if (isStarted) {
            System.out.println("Emergency shutdown!");
            isStarted = false;
        } else{
            System.out.println("Already turned off by emergency shutdown!");
        }
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ JetEngine : ")
                .append("manufacturer = ").append(manufacturer).append("; ")
                .append("model = ").append(model).append(";")
                .append("serialNumber = ").append(serialNumber).append("; ")
                .append("configuration = ").append(configuration).append("; ")
                .append("isStarted = ").append(isStarted).append("; ")
                .append("currentRPM = ").append(currentRPM).append("; ")
                .append("lowPressureDriveShaft = ").append(lowPressureDriveShaft).append("; ")
                .append("highPressureDriveShaft = ").append(highPressureDriveShaft).append("; ")
                .append("combustionChamber (count) = ").append(combustionChambers.length)
                .append(" }");

        return stringBuilder.toString();
    }

    public List<IEnginePart> getParts() {
        List<IEnginePart> list = new ArrayList<>();

        Collections.addAll(list, combustionChambers);
        Collections.addAll(list, lowPressureDriveShaft.getCompressors());
        Collections.addAll(list, lowPressureDriveShaft.getTurbines());
        Collections.addAll(list, highPressureDriveShaft.getCompressors());
        Collections.addAll(list, highPressureDriveShaft.getTurbines());


        return list;
    }

    public static class Builder {
        private Manufacturer manufacturer;
        private Model model;
        private final String serialNumber = UUID.randomUUID().toString();
        private ParameterConfiguration configuration;
        private LowPressureDriveShaft lowPressureDriveShaft;
        private HighPressureDriveShaft highPressureDriveShaft;
        private CombustionChamber[] combustionChambers = new CombustionChamber[2];
        private boolean isStarted;
        private int currentRPM;
        private SixPinConnector sixPinConnector = new SixPinConnector();

        public Builder() {
            Telemetry telemetry = new Telemetry();
            sixPinConnector.connect(telemetry);
        }

        public Builder manufacturer(Manufacturer manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder model(Model model) {
            this.model = model;
            return this;
        }

        public Builder configuration(ParameterConfiguration configuration) {
            this.configuration = configuration;
            return this;
        }

        public Builder lowPressureDriveShaft(LowPressureDriveShaft lowPressureDriveShaft) {
            this.lowPressureDriveShaft = lowPressureDriveShaft;
            return this;
        }

        public Builder highPressureDriveShaft(HighPressureDriveShaft highPressureDriveShaft) {
            this.highPressureDriveShaft = highPressureDriveShaft;
            return this;
        }

        public Builder combustionChambers(CombustionChamber[] combustionChambers) {
            this.combustionChambers = combustionChambers;
            return this;
        }

        public Builder isStarted(boolean isStarted) {
            this.isStarted = isStarted;
            return this;
        }

        public Builder currentRPM(int currentRPM) {
            this.currentRPM = currentRPM;
            return this;
        }

        public Builder sixPinConnector(SixPinConnector sixPinConnector) {
            this.sixPinConnector = sixPinConnector;
            return this;
        }

        public JetEngine build() {
            lowPressureDriveShaft.connect(highPressureDriveShaft);
            return new JetEngine(this);
        }
    }
}
