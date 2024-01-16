package dhbw.mosbach;

import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.command.EmergencyShutDownCommand;
import dhbw.mosbach.command.ICommand;
import dhbw.mosbach.observer.IOverheatListener;

public class CentralUnit implements IOverheatListener {

    private ICommand command;

    private JetEngine jetEngine;

    private ServiceCenter serviceCenter;

    public void setServiceCenter(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    public void setJetEngine(JetEngine jetEngine) {
        this.jetEngine = jetEngine;
        this.serviceCenter = new ServiceCenter(jetEngine);
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

    @Override
    public void overheated() {
        setCommand(new EmergencyShutDownCommand(this.jetEngine));
        execute();
    }
}
