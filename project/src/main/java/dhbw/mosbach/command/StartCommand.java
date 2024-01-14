package dhbw.mosbach.command;

import dhbw.mosbach.builder.JetEngine;

public class StartCommand implements ICommand {

    private final JetEngine jetEngine;

    public StartCommand(JetEngine jetEngine) {
        this.jetEngine = jetEngine;
    }

    @Override
    public void execute() {
        jetEngine.start();
    }
}
