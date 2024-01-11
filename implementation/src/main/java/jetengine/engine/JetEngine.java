package jetengine.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import jetengine.chamber.CombustionChamber;
import jetengine.compressor.HighPressureCompressor;
import jetengine.compressor.LowPressureCompressor;
import jetengine.configuration.ParameterConfiguration;
import jetengine.configuration.ParameterP1Enums;
import jetengine.configuration.ParameterP4Enums;
import jetengine.fan.Fan;
import jetengine.shaft.HighPressureDriveShaft;
import jetengine.shaft.LowPressureDriveShaft;
import jetengine.telemetry.sixpin.SixPinConnector;
import jetengine.telemetry.Telemetry;
import jetengine.turbine.HighPressureTurbine;
import jetengine.turbine.LowPressureTurbine;

import java.io.File;
import java.util.UUID;

public class JetEngine {
    private Manufacturer manufacturer;
    private Model model;
    private String serialNumber;
    private ParameterConfiguration configuration;
    private LowPressureDriveShaft lowPressureDriveShaft;
    private HighPressureDriveShaft highPressureDriveShaft;
    private CombustionChamber[] combustionChambers;
    private boolean isStarted;
    private int currentRPM;
    private SixPinConnector sixPinConnector;

    public JetEngine() {
        serialNumber = UUID.randomUUID().toString();
        configuration = new ParameterConfiguration();

        configuration.setP1(ParameterP1Enums.ENABLED);
        configuration.setP2(0.25);
        configuration.setP3(true);
        configuration.setP4(ParameterP4Enums.A);
        configuration.setP5(800);

        combustionChambers = new CombustionChamber[2];
        combustionChambers[0] = new CombustionChamber();
        combustionChambers[1] = new CombustionChamber();

        Telemetry telemetry = new Telemetry();
        sixPinConnector = new SixPinConnector();
        sixPinConnector.connect(telemetry);
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(Model model) {
        this.model = model;
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
        isStarted = true;
    }

    public void setSpeed(int speedMPH) {
        currentRPM = speedMPH * 15;
        combustionChambers[0].setTemperature(currentRPM * 1.15);
        combustionChambers[1].setTemperature(currentRPM * 1.15);
    }

    public void shutdown() {
        isStarted = false;
    }

    public void emergencyShutdown() {
        isStarted = false;
    }

    public void build() {
        Fan fan01 = new Fan();
        Fan fan02 = new Fan();

        LowPressureCompressor lowPressureCompressor01 = new LowPressureCompressor();
        LowPressureCompressor lowPressureCompressor02 = new LowPressureCompressor();

        LowPressureTurbine lowPressureTurbine01 = new LowPressureTurbine();
        LowPressureTurbine lowPressureTurbine02 = new LowPressureTurbine();

        lowPressureDriveShaft = new LowPressureDriveShaft();
        lowPressureDriveShaft.assembly(
                fan01,
                fan02,
                lowPressureCompressor01,
                lowPressureCompressor02,
                lowPressureTurbine01,
                lowPressureTurbine02
        );

        HighPressureCompressor highPressureCompressor01 = new HighPressureCompressor();
        HighPressureCompressor highPressureCompressor02 = new HighPressureCompressor();
        HighPressureCompressor highPressureCompressor03 = new HighPressureCompressor();
        HighPressureCompressor highPressureCompressor04 = new HighPressureCompressor();
        HighPressureCompressor highPressureCompressor05 = new HighPressureCompressor();
        HighPressureCompressor highPressureCompressor06 = new HighPressureCompressor();

        HighPressureTurbine highPressureTurbine01 = new HighPressureTurbine();
        HighPressureTurbine highPressureTurbine02 = new HighPressureTurbine();

        highPressureDriveShaft = new HighPressureDriveShaft();
        highPressureDriveShaft.assembly(
                highPressureCompressor01,
                highPressureCompressor02,
                highPressureCompressor03,
                highPressureCompressor04,
                highPressureCompressor05,
                highPressureCompressor06,
                highPressureTurbine01,
                highPressureTurbine02
        );

        lowPressureDriveShaft.connect(highPressureDriveShaft);
    }

    public SixPinConnector getSixPinConnector() {
        return sixPinConnector;
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
}