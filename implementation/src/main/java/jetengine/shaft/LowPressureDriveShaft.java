package jetengine.shaft;

import jetengine.compressor.LowPressureCompressor;
import jetengine.fan.Fan;
import jetengine.turbine.LowPressureTurbine;

public class LowPressureDriveShaft {
    private final Fan[] fans;
    private final LowPressureCompressor[] compressors;
    private final LowPressureTurbine[] turbines;
    private HighPressureDriveShaft driveShaft;

    public LowPressureDriveShaft() {
        fans = new Fan[2];
        compressors = new LowPressureCompressor[2];
        turbines = new LowPressureTurbine[2];
    }

    public void assembly(Fan fan01, Fan fan02,
                         LowPressureCompressor compressor01, LowPressureCompressor compressor02,
                         LowPressureTurbine turbine01, LowPressureTurbine turbine02
    ) {
        fans[0] = fan01;
        fans[1] = fan02;

        compressors[0] = compressor01;
        compressors[1] = compressor02;

        turbines[0] = turbine01;
        turbines[1] = turbine02;
    }

    public void connect(HighPressureDriveShaft driveShaft) {
        this.driveShaft = driveShaft;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ LowPressureDriveShaft : ");

        stringBuilder.append(" { Fans : ");
        for (Fan fan : fans) {
            stringBuilder.append(fan.hashCode()).append(" ");
        }
        stringBuilder.append("} ");

        stringBuilder.append("{ Compressors : ");
        for (LowPressureCompressor compressor : compressors) {
            stringBuilder.append(compressor.hashCode()).append(" ");
        }
        stringBuilder.append("}");

        stringBuilder.append(" { Turbines : ");
        for (LowPressureTurbine turbine : turbines) {
            stringBuilder.append(turbine.hashCode()).append(" ");
        }
        stringBuilder.append(" }");

        stringBuilder.append("{ HighPressureDriveShaft : ");
        stringBuilder.append(driveShaft.hashCode());
        stringBuilder.append(" }");

        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}