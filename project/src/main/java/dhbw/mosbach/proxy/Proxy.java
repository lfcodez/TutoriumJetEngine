package dhbw.mosbach.proxy;

import dhbw.mosbach.builder.configuration.ParameterConfiguration;
import dhbw.mosbach.builder.configuration.ParameterP1Enums;
import dhbw.mosbach.builder.configuration.ParameterP4Enums;
import dhbw.mosbach.serviceTeam.*;


public enum Proxy {

    INSTANCE;
    private ParameterConfiguration parameterConfiguration;

    private final IConfigurationRO ro = parameterConfiguration;
    private final IConfigurationRW13 r13 = parameterConfiguration;
    private final IConfigurationRW134 r134 = parameterConfiguration;

    public void setParameterConfiguration(ParameterConfiguration parameterConfiguration) {
        this.parameterConfiguration = parameterConfiguration;
    }

    public void changeConfig(Supervisor supervisor, String parameter, String value) {
        switch (parameter) {
            case "p1" -> {
                parameterConfiguration.setP1(Enum.valueOf(ParameterP1Enums.class, value));
                System.out.println("changed P1");
            }
            case "p3" -> {
                parameterConfiguration.setP3(Boolean.valueOf(value));
                System.out.println("changed P3");

            }
            case "p4" -> {
                parameterConfiguration.setP4(Enum.valueOf(ParameterP4Enums.class, value));
                System.out.println("changed P4");
            }
            default -> System.out.println("Not allowed!");
        }
    }

    public void changeConfig(EmergencyTeamManager emergencyTeamManager, String parameter, String value) {
        switch (parameter) {
            case "p1" -> {
                parameterConfiguration.setP1(Enum.valueOf(ParameterP1Enums.class, value));
                System.out.println("changed P1");
            }
            case "p3" -> {
                parameterConfiguration.setP3(Boolean.valueOf(value));
                System.out.println("changed P3");

            }
            default -> System.out.println("Not allowed!");
        }
    }

    public void changeConfig(TeamMember teamMember, String parameter, String value) {
        System.out.println("Not allowed");
    }

    public String readConfig(TeamMember teamMember) {
        return parameterConfiguration.readAttributes();
    }

}
