import dhbw.mosbach.command.ICommand;
import dhbw.mosbach.command.SetSpeedCommand;
import dhbw.mosbach.command.StartCommand;
import dhbw.mosbach.decorator.LogStringDecorator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestObserver {

    private TestUtils tu;
    public TestObserver(){
        this.tu = new TestUtils();
    }

    @Test
    public void testSetSpeedCommand() {
        ICommand s = new StartCommand(tu.getJetEngine(), new LogStringDecorator(tu.getServiceCenter()), "test");
        tu.getCentralUnit().setCommand(s);
        tu.getCentralUnit().execute();

        s = new SetSpeedCommand(tu.getJetEngine(), 10000);
        tu.getCentralUnit().setCommand(s);
        tu.getCentralUnit().execute();
        assertFalse(tu.getJetEngine().isStarted());
    }

}
