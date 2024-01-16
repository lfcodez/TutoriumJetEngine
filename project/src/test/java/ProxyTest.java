import dhbw.mosbach.builder.configuration.ParameterConfiguration;
import dhbw.mosbach.builder.configuration.ParameterP1Enums;
import dhbw.mosbach.builder.configuration.ParameterP4Enums;
import dhbw.mosbach.proxy.Proxy;
import dhbw.mosbach.serviceTeam.EmergencyTeamManager;
import dhbw.mosbach.serviceTeam.Supervisor;
import dhbw.mosbach.serviceTeam.TechnicalEngineer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProxyTest {


    private Supervisor supervisor;
    private TechnicalEngineer technicalEngineer;
    private EmergencyTeamManager emergencyTeamManager;

    private ParameterConfiguration parameterConfiguration;

    public ProxyTest(){
        supervisor = new Supervisor();
        technicalEngineer = new TechnicalEngineer();
        emergencyTeamManager = new EmergencyTeamManager();
        parameterConfiguration = new ParameterConfiguration.Builder().p1(ParameterP1Enums.ENABLED).p2(1.5).p3(false).p4(ParameterP4Enums.A).p5(1).build();
    }

    @Test
    public void testSupervisorPrivileges(){

        Proxy.INSTANCE.setParameterConfiguration(parameterConfiguration);
        String newValue = ParameterP1Enums.DISABLED.toString();
        Proxy.INSTANCE.changeConfig(new Supervisor(), "p1", newValue );
        assertEquals(newValue, parameterConfiguration.getP1().toString());

        Proxy.INSTANCE.setParameterConfiguration(parameterConfiguration);
        Proxy.INSTANCE.changeConfig(new Supervisor(), "p3", "true" );
        assertTrue(parameterConfiguration.getP3());

        Proxy.INSTANCE.setParameterConfiguration(parameterConfiguration);
        newValue = ParameterP4Enums.B.toString();
        Proxy.INSTANCE.changeConfig(new Supervisor(), "p4",  newValue);
        assertEquals(newValue, parameterConfiguration.getP4().toString());

    }

    @Test
    public void testNoPriviliges(){

        Proxy.INSTANCE.setParameterConfiguration(parameterConfiguration);
        String newValue = ParameterP4Enums.B.toString();
        Proxy.INSTANCE.changeConfig(new TechnicalEngineer(), "p4",  newValue);
        assertEquals(ParameterP4Enums.A.toString(), parameterConfiguration.getP4().toString());

    }




}
