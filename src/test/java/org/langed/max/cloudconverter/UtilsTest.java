package org.langed.max.cloudconverter;

import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class UtilsTest extends TestCase {

    public void testFlushToStringAray() throws Exception {
        String[] list = {"one","two","three"};
        Queue<String> queue = new LinkedList<>();

        for (String str : list) queue.add(str);

        String[] res = Utils.flushToStringAray(queue);
        assertArrayEquals(list, res);
        assertEquals(queue.size(), 0);
    }

    public void testAddByteArray() throws Exception {

        byte[] arrA = {1,2,3,4};
        byte[] arrB = {5,6};
        byte[] expected = {1,5,6,4};
        Utils.addByteArray(arrA, arrB , 1);
        assertArrayEquals(arrA, expected);

        byte[] arrC = {1,2,3,4};
        byte[] arrD = {5,6};
        byte[] expected2 = {5,6,3,4};
        Utils.addByteArray(arrC, arrD , 0);
        assertArrayEquals(arrC, expected2);

        byte[] arrE = {1,2,3,4};
        byte[] arrF = {5,6};
        byte[] expected3 = {1,2,5,6};
        Utils.addByteArray(arrE, arrF , 2);
        assertArrayEquals(arrE, expected3);

    }

    public void testTruncate() throws Exception {

        byte[] arrA = {1,2,3,4};
        byte[] exp1 = {1,2,3};
        byte[] exp2 = {};
        byte[] res1 = Utils.truncate(arrA, 3);
        assertArrayEquals(res1, exp1);

        byte[] res2 = Utils.truncate(arrA, 0);
        assertArrayEquals(res2, exp2);

    }
}