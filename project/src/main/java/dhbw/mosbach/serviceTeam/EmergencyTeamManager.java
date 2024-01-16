package dhbw.mosbach.serviceTeam;

import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.builder.configuration.ParameterP4Enums;
import dhbw.mosbach.proxy.Proxy;

public class EmergencyTeamManager extends TeamMember{
    @Override
    public void doAction(String s, JetEngine jetEngine) {
        System.out.println("Emergency Operation");
        Proxy.INSTANCE.changeConfig(this, "p4", ParameterP4Enums.C.toString());
        getSubordinates().get((int) (Math.random()*getSubordinates().size())).doAction(s, jetEngine);
    }
}
