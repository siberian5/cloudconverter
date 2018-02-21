package org.langed.max.cloudconverter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.langed.max.cloudconverter.chainLinks.ChainLink;

import java.io.File;
import java.util.*;

import static org.junit.Assert.*;

public class VCFDirExplorerTest {

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
    public void testExploreFiles() throws Exception {


/*
        FileIterator fi = mock(FileIterator.class); //  Заглушка с интерфейсом

        doThrow(new Exception()).when(fi).readFiles(any(File[].class));     // воид-методам нельзя назначать поведение.
//        Поэтому действуем по формуле:
//        doThrow(exception).when(mock).someVoidMethod();
//        any(File[].class) - значит аргументом может быть любой массив файлов (нужен рефлексивный класс массивов файлов).


*/

        final Queue<File> gotFiles = new LinkedList<>();
        FileIterator fi = new FileIterator(null) {
            public void readFiles (File[] files) {
                for (File f : files) {
                    gotFiles.add(f);
                }
           }
        };

        VCFDirExplorer.exploreFiles(userDir, fi);
        File[] got = new File[gotFiles.size()];
        for (int i = 0; i < got.length; i++) {
            got[i] = gotFiles.poll();
        }

        assertArrayEquals(fileArr, got);

    }
}

