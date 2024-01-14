package dhbw.mosbach.observer;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private List<IOverheatListener> listeners = new ArrayList<>();

    public void addListener(IOverheatListener listener){
        listeners.add(listener);
    }

    public void removeListener(IOverheatListener listener){
        listeners.remove(listener);
    }

    public void alarm(){
        for (IOverheatListener listener : listeners){
            listener.overheated();
        }
    }
}
