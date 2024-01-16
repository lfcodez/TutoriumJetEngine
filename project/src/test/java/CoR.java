import dhbw.mosbach.serviceTeam.STTrent1000;
import dhbw.mosbach.serviceTeam.STTrent900;
import dhbw.mosbach.serviceTeam.STTrentXWB;
import dhbw.mosbach.serviceTeam.ServiceTeam;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CoR {

    @Test
    public void testChain(){

        TestUtils tu = new TestUtils();
        String s = "s";
        ServiceTeam serviceTeam = mock(STTrent1000.class);
        ServiceTeam s900 = mock(STTrent900.class);

        ServiceTeam sXWB = mock(STTrentXWB.class);

        doCallRealMethod().when(sXWB).setSuccessor(s900);
        doCallRealMethod().when(serviceTeam).setSuccessor(sXWB);
        sXWB.setSuccessor(s900);
        serviceTeam.setSuccessor(sXWB);

        serviceTeam.doService(s, tu.getJetEngine());

        verify(serviceTeam).doService(s, tu.getJetEngine());
        verify(sXWB).doService(s, tu.getJetEngine());
        verify(s900).doService(s, tu.getJetEngine());


    }
}
