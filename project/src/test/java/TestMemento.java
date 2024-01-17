import dhbw.mosbach.builder.configuration.ParameterConfiguration;
import dhbw.mosbach.builder.configuration.ParameterP1Enums;
import dhbw.mosbach.builder.configuration.ParameterP4Enums;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMemento {

    ParameterConfiguration parameterConfiguration;
    public TestMemento(){
        parameterConfiguration = new ParameterConfiguration.Builder().p1(ParameterP1Enums.ENABLED).p2(1.5).p3(false).p4(ParameterP4Enums.A).p5(1).build();

    }

    @Test
    public void testUndo(){

        parameterConfiguration.setP1(ParameterP1Enums.DISABLED);
        assertEquals(ParameterP1Enums.DISABLED, parameterConfiguration.getP1());

        parameterConfiguration.undo();
        assertEquals(ParameterP1Enums.ENABLED, parameterConfiguration.getP1());

    }

}
