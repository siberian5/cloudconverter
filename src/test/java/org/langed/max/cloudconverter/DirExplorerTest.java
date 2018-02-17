package org.langed.max.cloudconverter;

import junit.framework.TestCase;
import org.langed.max.cloudconverter.chainLinks.ChainLink;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

public class DirExplorerTest extends TestCase {

    private Set<String> files;
    private String userDir;

    public void setUp() throws Exception {
        super.setUp();

        userDir = System.getProperty("user.dir");
        File f = new File(userDir);
        files = new HashSet<>();
        for( File file1 : f.listFiles()) {
            if(file1.isFile()) {
                files.add(file1.getName());
            }
        }
    }

    public void tearDown() throws Exception {

    }


    //TODO Допинать тест! Чего проверяем?
    public void testExploreFiles() throws Exception {
        ChainLink fp = mock(ChainLink.class);
        when(fp.process((String[])any())).thenReturn(null);
        DirExplorer.exploreFiles(userDir,fp);
    }
}