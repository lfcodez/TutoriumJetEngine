package dhbw.mosbach;

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
import dhbw.mosbach.builder.telemetry.sixpin.SixPinConnector;
import dhbw.mosbach.builder.turbine.HighPressureTurbine;
import dhbw.mosbach.builder.turbine.LowPressureTurbine;
import dhbw.mosbach.command.*;
import dhbw.mosbach.proxy.Proxy;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // create CentralUnit
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
        System.out.println(jetEngine.toString());

        centralUnit.setJetEngine(jetEngine);



        ServiceCenter serviceCenter = new ServiceCenter(jetEngine);
        // Scenario 1
        centralUnit.setCommand(new StartCommand(jetEngine, new LogStringDecorator(serviceCenter), "start"));
        centralUnit.execute();
        // Scenario 2
        /*
        Szenario 02:
            [01] JetEngine wird über das Kommando Start von der CentralUnit gestartet.
            [02] JetEngine wird über das Kommando SetSpeed auf 683 gesetzt.
            [03] Temperatur im CombustionChamber wird auf 850 gesetzt.
            [04] CentralUnit wird automatisch benachrichtigt und veranlasst EmergencyShutdown.
            [05] Bei Aufruf der Methode start wird eine verschlüsselte Meldung send(encrypt(record(hash(log("engine | emergency shutdown"))))) an das ServiceCenter kommuniziert.
            [06] ServiceCenter empfängt die verschlüsselte Meldung und entschlüsselt diese zwecks Weiterleitung an die CoR.
            [07] Die entschlüsselte Meldung wird über CoR zu dem verantwortlichen Team geleitet und vom Supervisor angenommen.
            [08] Über einen geeigneten Mechanismus wird die Meldung zu einem zufällig ausgewählten TechnicalEngineer im Team EmergencyTeamManager weitergeleitet.
            [09] Jeweils von einem spezialisierten Techniker werden Compressor, Turbine und CombustionChamber geprüft.
                 Die Durchführung der Prüfung wird vereinfacht als einfache Meldung am Bildschirm angezeigt.
            [10] TechnicalEngineer möchte den Parameter p1 verändern und wird abgewiesen.
            [11] EmergencyTeamManager importiert für die Parameter p1 und p3 eine inkorrekte Parameterkonfiguration und führt ein undo durch.
         */
        centralUnit.setCommand(new SetSpeedCommand(jetEngine, 683));
        centralUnit.execute();

        centralUnit.setCommand(new StartCommand(jetEngine, new LogStringDecorator(serviceCenter), "emergency shutdown"));
        centralUnit.execute();



    }
}