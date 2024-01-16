package dhbw.mosbach.command;

import dhbw.mosbach.builder.JetEngine;

public class SetSpeedCommand implements ICommand {

    private final JetEngine jetEngine;
    private int speed = 0;

    public SetSpeedCommand(JetEngine jetEngine, int speed) {
        this.speed = speed;
        this.jetEngine = jetEngine;
    }

    @Override
    public void execute() {
        jetEngine.setSpeed(speed);
    }
}
