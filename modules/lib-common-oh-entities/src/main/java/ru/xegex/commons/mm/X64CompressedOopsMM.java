package ru.xegex.commons.mm;

import jdk.internal.misc.Unsafe;
import ru.xegex.commons.XCommonsEx;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * X64 memory model implementation
 *
 * @author dim777
 */
public class X64CompressedOopsMM implements MemoryModel {
    private static final Integer[] JAVA_SUPPORTED_VERSIONS = {8, 11};

    @Override
    public Unsafe getUnsafe() {
        Unsafe unsafe = null;
        try {
            Constructor<Unsafe> constructor = Unsafe.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            unsafe = constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (Objects.isNull(unsafe)) throw new XCommonsEx("Unsafe instance is null");
        return unsafe;
    }

    @Override
    public List<Integer> javaSupportedVersions() {
        Stream<Integer> versions = Stream.of(JAVA_SUPPORTED_VERSIONS);
        return versions.collect(Collectors.toList());
    }

    @Override
    public long sizeOf(Object o) {
        if (Objects.isNull(o)) throw new XCommonsEx("Object is null");

        var unsafe = getUnsafe();
        Set<Field> fields = new HashSet<>();
        Class c = o.getClass();
        while (c != Object.class) {
            for (Field f : c.getDeclaredFields()) {
                if ((f.getModifiers() & Modifier.STATIC) == 0) {
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }

        // get offset
        long maxSize = 0;
        for (Field f : fields) {
            long offset = unsafe.objectFieldOffset(f);
            if (offset > maxSize) {
                maxSize = offset;
            }
        }

        return ((maxSize / 8) + 1) * 8;   // padding
    }

    @Override
    public long getInstanceAddress(Object o) {
        if (Objects.isNull(o)) throw new XCommonsEx("Object is null");

        Object[] array = new Object[]{o};
        long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
        return norm(getUnsafe().getInt(array, baseOffset)) << 3;
    }

    @Override
    public long getKlassAddress(Object o) {
        if (Objects.isNull(o)) throw new XCommonsEx("Object is null");
        // the offset of the _metadata field inside an object instance, this stores the
        // address of the shared class instance
        // same as native word
        long klassOffset = 8L;
        int klassAddress = getUnsafe().getInt(o, klassOffset);
        return norm(klassAddress) << 3;
    }
}
