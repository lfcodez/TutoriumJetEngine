package dhbw.mosbach.serviceteam;

import dhbw.mosbach.builder.JetEngine;

import java.util.ArrayList;
import java.util.List;

public abstract class TeamMember {
    private List<TeamMember> subordinates;

    public TeamMember(){
        subordinates = new ArrayList<>();
    }

    public TeamMember addMember(TeamMember teamMember){
        this.subordinates.add(teamMember);

        return this;
    }

    public abstract void doAction(String s, JetEngine jetEngine);

    protected List<TeamMember> getSubordinates() {
        return subordinates;
    }




}
