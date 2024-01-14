package dhbw.mosbach.command;

import dhbw.mosbach.builder.JetEngine;

public class EmergencyShutDownCommand implements ICommand {

    private final JetEngine jetEngine;

    public EmergencyShutDownCommand(JetEngine jetEngine) {
        this.jetEngine = jetEngine;
    }

    @Override
    public void execute() {
        jetEngine.emergencyShutdown();
    }
}
