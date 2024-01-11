package jetengine.configuration;

public class ParameterConfiguration {
    private ParameterP1Enums p1;
    private double p2;
    private boolean p3;
    private ParameterP4Enums p4;
    private int p5;

    public ParameterP1Enums getP1() {
        return p1;
    }

    public void setP1(ParameterP1Enums p1) {
        this.p1 = p1;
    }

    public double getP2() {
        return p2;
    }

    public void setP2(double p2) {
        this.p2 = p2;
    }

    public boolean getP3() {
        return p3;
    }

    public void setP3(boolean p3) {
        this.p3 = p3;
    }

    public ParameterP4Enums getP4() {
        return p4;
    }

    public void setP4(ParameterP4Enums p4) {
        this.p4 = p4;
    }

    public int getP5() {
        return p5;
    }

    public void setP5(int p5) {
        this.p5 = p5;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ParameterConfiguration : ");
        stringBuilder.append(p1).append("; ").append(p2).append("; ");
        stringBuilder.append(p3).append("; ").append(p4).append("; ").append(p5);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}