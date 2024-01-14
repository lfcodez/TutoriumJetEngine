package dhbw.mosbach.builder.turbine;

import dhbw.mosbach.builder.blade.Blade;
import dhbw.mosbach.builder.blade.SShapedBlade;

public class LowPressureTurbine {
    public LowPressureTurbine() {
        Blade[] blades = new Blade[30];

        for (int i = 0; i < blades.length; i++) {
            blades[i] = new SShapedBlade(11);
        }
    }
}