package jetengine.shaft;

import jetengine.compressor.HighPressureCompressor;
import jetengine.turbine.HighPressureTurbine;

public class HighPressureDriveShaft {
    private final HighPressureCompressor[] compressors;
    private final HighPressureTurbine[] turbines;

    public HighPressureDriveShaft() {
        compressors = new HighPressureCompressor[6];
        turbines = new HighPressureTurbine[2];
    }

    public void assembly(HighPressureCompressor compressor01, HighPressureCompressor compressor02,
                         HighPressureCompressor compressor03, HighPressureCompressor compressor04,
                         HighPressureCompressor compressor05, HighPressureCompressor compressor06,
                         HighPressureTurbine turbine01, HighPressureTurbine turbine02) {
        compressors[0] = compressor01;
        compressors[1] = compressor02;
        compressors[2] = compressor03;
        compressors[3] = compressor04;
        compressors[4] = compressor05;
        compressors[5] = compressor06;

        turbines[0] = turbine01;
        turbines[1] = turbine02;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ HighPressureDriveShaft : ");

        stringBuilder.append("{ Compressors : ");
        for (HighPressureCompressor compressor : compressors) {
            stringBuilder.append(compressor.hashCode()).append(" ");
        }
        stringBuilder.append("}");

        stringBuilder.append(" { Turbines : ");
        for (HighPressureTurbine turbine : turbines) {
            stringBuilder.append(turbine.hashCode()).append(" ");
        }
        stringBuilder.append("} ");

        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}