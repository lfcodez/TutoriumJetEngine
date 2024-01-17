import dhbw.mosbach.adapter.IConnector;
import dhbw.mosbach.adapter.ThreePinAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdapter {

    @Test
    public void testAdapter(){
        IConnector connector = new ThreePinAdapter();
        assertEquals(3, connector.getData().length);
        assertNotNull(connector.getData()[0]);
    }
}
