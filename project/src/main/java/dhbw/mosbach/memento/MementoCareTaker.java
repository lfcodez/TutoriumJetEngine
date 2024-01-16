package dhbw.mosbach.memento;

import dhbw.mosbach.builder.configuration.ParameterConfiguration;

public class MementoCareTaker {
    ParameterConfigurationMemento parameterConfigurationMemento;

    public ParameterConfigurationMemento getParameterConfigurationMemento() {
        return this.parameterConfigurationMemento;
    }

    public void setParameterConfigurationMemento(ParameterConfigurationMemento parameterConfigurationMemento) {
        this.parameterConfigurationMemento = parameterConfigurationMemento;
    }
}
