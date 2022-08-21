package ru.xegex.commons;

import ru.xegex.commons.mm.MemoryModel;
import ru.xegex.commons.mm.X64CompressedOopsMM;

/**
 * Off heap collections fabric method
 *
 * @author dim777
 */
public class OffHeapCollections {
//    private volatile static OffHeapCollections INSTANCE;
//
//    private final Map<Class<?>, Object> offHeapEntities;
//    private final OffHeapContainer offHeapContainer;

//    private OffHeapCollections() {
//        this.offHeapEntities = new HashMap<>();
//        this.offHeapContainer = new OffHeapContainer();
//        init();
//    }
//
//    private void init() {
//        //todo: should be changed
//        MemoryModel mm = new X64CompressedOopsMM();
//
//        try (ScanResult scanResult = new ClassGraph()
//                .enableAnnotationInfo()
//                .enableFieldInfo()
//                .ignoreFieldVisibility()
//                .scan()) {
//            for (ClassInfo classInfo : scanResult.getClassesWithAnnotation(OffHeapEntity.class.getName())) {
//                FieldInfoList fieldInfoList = classInfo.getFieldInfo()
//                        .filter(fieldInfo -> nonNull(fieldInfo.getAnnotationInfo(Field.class.getName())));
//
////                long size = 0;
////                for(FieldInfo fi : fieldInfoList){
////                    TypeSignature ts = fi.getTypeDescriptor();
////                    BaseTypeSignature bt = (BaseTypeSignature) ts;
////
////                    if(bt.getType().equals(int.class) || bt.getType().equals(Integer.class)){
////                        size += 8;
////                    }
////                }
//
//                Class<?> clazz = classInfo.loadClass();
//                Object obj = clazz.getConstructor().newInstance();
//                long size = mm.sizeOf(obj);
//
//                offHeapEntities.put(clazz, obj);
//            }
//        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
//
//    class ObjectInfo {
//        Object object;
//        long objSize;
//
//    }
//
//    static OffHeapContainer container() {
//        if (isNull(INSTANCE)) {
//            synchronized (OffHeapCollections.class) {
//                if (isNull(INSTANCE)) {
//                    INSTANCE = new OffHeapCollections();
//                }
//            }
//        }
//        return INSTANCE.offHeapContainer;
//    }
//
//
//    public class OffHeapContainer {
//        private OffHeapContainer() {
//        }
//
//        @SuppressWarnings("unchecked")
//        public <E> E getEntity(Class<E> clazz) {
//            E e = (E) offHeapEntities.get(clazz);
//            if (isNull(e))
//                throw new XCommonsEx("Class name = " + clazz.getName() + " doesn't annotate as OffHeapEntity");
//            return e;
//        }
//    }
//
//    public static <E> XArrayList<E> newOffHeapList(MemoryModel mm, Class<E> clazz) {
//        var builder = XArrayList.builder(mm, clazz);
//        return builder.build();
//    }

    public static <E> XArrayList<E> newOffHeapList(Class<E> clazz) {
        MemoryModel mm = new X64CompressedOopsMM();
        return XArrayList.<E>builder()
                .clazz(clazz)
                .mm(mm)
                .segmentsLen(SegmentsLength::defaultSegmentsLength)
                .segmentLen(SegmentLength::defaultSegmentLengthStrategy)
                .segmentIdxStrategy(SegmentIndexStrategy.defaultSegmentIdxStrategy())
                .build();
    }
}
