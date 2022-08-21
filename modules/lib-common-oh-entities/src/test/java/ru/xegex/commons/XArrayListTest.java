package ru.xegex.commons;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.xegex.commons.entities.TestEntity;
import ru.xegex.commons.entities.TestEntity1;

import java.util.List;

public class XArrayListTest {
    List<TestEntity> offHeapList;

    @Before
    public void init() {
        offHeapList = OffHeapCollections.newOffHeapList(TestEntity.class);
    }

    @Test(expected = XCommonsEx.class)
    public void nullClazzInit() {
        var list = OffHeapCollections.newOffHeapList(null);

        boolean res = list.isEmpty();
        Assert.assertTrue(res);
    }

    @Test
    public void testEntityClazzInitEmptyArrAndDefaultCapacity() {
        boolean res = offHeapList.isEmpty();
        Assert.assertTrue(res);
    }

    //todo: test should be defined
    @Test
    public void testEntityClazzInitArrAndSpecifiedCapacity() {
        boolean res = offHeapList.isEmpty();
        Assert.assertTrue(res);
    }

    @Test
    public void testEntityAddAndGet() {
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

        offHeapList.add(testEntity0);
        offHeapList.add(testEntity1);

        var testEntityRes = offHeapList.get(0);
        Assert.assertEquals(testEntity0, testEntityRes);
        testEntityRes = offHeapList.get(1);
        Assert.assertEquals(testEntity1, testEntityRes);
    }

    @Test
    public void testSingletonEntity() {
        List<TestEntity1> offHeapList1 = OffHeapCollections.newOffHeapList(TestEntity1.class);

        var testEntity0 = TestEntity1.instance();
        testEntity0.setId(1L);
        testEntity0.setDVal(0.1);
        testEntity0.setLVal(2L);
        testEntity0.setFVal(0.2F);
        testEntity0.setCVal('a');

        offHeapList1.add(testEntity0);

        var testEntity1 = TestEntity1.instance();
        testEntity1.setId(2L);
        testEntity1.setDVal(0.2);
        testEntity1.setLVal(3L);
        testEntity1.setFVal(0.3F);
        testEntity1.setCVal('b');

        offHeapList1.add(testEntity1);

        var testEntityRes = offHeapList1.get(0);
        Assert.assertEquals(1L, testEntityRes.getId().longValue());
        Assert.assertEquals(0.1, testEntityRes.getDVal(), 0.00001);
        Assert.assertEquals(2L, testEntityRes.getLVal());
        Assert.assertEquals(0.2F, testEntityRes.getFVal(), 0.00001);
        Assert.assertEquals('a', testEntityRes.getCVal());
        testEntityRes = offHeapList1.get(1);
        Assert.assertEquals(testEntity1, testEntityRes);
    }

}