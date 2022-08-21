package tech.ineb.ats.alpha.reflection;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

import java.lang.reflect.InvocationTargetException;

public final class ReflectionsHelper {
    private final static ScanResult scanResult = new ClassGraph()
            .enableAllInfo()
            .scan();

    private ReflectionsHelper() {
    }

    public static <T> ClassInfoList findClassesAnnotatedWith(final Class<T> clazz) {
        return scanResult.getClassesWithAnnotation(clazz.getName());
    }

    public static Object loadStrategyClass(ClassInfo classInfo) throws ExWrapper {
        StrategyWrapper strategyWrapper = new StrategyWrapper(classInfo.loadClass().getName());
        return strategyWrapper.get();
    }

    static class StrategyWrapper {
        private String className;

        StrategyWrapper(String className) {
            this.className = className;
        }

        @SuppressWarnings("unchecked")
        Object get() throws ExWrapper {
            Object entity;
            try {
                Class<?> clazz = Class.forName(className);
                Class<?>[] params = {};
                entity = clazz.getConstructor(params)
                        .newInstance();
            } catch (ClassNotFoundException
                    | IllegalAccessException
                    | InstantiationException
                    | NoSuchMethodException
                    | InvocationTargetException e) {
                throw new ExWrapper(e);
            }
            return entity;
        }
    }

    static class ExWrapper extends RuntimeException {
        public ExWrapper() {
            super();
        }

        public ExWrapper(String message) {
            super(message);
        }

        public ExWrapper(String message, Throwable cause) {
            super(message, cause);
        }

        public ExWrapper(Throwable cause) {
            super(cause);
        }
    }
}
