package dhbw.mosbach;

import dhbw.mosbach.command.ICommand;
import dhbw.mosbach.observer.IOverheatListener;
import dhbw.mosbach.observer.Sensor;

import java.util.Map;

public class CentralUnit implements IOverheatListener {

    Map<String, ICommand> commandos;
    private ICommand command;

    public void setCommandos(Map<String, ICommand> commandos) {
        this.commandos = commandos;
    }

    public void setCommand(String command) {
        this.command = commandos.get(command);
    }

    public void execute(){
        command.execute();
    }

    @Override
    public void overheated() {
        setCommand("emergency");
        execute();
    }
}
