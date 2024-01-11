package jetengine.turbine;

import jetengine.blade.Blade;
import jetengine.blade.SShapedBlade;

public class LowPressureTurbine {
    public LowPressureTurbine() {
        Blade[] blades = new Blade[30];

        for (int i = 0; i < blades.length; i++) {
            blades[i] = new SShapedBlade(11);
        }
    }
}