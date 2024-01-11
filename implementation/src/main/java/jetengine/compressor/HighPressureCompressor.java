package jetengine.compressor;

import jetengine.blade.Blade;
import jetengine.blade.RShapedBlade;

public class HighPressureCompressor {
    private final Blade[] blades;

    public HighPressureCompressor() {
        blades = new Blade[28];
    }

    public void build() {
        for (int i = 0; i < blades.length; i++) {
            blades[i] = new RShapedBlade(8.5);
        }
    }
}