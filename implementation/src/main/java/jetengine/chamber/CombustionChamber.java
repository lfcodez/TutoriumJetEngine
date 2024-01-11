package jetengine.chamber;

public class CombustionChamber {
    private double temperature;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String toString() {
        return "{ CombustionChamber : temperature = " + temperature + " }";
    }
}