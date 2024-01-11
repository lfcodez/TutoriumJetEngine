package jetengine.compressor;

import jetengine.blade.Blade;
import jetengine.blade.LShapedBlade;

public class LowPressureCompressor {
    public LowPressureCompressor() {
        Blade[] blades = new Blade[30];

        for (int i = 0; i < blades.length; i++) {
            blades[i] = new LShapedBlade(11);
        }
    }
}