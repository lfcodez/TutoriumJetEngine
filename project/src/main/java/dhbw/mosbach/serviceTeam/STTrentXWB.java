package dhbw.mosbach.serviceTeam;

import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.builder.Model;

public class STTrentXWB extends ServiceTeam{
    public void doService(String s, JetEngine jetEngine){
        if (canHandle(jetEngine, Model.TrentXWB)) {
            this.teamLeader.doAction(s, jetEngine);
        } else {
            super.doService(s, jetEngine);
        }
    }
}
