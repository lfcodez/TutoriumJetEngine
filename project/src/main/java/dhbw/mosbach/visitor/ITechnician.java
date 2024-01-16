package dhbw.mosbach.visitor;

import dhbw.mosbach.builder.compressor.ICompressor;
import dhbw.mosbach.builder.turbine.ITurbine;
import dhbw.mosbach.observer.chamber.ICombustionChamber;

public interface ITechnician {

    public void visit(ITurbine turbine);
    public void visit(ICompressor compressor);
    public void visit(ICombustionChamber combustionChamber);
}
