import dhbw.mosbach.serviceTeam.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class Composite {

    @Test
    public void testStructure(){
        TeamMember team = mock(Supervisor.class);
        OperationTeamManager oTM = mock(OperationTeamManager.class);
        EmergencyTeamManager eTM = mock(EmergencyTeamManager.class);

        when(team.addMember(Mockito.any())).thenReturn(team);
        when(oTM.addMember(Mockito.any())).thenReturn(oTM);
        when(eTM.addMember(Mockito.any())).thenReturn(eTM);

        oTM.addMember(new TechnicalEngineer()).addMember(new TechnicalEngineer()).addMember(new TechnicalEngineer());
        eTM.addMember(new Technician()).addMember(new Technician()).addMember(new Technician());
        team.addMember(new Technician()).addMember(new Technician());

        verify(team, times(2)).addMember(Mockito.any());
        verify(oTM, times(3)).addMember(Mockito.any());
        verify(eTM, times(3)).addMember(Mockito.any());

    }
}
