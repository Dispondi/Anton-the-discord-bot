package org.anton.utils.registry;

import org.anton.utils.registrable.Registrable;

import java.util.ArrayList;
import java.util.HashSet;

public interface Registry<K, V extends Registrable<K>> {

    void putObject(V object);

    HashSet<K> getObjectsKeys();

    ArrayList<V> getObjects();

    V getObjectByKey(K key);
}
