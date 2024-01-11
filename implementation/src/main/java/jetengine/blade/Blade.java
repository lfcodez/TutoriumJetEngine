package jetengine.blade;

public abstract class Blade {
    protected BladeShape shape;
    protected double weight;

    public Blade(double weight) {
        this.weight = weight;
    }

    public void setShape(BladeShape shape) {
        this.shape = shape;
    }
}