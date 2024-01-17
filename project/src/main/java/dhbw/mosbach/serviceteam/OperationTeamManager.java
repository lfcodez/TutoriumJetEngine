package dhbw.mosbach.serviceteam;

import dhbw.mosbach.builder.JetEngine;

public class OperationTeamManager extends TeamMember{
    @Override
    public void doAction(String s, JetEngine jetEngine) {
        System.out.println("Normal Operation");
        getSubordinates().get((int) (Math.random()*getSubordinates().size())).doAction(s, jetEngine);
    }
}
