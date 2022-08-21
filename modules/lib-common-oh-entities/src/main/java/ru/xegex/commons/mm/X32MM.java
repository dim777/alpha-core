package ru.xegex.commons.mm;

import jdk.internal.misc.Unsafe;

import java.util.List;

public class X32MM implements MemoryModel {
    @Override
    public Unsafe getUnsafe() {
        return null;
    }

    @Override
    public List<Integer> javaSupportedVersions() {
        return null;
    }

    @Override
    public long sizeOf(Object o) {
        return 0;
    }

    @Override
    public long getInstanceAddress(Object o) {
        return 0;
    }

    @Override
    public long getKlassAddress(Object o) {
        return 0;
    }
}
