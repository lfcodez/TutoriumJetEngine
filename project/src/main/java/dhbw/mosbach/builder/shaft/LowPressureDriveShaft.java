package dhbw.mosbach.builder.shaft;

import dhbw.mosbach.builder.compressor.LowPressureCompressor;
import dhbw.mosbach.builder.fan.Fan;
import dhbw.mosbach.builder.turbine.LowPressureTurbine;

public class LowPressureDriveShaft {
    private final Fan[] fans;
    private final LowPressureCompressor[] compressors;
    private final LowPressureTurbine[] turbines;
    private HighPressureDriveShaft driveShaft;

    private LowPressureDriveShaft(Builder builder){
        this.fans = builder.fans;
        this.compressors = builder.compressors;
        this.turbines = builder.turbines;
    }

    public void connect(HighPressureDriveShaft driveShaft) {
        this.driveShaft = driveShaft;
    }

    @Override
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
        if (driveShaft != null) {
            stringBuilder.append(driveShaft.hashCode());
        }
        stringBuilder.append(" }");

        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public LowPressureCompressor[] getCompressors() {
        return compressors;
    }

    public LowPressureTurbine[] getTurbines() {
        return turbines;
    }

    public static class Builder {
        private Fan[] fans = new Fan[2];
        private LowPressureCompressor[] compressors = new LowPressureCompressor[2];
        private LowPressureTurbine[] turbines = new LowPressureTurbine[2];

        public Builder fan01(Fan fan) {
            this.fans[0] = fan;
            return this;
        }

        public Builder fan02(Fan fan) {
            this.fans[1] = fan;
            return this;
        }

        public Builder compressor01(LowPressureCompressor compressor) {
            this.compressors[0] = compressor;
            return this;
        }

        public Builder compressor02(LowPressureCompressor compressor) {
            this.compressors[1] = compressor;
            return this;
        }

        public Builder turbine01(LowPressureTurbine turbine) {
            this.turbines[0] = turbine;
            return this;
        }

        public Builder turbine02(LowPressureTurbine turbine) {
            this.turbines[1] = turbine;
            return this;
        }
        public LowPressureDriveShaft build() {
            return new LowPressureDriveShaft(this);
        }
    }
}
