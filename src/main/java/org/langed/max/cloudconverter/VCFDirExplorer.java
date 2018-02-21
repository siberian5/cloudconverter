package org.langed.max.cloudconverter;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by max on 08.02.18.
 */
public class VCFDirExplorer {

    public static final String VCF_SUFFIX = ".vcf";

    /**
     * Метод выделяет нужныe файлы и с массивом обращается к FileIterator
     * fi.readFiles(...)
     */
    public static void exploreFiles(String path, FileIterator fi) { //throws InvalidDirException {
        File dir = new File(path);
        Queue<File> files = new LinkedList<>();

        try {
            for (File file : dir.listFiles()) {
                if (file.isFile() && file.getName().endsWith(VCF_SUFFIX))  {
                    files.add(file);
                }
            }
            fi.readFiles(Utils.flushToFilesArray(files));
        }
        catch (NullPointerException npe) {
            System.out.println("Can't read from " + path);
            npe.printStackTrace();
//            throw new InvalidDirException();
        }
    }

}

