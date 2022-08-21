package ru.xegex.commons.mm;

import jdk.internal.misc.Unsafe;
import ru.xegex.commons.XCommonsEx;

import javax.management.MBeanServer;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

/**
 * Java 8 klass.hpp
 * http://hg.openjdk.java.net/jdk8/jdk8/hotspot/file/87ee5ee27509/src/share/vm/oops/klass.hpp
 * <p>
 * //  Klass layout:
 * //    [C++ vtbl ptr  ] (contained in Metadata)
 * //    [layout_helper ] size container object
 * ...
 * <p>
 * http://hg.openjdk.java.net/jdk8/jdk8/hotspot/file/87ee5ee27509/src/share/vm/oops/oop.hpp
 * <p>
 * class oopDesc {
 * friend class VMStructs;
 * private:
 * volatile markOop  _mark;
 * union _metadata {
 * Klass*      _klass;
 * narrowKlass _compressed_klass;
 * } _metadata;
 * <p>
 * Java 11 klass.hpp
 * https://hg.openjdk.java.net/shenandoah/jdk11/file/54a6ec6eb3e5/src/hotspot/share/oops/klass.hpp
 * https://hg.openjdk.java.net/shenandoah/jdk11/file/54a6ec6eb3e5/src/hotspot/share/oops/oop.hpp
 * <p>
 * class oopDesc {
 * friend class VMStructs;
 * friend class JVMCIVMStructs;
 * private:
 * volatile markOop _mark;
 * union _metadata {
 * Klass*      _klass;
 * narrowKlass _compressed_klass;
 * } _metadata;
 */
public interface MemoryModel {
    String DATA_MODEL_PROPERTY = "sun.arch.data.model";
    String JAVA_VERSION_PROPERTY = "java.specification.version";
    String HOTSPOT_BEAN_CLASS = "com.sun.management.HotSpotDiagnosticMXBean";
    String HOTSPOT_BEAN_TYPE = "com.sun.management:type=HotSpotDiagnostic";

    Unsafe getUnsafe();

    List<Integer> javaSupportedVersions();

    long sizeOf(Object o);

    long getInstanceAddress(Object o);

    /**
     * Validate memory model (x86 or x64)
     *
     * @return result
     */
    default int defineMemoryModel() {
        String dataModel = System.getProperty(DATA_MODEL_PROPERTY);
        int bits = Integer.parseInt(dataModel);
        // 64  1000000
        // 32  0100000
        // 31  0011111
        if ((bits & 31) == 0) {
            return bits / 8;
        }
        throw new XCommonsEx("Arch is not x86 or x64.");
    }

    /**
     * Define java JAVA_VERSION
     *
     * @return JAVA_VERSION
     */
    default int javaVersion() {
        String sVer = System.getProperty(JAVA_VERSION_PROPERTY);
        int ver = Integer.parseInt(sVer);

        if (javaSupportedVersions().contains(ver)) {
            return ver;
        }

        throw new XCommonsEx("Couldn't define JAVA_VERSION");
    }

    /**
     * Is x64 compressed
     *
     * @return result
     */
    default boolean isCompressed() {
        if (defineMemoryModel() == 8) {
            try {
                final Class<?> beanClazz = Class.forName(HOTSPOT_BEAN_CLASS);
                final MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
                final Object hotSpotBean = ManagementFactory.newPlatformMXBeanProxy(mBeanServer, HOTSPOT_BEAN_TYPE, beanClazz);
                if (hotSpotBean != null) {
                    final Method getVMOptionMethod = beanClazz.getMethod("getVMOption", String.class);
                    final Object vmOption = getVMOptionMethod.invoke(hotSpotBean, "UseCompressedOops");
                    return Boolean.parseBoolean(vmOption.getClass().getMethod("getValue").invoke(vmOption).toString());
                } else {
                    throw new XCommonsEx("Error while check x64 compressed ops");
                }
            } catch (ClassNotFoundException
                    | IOException
                    | IllegalAccessException
                    | NoSuchMethodException
                    | InvocationTargetException ex) {
                throw new XCommonsEx("Error while check x64 compressed ops");
            }
        }
        return false;
    }

    default long defineOffsets() {
        if (defineMemoryModel() == 8) {  // 64 bit
            return 8; // _mark is always size container native word
        }
        return 4;
    }

    default long norm(int value) {
        if (value >= 0) {
            return value;
        }
        return (~0L >>> 32) & value;
    }

    default boolean clone(Object from, Object to) {
        if (Objects.nonNull(from) && Objects.nonNull(to)) {
            getUnsafe()
                    .copyMemory(
                            getInstanceAddress(from),
                            getInstanceAddress(to),
                            sizeOf(from)
                    );
            return true;
        }
        return false;
    }

    // Return the address of the shared class instance of the object
    long getKlassAddress(Object o);
}
