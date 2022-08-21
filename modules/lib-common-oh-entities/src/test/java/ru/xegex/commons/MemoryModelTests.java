package ru.xegex.commons;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.xegex.commons.entities.TestEntity;
import ru.xegex.commons.mm.MemoryModel;
import ru.xegex.commons.mm.X64CompressedOopsMM;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MemoryModelTests {
    private MemoryModel mm;

    @Before
    public void init() {
        mm = new X64CompressedOopsMM();
    }

    @Test
    public void getMemoryModelTest() {
        int offset = mm.defineMemoryModel();
        Assert.assertTrue(Arrays.asList(4, 8).contains(offset));
    }

    @Test
    public void testJavaVersion() {
        boolean res = false;
        List<Integer> supportedVersions = Arrays.asList(8, 11);
        int ver = mm.javaVersion();
        Assert.assertTrue(supportedVersions.contains(ver));
    }

    @Test
    public void testDefineOffset() {
        long offset = mm.defineOffsets();
        Assert.assertTrue(Arrays.asList(4L, 8L).contains(offset));
    }

    @Test
    public void testShallowSizeOf() {
        TestEntity testEntity = new TestEntity();
        long size = mm.sizeOf(testEntity);
        assertEquals(32L, size);
    }

    @Test
    public void testIsCompressed() {
        boolean compressed = mm.isCompressed();
        Assert.assertTrue(compressed);
    }

    @Test
    public void testShallowCloneSimpleInteger() {
        Integer int1 = 10000;
        Integer int2 = 20000;

        var result = mm.clone(int1, int2);
        Assert.assertTrue(result);
        Assert.assertEquals(int1, int2);
    }

    @Test
    public void testShallowCloneComplexClass() {
        var testEntity0 = new TestEntity();
        testEntity0.setId(1L);
        testEntity0.setIVal(1);
        testEntity0.setDVal(0.1);
        testEntity0.setLVal(2L);
        testEntity0.setFVal(0.2F);

        var testEntity1 = new TestEntity();
        testEntity1.setId(2L);
        testEntity1.setIVal(2);
        testEntity1.setDVal(0.2);
        testEntity1.setLVal(3L);
        testEntity1.setFVal(0.3F);

        var result = mm.clone(testEntity0, testEntity1);
        Assert.assertTrue(result);
        Assert.assertEquals(testEntity0, testEntity1);
    }

}