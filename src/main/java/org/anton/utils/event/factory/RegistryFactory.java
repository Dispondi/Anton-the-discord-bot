package org.anton.utils.event.factory;

import org.anton.utils.registry.Registry;

public interface RegistryFactory<T> {

    Registry<?,?> getRegistry(T type);
}
