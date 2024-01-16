package dhbw.mosbach.builder.turbine;

import dhbw.mosbach.builder.blade.Blade;
import dhbw.mosbach.builder.blade.LShapedBlade;
import dhbw.mosbach.visitor.ITechnician;

public class HighPressureTurbine implements ITurbine {
    private final Blade[] blades;

    public HighPressureTurbine() {
        blades = new Blade[28];
    }

    public void build() {
        for (int i = 0; i < blades.length; i++) {
            blades[i] = new LShapedBlade(8.5);
        }
    }

    @Override
    public void accept(ITechnician techniker) {
        techniker.visit(this);
    }
}