package dhbw.mosbach.builder.compressor;


import dhbw.mosbach.builder.blade.Blade;
import dhbw.mosbach.builder.blade.RShapedBlade;
import dhbw.mosbach.visitor.ITechnician;

public class HighPressureCompressor implements ICompressor{
    private final Blade[] blades;

    public HighPressureCompressor() {
        blades = new Blade[28];
    }

    public void build() {
        for (int i = 0; i < blades.length; i++) {
            blades[i] = new RShapedBlade(8.5);
        }
    }

    @Override
    public void accept(ITechnician techniker) {
        techniker.visit(this);

    }
}