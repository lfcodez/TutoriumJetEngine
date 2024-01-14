package dhbw.mosbach;

import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.builder.Manufacturer;
import dhbw.mosbach.builder.Model;
import dhbw.mosbach.observer.chamber.CombustionChamber;
import dhbw.mosbach.builder.compressor.HighPressureCompressor;
import dhbw.mosbach.builder.compressor.LowPressureCompressor;
import dhbw.mosbach.builder.configuration.ParameterConfiguration;
import dhbw.mosbach.builder.configuration.ParameterP1Enums;
import dhbw.mosbach.builder.configuration.ParameterP4Enums;
import dhbw.mosbach.builder.fan.Fan;
import dhbw.mosbach.builder.shaft.HighPressureDriveShaft;
import dhbw.mosbach.builder.shaft.LowPressureDriveShaft;
import dhbw.mosbach.builder.telemetry.sixpin.SixPinConnector;
import dhbw.mosbach.builder.turbine.HighPressureTurbine;
import dhbw.mosbach.builder.turbine.LowPressureTurbine;
import dhbw.mosbach.command.*;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        CentralUnit centralUnit = new CentralUnit();

        LowPressureDriveShaft lowPressureDriveShaft = new LowPressureDriveShaft.Builder()
                .compressor01(new LowPressureCompressor())
                .compressor02(new LowPressureCompressor())
                .fan01(new Fan())
                .fan02(new Fan())
                .turbine01(new LowPressureTurbine())
                .turbine02(new LowPressureTurbine())
                .build();

        HighPressureDriveShaft highPressureDriveShaft = new HighPressureDriveShaft.Builder()
                .compressor01(new HighPressureCompressor())
                .compressor02(new HighPressureCompressor())
                .compressor03(new HighPressureCompressor())
                .compressor04(new HighPressureCompressor())
                .compressor05(new HighPressureCompressor())
                .compressor06(new HighPressureCompressor())
                .turbine01(new HighPressureTurbine())
                .turbine02(new HighPressureTurbine())
                .build();

        ParameterConfiguration configuration = new ParameterConfiguration.Builder()
                .p1(ParameterP1Enums.ENABLED)
                .p2(0.25)
                .p3(true)
                .p4(ParameterP4Enums.A)
                .p5(800)
                .build();

        CombustionChamber[] combustionChambers = new CombustionChamber[2];
        CombustionChamber combustionChamber1 = new CombustionChamber();
        combustionChamber1.getSensor().addListener(centralUnit);
        combustionChambers[0] = combustionChamber1;

        CombustionChamber combustionChamber2 = new CombustionChamber();
        combustionChamber2.getSensor().addListener(centralUnit);
        combustionChambers[1] = combustionChamber2;



        JetEngine jetEngine = new JetEngine.Builder()
                .manufacturer(Manufacturer.GeneralElectric)
                .model(Model.Trent900)
                .configuration(configuration)
                .lowPressureDriveShaft(lowPressureDriveShaft)
                .highPressureDriveShaft(highPressureDriveShaft)
                .combustionChambers(combustionChambers)
                .isStarted(false)
                .currentRPM(0)
                .sixPinConnector(new SixPinConnector())
                .build();

        System.out.println(jetEngine.toString());

        // Functions

        //Command-Pattern
        ICommand commandStart = new StartCommand(jetEngine);
        ICommand commandSetSpeed = new SetSpeedCommand(jetEngine, 320);
        ICommand commandShutDown = new ShutDownCommand(jetEngine);
        ICommand commandEmergency = new EmergencyShutDownCommand(jetEngine);

        // TODO Workaround das CentralUnit JetEngine nicht kennt und Commandos gesetzt werden
        // Müssen wir noch überarbeiten prbly
        // hardcoded shit
        HashMap<String,ICommand> commandos = new HashMap<>();
        commandos.put("start", commandStart);
        commandos.put("setSpeed", commandSetSpeed);
        commandos.put("shutDown", commandShutDown);
        commandos.put("emergency", commandEmergency);

        centralUnit.setCommandos(commandos);

        centralUnit.setCommand("start");
        centralUnit.execute();

        centralUnit.setCommand("setSpeed");
        centralUnit.execute();
    }
}