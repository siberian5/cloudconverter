package org.langed.max.cloudconverter;

import org.junit.Before;
import org.junit.Test;
import org.langed.max.cloudconverter.chainLinks.ChainLink;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FileIteratorTest {

    private String userDir;
    private File[] fileArr = null;


    @Before
    public void setUp() throws Exception {


        userDir = System.getProperty("user.dir");

        File f = new File(userDir);
        Set<File> files = new TreeSet<>();
        for( File file1 : f.listFiles()) {
            if(file1.isFile() && file1.getName().endsWith(".vcf")) {
                files.add(file1);
            }
        }

        fileArr = new File[files.size()];
        files.toArray(fileArr);

    }

    @Test
    public void testReadFiles() throws Exception {

//        Сосчитаем, сколько файлов было прочитано
        final Queue<Integer> files = new LinkedList<>();
        files.add(0);
        FileIterator fi = new FileIterator(
                new ChainLink(null) {
                    public String[] process(String[] chunk) {
                        files.add(files.poll()+1);
                        return null;
                    }
                }
        );

        fi.readFiles(fileArr);
        assertTrue(fileArr.length == files.poll());
    }
}