package dhbw.mosbach.builder.compressor;


import dhbw.mosbach.builder.blade.Blade;
import dhbw.mosbach.builder.blade.LShapedBlade;
import dhbw.mosbach.visitor.ITechnician;

public class LowPressureCompressor implements ICompressor {
    public LowPressureCompressor() {
        Blade[] blades = new Blade[30];

        for (int i = 0; i < blades.length; i++) {
            blades[i] = new LShapedBlade(11);
        }
    }

    @Override
    public void accept(ITechnician techniker) {
        techniker.visit(this);
    }
}