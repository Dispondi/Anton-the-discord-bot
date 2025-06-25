package org.anton.utils.registry;

public interface RegistryKeeper<RegClass extends Registry<?,?>> {

    RegClass getRegistry();

    void setRegistry(RegClass registry);
}
