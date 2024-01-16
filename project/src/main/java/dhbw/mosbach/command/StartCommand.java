package dhbw.mosbach.command;

import dhbw.mosbach.CentralUnit;
import dhbw.mosbach.ServiceCenter;
import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.decorator.LogStringDecorator;
import dhbw.mosbach.decorator.StringDecorator;

public class StartCommand implements ICommand {

    private final JetEngine jetEngine;
    private final StringDecorator stringDecorator;
    private final String message;
    public StartCommand(JetEngine jetEngine, StringDecorator stringDecorator,String message) {
        this.jetEngine = jetEngine;
        this.stringDecorator = stringDecorator;
        this.message = message;
    }

    @Override
    public void execute() {
        jetEngine.start();
        stringDecorator.send(stringDecorator.encrypt(stringDecorator.record(stringDecorator.hash(stringDecorator.log("engine | "+ message)))));

    }
}
