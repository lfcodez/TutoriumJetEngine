package dhbw.mosbach.builder.configuration;

public class ParameterConfiguration {
    private ParameterP1Enums p1;
    private double p2;
    private boolean p3;
    private ParameterP4Enums p4;
    private int p5;

    private ParameterConfiguration(Builder builder) {
        this.p1 = builder.p1;
        this.p2 = builder.p2;
        this.p3 = builder.p3;
        this.p4 = builder.p4;
        this.p5 = builder.p5;
    }

    public ParameterP1Enums getP1() {
        return p1;
    }

    public double getP2() {
        return p2;
    }

    public boolean getP3() {
        return p3;
    }

    public ParameterP4Enums getP4() {
        return p4;
    }

    public int getP5() {
        return p5;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ParameterConfiguration : ");
        stringBuilder.append(p1).append("; ").append(p2).append("; ");
        stringBuilder.append(p3).append("; ").append(p4).append("; ").append(p5);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public static class Builder {
        private ParameterP1Enums p1;
        private double p2;
        private boolean p3;
        private ParameterP4Enums p4;
        private int p5;

        public Builder p1(ParameterP1Enums p1) {
            this.p1 = p1;
            return this;
        }

        public Builder p2(double p2) {
            this.p2 = p2;
            return this;
        }

        public Builder p3(boolean p3) {
            this.p3 = p3;
            return this;
        }

        public Builder p4(ParameterP4Enums p4) {
            this.p4 = p4;
            return this;
        }

        public Builder p5(int p5) {
            this.p5 = p5;
            return this;
        }

        public ParameterConfiguration build() {
            return new ParameterConfiguration(this);
        }
    }
}
