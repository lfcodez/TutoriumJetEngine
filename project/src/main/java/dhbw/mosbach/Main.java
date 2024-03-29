package dhbw.mosbach;

import dhbw.mosbach.adapter.SixPinConnector;
import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.builder.Manufacturer;
import dhbw.mosbach.builder.Model;
import dhbw.mosbach.decorator.LogStringDecorator;
import dhbw.mosbach.observer.chamber.CombustionChamber;
import dhbw.mosbach.builder.compressor.HighPressureCompressor;
import dhbw.mosbach.builder.compressor.LowPressureCompressor;
import dhbw.mosbach.builder.configuration.ParameterConfiguration;
import dhbw.mosbach.builder.configuration.ParameterP1Enums;
import dhbw.mosbach.builder.configuration.ParameterP4Enums;
import dhbw.mosbach.builder.fan.Fan;
import dhbw.mosbach.builder.shaft.HighPressureDriveShaft;
import dhbw.mosbach.builder.shaft.LowPressureDriveShaft;
import dhbw.mosbach.builder.turbine.HighPressureTurbine;
import dhbw.mosbach.builder.turbine.LowPressureTurbine;
import dhbw.mosbach.command.*;
import dhbw.mosbach.proxy.Proxy;

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

        Proxy.INSTANCE.setParameterConfiguration(configuration);

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

        centralUnit.setJetEngine(jetEngine);
        ServiceCenter serviceCenter = new ServiceCenter(jetEngine);

        // Scenario 1
        centralUnit.setCommand(new StartCommand(jetEngine, new LogStringDecorator(serviceCenter), "start"));
        centralUnit.execute();

        // Scenario 2
        centralUnit.setCommand(new SetSpeedCommand(jetEngine, 683));
        centralUnit.execute();
        centralUnit.setCommand(new StartCommand(jetEngine, new LogStringDecorator(serviceCenter), "emergency shutdown"));
        centralUnit.execute();
    }
}