package dhbw.mosbach.memento;

import dhbw.mosbach.builder.configuration.ParameterP1Enums;
import dhbw.mosbach.builder.configuration.ParameterP4Enums;

public class ParameterConfigurationMemento {
    private ParameterP1Enums p1;
    private double p2;

    public ParameterP1Enums getP1() {
        return p1;
    }

    public double getP2() {
        return p2;
    }

    public boolean isP3() {
        return p3;
    }

    public ParameterP4Enums getP4() {
        return p4;
    }

    public int getP5() {
        return p5;
    }

    private boolean p3;
    private ParameterP4Enums p4;
    private int p5;

    public ParameterConfigurationMemento(ParameterP1Enums p1, double p2, boolean p3, ParameterP4Enums p4, int p5) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
    }
}
