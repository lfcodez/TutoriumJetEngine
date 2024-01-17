package dhbw.mosbach.serviceteam;

import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.builder.configuration.ParameterP1Enums;
import dhbw.mosbach.proxy.Proxy;

public class Supervisor extends TeamMember {

    @Override
    public void doAction(String s, JetEngine jetEngine) {
        if (s.contains("emergency")) {

            getSubordinates().get(1).doAction(s, jetEngine);
        } else {
            Proxy.INSTANCE.changeConfig(this, "p1", ParameterP1Enums.DISABLED.toString());
            getSubordinates().get(0).doAction(s, jetEngine);
        }
    }

}
