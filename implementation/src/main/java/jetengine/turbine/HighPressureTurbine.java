package jetengine.turbine;

import jetengine.blade.Blade;
import jetengine.blade.LShapedBlade;

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