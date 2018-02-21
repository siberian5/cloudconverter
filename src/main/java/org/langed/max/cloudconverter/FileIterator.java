package org.langed.max.cloudconverter;

import org.langed.max.cloudconverter.Utils;
import org.langed.max.cloudconverter.chainLinks.ChainLink;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by max on 08.02.18.
 */
public class FileIterator {

    ChainLink chain;

    public FileIterator(ChainLink next) {
        this.chain = next;
    }

    /**
     * Считывает внутренности из файлов в строковые массивы и передаёт каждый далее по цепочке
     * @param files
     */
    public void readFiles (File[] files) {

        Queue<String> fileContents = new LinkedList<>();
        int filesDone = 0;

        for(File file : files) {
                System.out.println("reading : "+file.getName());

            try (BufferedReader vCardStrings = new BufferedReader( new FileReader(file))) {

                String line;
                while ((line = vCardStrings.readLine()) != null) {

                    fileContents.add(line);
                }

            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                fileContents.clear();
            }
            chain.doChain(Utils.flushToStringAray(fileContents));
            System.out.println("          " + file.getName() + " done.\n\n");
            filesDone++;
        }

        System.out.println("Total: " + filesDone + " files");
    }

}


