package dhbw.mosbach.builder.shaft;

import dhbw.mosbach.builder.compressor.HighPressureCompressor;
import dhbw.mosbach.builder.turbine.HighPressureTurbine;

public class HighPressureDriveShaft {
    private final HighPressureCompressor[] compressors;
    private final HighPressureTurbine[] turbines;

    public HighPressureCompressor[] getCompressors() {
        return compressors;
    }

    public HighPressureTurbine[] getTurbines() {
        return turbines;
    }

    private HighPressureDriveShaft(Builder builder) {
        this.compressors = builder.compressors;
        this.turbines = builder.turbines;
    }

    @Override
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

    public static class Builder {
        private HighPressureCompressor[] compressors = new HighPressureCompressor[6];
        private HighPressureTurbine[] turbines = new HighPressureTurbine[2];

        public Builder compressor01(HighPressureCompressor compressor) {
            this.compressors[0] = compressor;
            return this;
        }

        public Builder compressor02(HighPressureCompressor compressor) {
            this.compressors[1] = compressor;
            return this;
        }

        public Builder compressor03(HighPressureCompressor compressor) {
            this.compressors[2] = compressor;
            return this;
        }

        public Builder compressor04(HighPressureCompressor compressor) {
            this.compressors[3] = compressor;
            return this;
        }

        public Builder compressor05(HighPressureCompressor compressor) {
            this.compressors[4] = compressor;
            return this;
        }

        public Builder compressor06(HighPressureCompressor compressor) {
            this.compressors[5] = compressor;
            return this;
        }

        public Builder turbine01(HighPressureTurbine turbine) {
            this.turbines[0] = turbine;
            return this;
        }

        public Builder turbine02(HighPressureTurbine turbine) {
            this.turbines[1] = turbine;
            return this;
        }

        public HighPressureDriveShaft build() {
            return new HighPressureDriveShaft(this);
        }
    }
}
