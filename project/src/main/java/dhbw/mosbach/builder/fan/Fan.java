package dhbw.mosbach.builder.fan;


import dhbw.mosbach.builder.blade.Blade;
import dhbw.mosbach.builder.blade.RShapedBlade;
import dhbw.mosbach.builder.blade.SShapedBlade;

public class Fan {
    public Fan() {
        Blade[] blades = new Blade[48];

        for (int i = 0; i < blades.length; i++) {
            if (i % 2 == 0) {
                blades[i] = new SShapedBlade(11.2);
            } else {
                blades[i] = new RShapedBlade(11.4);
            }
        }
    }
}