package dhbw.mosbach.command;

import dhbw.mosbach.builder.JetEngine;

public class ShutDownCommand implements ICommand {

    private final JetEngine jetEngine;

    public ShutDownCommand(JetEngine jetEngine) {
        this.jetEngine = jetEngine;
    }

    @Override
    public void execute() {
        jetEngine.shutdown();
    }
}