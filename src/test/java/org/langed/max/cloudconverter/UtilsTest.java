package org.langed.max.cloudconverter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.*;

import static org.junit.Assert.*;

public class UtilsTest {

    private File[] fileArr = null;

    @Before
    public void setUp() throws Exception {

        String userDir = System.getProperty("user.dir");

        File f = new File(userDir);
        Set<File> files = new TreeSet<>();
        for( File file1 : f.listFiles()) {
            if(file1.isFile()) {
                files.add(file1);
            }
        }

        fileArr = new File[files.size()];
        files.toArray(fileArr);

    }


    @Test
    public void testFlushToStringAray() throws Exception {
        String[] list = {"one","two","three"};
        Queue<String> queue = new LinkedList<>();

        for (String str : list) queue.add(str);

        String[] res = Utils.flushToStringAray(queue);
        assertArrayEquals(list, res);
        assertEquals(queue.size(), 0);
    }

    @Test
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

    @Test
    public void testTruncate() throws Exception {
        byte[] arrA = {1,2,3,4};
        byte[] exp1 = {1,2,3};
        byte[] exp2 = {};
        byte[] res1 = Utils.truncate(arrA, 3);
        assertArrayEquals(res1, exp1);

        byte[] res2 = Utils.truncate(arrA, 0);
        assertArrayEquals(res2, exp2);
    }


    @Test
    public void testFlushToFilesArray()  throws Exception {

        Queue<File> filesQueue = new LinkedList<>();

        for (File file : fileArr) filesQueue.add(file);

        File[] fs = Utils.flushToFilesArray(filesQueue);
        assertArrayEquals(fileArr, fs);
        assertEquals(filesQueue.size(), 0);

    }

}