import dhbw.mosbach.serviceTeam.STTrent1000;
import dhbw.mosbach.serviceTeam.STTrent900;
import dhbw.mosbach.serviceTeam.STTrentXWB;
import dhbw.mosbach.serviceTeam.ServiceTeam;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CoR {


    @Test
    public void testChain() {
        TestUtils tu = new TestUtils();
        String s = "s";
        ServiceTeam serviceTeam = mock(STTrent1000.class);
        ServiceTeam s900 = mock(STTrent900.class);
        ServiceTeam sXWB = mock(STTrentXWB.class);

        doCallRealMethod().when(sXWB).setSuccessor(s900);
        doCallRealMethod().when(serviceTeam).setSuccessor(sXWB);
        sXWB.setSuccessor(s900);
        serviceTeam.setSuccessor(sXWB);

        doAnswer(invocation -> {
            sXWB.doService(s, tu.getJetEngine());
            return null;
        }).when(serviceTeam).doService(s, tu.getJetEngine());

        doAnswer(invocation -> {
            s900.doService(s, tu.getJetEngine());
            return null;
        }).when(sXWB).doService(s, tu.getJetEngine());

        serviceTeam.doService(s, tu.getJetEngine());

        verify(serviceTeam).doService(s, tu.getJetEngine());
        verify(sXWB).doService(s, tu.getJetEngine());
        verify(s900).doService(s, tu.getJetEngine());
    }


}
