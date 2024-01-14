package dhbw.mosbach.builder.compressor;


import dhbw.mosbach.builder.blade.Blade;
import dhbw.mosbach.builder.blade.LShapedBlade;

public class LowPressureCompressor {
    public LowPressureCompressor() {
        Blade[] blades = new Blade[30];

        for (int i = 0; i < blades.length; i++) {
            blades[i] = new LShapedBlade(11);
        }
    }
}