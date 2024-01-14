package dhbw.mosbach.builder.turbine;

import dhbw.mosbach.builder.blade.Blade;
import dhbw.mosbach.builder.blade.LShapedBlade;

public class HighPressureTurbine {
    private final Blade[] blades;

    public HighPressureTurbine() {
        blades = new Blade[28];
    }

    public void build() {
        for (int i = 0; i < blades.length; i++) {
            blades[i] = new LShapedBlade(8.5);
        }
    }
}