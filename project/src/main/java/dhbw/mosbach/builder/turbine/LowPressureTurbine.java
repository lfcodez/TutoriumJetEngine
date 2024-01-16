package dhbw.mosbach.builder.turbine;

import dhbw.mosbach.builder.blade.Blade;
import dhbw.mosbach.builder.blade.SShapedBlade;
import dhbw.mosbach.visitor.ITechnician;

public class LowPressureTurbine implements  ITurbine{
    public LowPressureTurbine() {
        Blade[] blades = new Blade[30];

        for (int i = 0; i < blades.length; i++) {
            blades[i] = new SShapedBlade(11);
        }
    }

    @Override
    public void accept(ITechnician techniker) {
        techniker.visit(this);
    }
}