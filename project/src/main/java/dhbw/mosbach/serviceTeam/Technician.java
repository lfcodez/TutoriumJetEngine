package dhbw.mosbach.serviceTeam;

import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.builder.compressor.ICompressor;
import dhbw.mosbach.builder.turbine.ITurbine;
import dhbw.mosbach.observer.chamber.ICombustionChamber;
import dhbw.mosbach.visitor.IEnginePart;
import dhbw.mosbach.visitor.ITechnician;

import java.util.List;

public class Technician extends TeamMember implements ITechnician {
    @Override
    public void doAction(String s, JetEngine jetEngine) {
        System.out.println("Technical Engineer is doing smth.");
        List<IEnginePart> p = jetEngine.getParts();
        for (IEnginePart part : p) {
            part.accept(this);
        }

    }

    @Override
    public void visit(ITurbine turbine) {
        System.out.println("Check turbine " + turbine.hashCode());
    }

    @Override
    public void visit(ICompressor compressor) {
        System.out.println("Check compressor " + compressor.hashCode());
    }

    @Override
    public void visit(ICombustionChamber combustionChamber) {
        System.out.println("Check combustion chamber " + combustionChamber.hashCode());

    }
}
