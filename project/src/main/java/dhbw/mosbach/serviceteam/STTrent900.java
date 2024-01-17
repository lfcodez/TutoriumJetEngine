package dhbw.mosbach.serviceteam;

import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.builder.Model;

public class STTrent900 extends ServiceTeam{

    public void doService(String s, JetEngine jetEngine){
        if (canHandle(jetEngine, Model.Trent900)) {
            this.teamLeader.doAction(s, jetEngine);
        } else {
            super.doService(s, jetEngine);
        }
    }
}
