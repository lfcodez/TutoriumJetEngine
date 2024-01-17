import dhbw.mosbach.command.*;
import dhbw.mosbach.decorator.LogStringDecorator;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCommand {


    TestUtils tu;

    public TestCommand() {
        this.tu = new TestUtils();
    }

    @Order(1)
    @Test
    public void testStartCommand(){
        assertFalse(tu.getJetEngine().isStarted());
        ICommand s = new StartCommand(tu.getJetEngine(), new LogStringDecorator(tu.getServiceCenter()), "test");
        tu.getCentralUnit().setCommand(s);
        tu.getCentralUnit().execute();
        assertTrue(tu.getJetEngine().isStarted());
    }

    @Order(2)
    @Test
    public void testShutdownCommand(){
        ICommand s = new ShutDownCommand(tu.getJetEngine());
        tu.getCentralUnit().setCommand(s);
        tu.getCentralUnit().execute();
        assertFalse(tu.getJetEngine().isStarted());
    }

    @Order(3)
    @Test
    public void testEmergencyShutdownCommand(){
        ICommand s = new EmergencyShutDownCommand(tu.getJetEngine());
        tu.getCentralUnit().setCommand(s);
        tu.getCentralUnit().execute();
        assertFalse(tu.getJetEngine().isStarted());
    }

    @Order(4)
    @Test
    public void testSetSpeedCommand(){
        ICommand s = new SetSpeedCommand(tu.getJetEngine(), 150);
        tu.getCentralUnit().setCommand(s);
        tu.getCentralUnit().execute();
        assertEquals(150, tu.getCombustionChamber1().getTemperature()/1.25);
        assertEquals(150, tu.getCombustionChamber2().getTemperature()/1.25);
    }
}
