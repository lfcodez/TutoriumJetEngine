package dhbw.mosbach.serviceTeam;

import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.proxy.IConfigurationRO;

import java.util.ArrayList;
import java.util.List;

public abstract class TeamMember {
    protected TeamMember parentMember;
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
