package dhbw.mosbach.serviceteam;

import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.builder.Model;

public abstract class ServiceTeam {

    private ServiceTeam successor;
    protected TeamMember teamLeader;

    public ServiceTeam() {
        teamLeader = new Supervisor();

        TeamMember otm = new OperationTeamManager().addMember(new TechnicalEngineer()).addMember(new TechnicalEngineer()).addMember(new TechnicalEngineer());
        TeamMember etm = new EmergencyTeamManager().addMember(new Technician()).addMember(new Technician()).addMember(new Technician());
        teamLeader.addMember(otm).addMember(etm);
    }

    public void doService(String s, JetEngine jetEngine){
        System.out.println("Not responsible!");
        if (getSuccessor() != null) {
            getSuccessor().doService(s, jetEngine);
        } else {
            System.out.println("no Team for service!");
        }
    }
    protected boolean canHandle(JetEngine jetEngine, Model model){
        return jetEngine.getModel() == model;
    }

    public ServiceTeam getSuccessor() {
        return successor;
    }

    public void setSuccessor(ServiceTeam successor) {
        this.successor = successor;
    }
}
