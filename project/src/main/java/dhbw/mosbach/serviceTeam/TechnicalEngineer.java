package dhbw.mosbach.serviceTeam;

import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.builder.configuration.ParameterP1Enums;
import dhbw.mosbach.proxy.Proxy;

import java.util.Arrays;

public class TechnicalEngineer extends TeamMember {
    @Override
    public void doAction(String s, JetEngine jetEngine) {
        System.out.println("Do smth.");
        System.out.println(Proxy.INSTANCE.readConfig(this));
        Proxy.INSTANCE.changeConfig(this, "p1", ParameterP1Enums.DISABLED.toString());
    }

}
