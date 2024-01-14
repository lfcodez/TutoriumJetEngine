package dhbw.mosbach.observer.chamber;
import dhbw.mosbach.observer.Sensor;

public class CombustionChamber {
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
}