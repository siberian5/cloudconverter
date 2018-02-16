package org.langed.max.cloudconverter;

//import com.sun.istack.internal.NotNull;

import org.langed.max.cloudconverter.chainLinks.ChainLink;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by max on 08.02.18.
 */
public class DirExplorer {

    public static void exploreFiles(String path, ChainLink fp) {
        File dir = new File(path);
        int filesDone = 0;
        for (File file : dir.listFiles()) {
            if (file.isFile())  {
                System.out.println("reading : "+file.getName());
                fp.process(readContents(file));
                System.out.println("          " + file.getName() + " done.\n\n");
                filesDone++;

            }
        }
        System.out.println("total done: "+filesDone);
    }

    private static String[] readContents(File file) {


        List<String> fileContents = new LinkedList<>();

        try (BufferedReader vCardStrings = new BufferedReader( new FileReader(file))) {

            String line;
            while ((line = vCardStrings.readLine()) != null) {

                fileContents.add(line);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        String[] strings = new String[fileContents.size()];
        strings = fileContents.toArray(strings);

        return strings;

    }
}

