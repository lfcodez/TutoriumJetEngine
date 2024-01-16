package dhbw.mosbach.serviceTeam;

import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.builder.Model;

public class STTrent1000 extends ServiceTeam{
    public void doService(String s, JetEngine jetEngine){
        if (canHandle(jetEngine, Model.Trent1000)) {
            this.teamLeader.doAction(s, jetEngine);
        } else {
            super.doService(s, jetEngine);
        }
    }
}
