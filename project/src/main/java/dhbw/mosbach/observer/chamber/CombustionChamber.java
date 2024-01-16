package dhbw.mosbach.observer.chamber;
import dhbw.mosbach.observer.Sensor;
import dhbw.mosbach.visitor.ITechnician;

public class CombustionChamber implements ICombustionChamber {
    private double temperature;
    private final Sensor sensor;

    public CombustionChamber(){
        this.sensor = new Sensor();
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        if (temperature > 800) {
            sensor.alarm();
        }

    }

    public String toString() {
        return "{ CombustionChamber : temperature = " + temperature + " }";
    }

    @Override
    public void accept(ITechnician techniker) {
        techniker.visit(this);
    }

    public double getTemperature() {
        return temperature;
    }
}