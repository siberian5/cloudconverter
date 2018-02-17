package org.langed.max.cloudconverter.chainLinks;

import java.io.*;

/**
 * Created by max on 08.02.18.
 */
public class JoinerTerminator extends ChainLink {

    private File outFile;
    public JoinerTerminator(String outFolderName) {
        super(null);
        this.outFile = new File(outFolderName + "combined.vcf");
    }

    public String[] process(String[] in) {

        try (
             BufferedWriter out = new BufferedWriter(new FileWriter(outFile, true))) {

            for(String line: in) {
                out.write(line+"\n");
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }

}
