package org.anton.utils.registry.interaction;

import net.dv8tion.jda.api.events.Event;
import org.anton.utils.registrable.interaction.RegistrableInteractionEventHandler;
import org.anton.utils.registry.Registry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class InteractionHandlersRegistryImpl<T extends RegistrableInteractionEventHandler>
        implements InteractionHandlersRegistry<T> {

    protected final Map<String, T> registryMap;

    protected InteractionHandlersRegistryImpl() {
        registryMap = new ConcurrentHashMap<>();
    }

    @Override
    public abstract void putObject(T object);

    @SafeVarargs
    public final void putObject(T... objects) {
        for (T command : objects) this.putObject(command);
    }

    @Override
    public HashSet<String> getObjectsKeys() {
        return new HashSet<>(registryMap.keySet());
    }

    @Override
    public ArrayList<T> getObjects() {
        return new ArrayList<>(registryMap.values());
    }

    @Override
    public T getObjectByKey(String key) {
        return registryMap.get(key);
    }

}
