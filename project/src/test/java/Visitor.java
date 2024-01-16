import dhbw.mosbach.builder.compressor.HighPressureCompressor;
import dhbw.mosbach.builder.compressor.ICompressor;
import dhbw.mosbach.builder.turbine.HighPressureTurbine;
import dhbw.mosbach.builder.turbine.ITurbine;
import dhbw.mosbach.observer.chamber.CombustionChamber;
import dhbw.mosbach.observer.chamber.ICombustionChamber;
import dhbw.mosbach.serviceTeam.Technician;
import dhbw.mosbach.visitor.ITechnician;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class Visitor {


    @Test
    public void testTurbine(){

        ITurbine turbine = new HighPressureTurbine();

        ITechnician technician = mock(Technician.class);
        turbine.accept(technician);

        verify(technician).visit(turbine);

    }

    @Test
    public void testCombustionChamber(){

        ICombustionChamber combustionChamber = new CombustionChamber();

        ITechnician technician = mock(Technician.class);
        combustionChamber.accept(technician);

        verify(technician).visit(combustionChamber);

    }

    @Test
    public void testCompressor(){

        ICompressor compressor = new HighPressureCompressor();

        ITechnician technician = mock(Technician.class);
        compressor.accept(technician);

        verify(technician).visit(compressor);

    }

}
