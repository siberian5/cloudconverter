package org.langed.max.cloudconverter.chainLinks;

import java.io.*;

/**
 * Created by max on 08.02.18.
 */
public class JoinerTerminator extends ChainTerminator {

    private File outFile;
    public JoinerTerminator(String outFolderName) {
        this.outFile = new File(outFolderName + "combined.vcf");
    }

    public void processLast(String[] in) {

        try (
             BufferedWriter out = new BufferedWriter(new FileWriter(outFile, true))) {  // true for 'append mode'

            for(String line: in) {
                out.write(line+"\n");
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
