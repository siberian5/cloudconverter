package org.langed.max.cloudconverter;

import org.langed.max.cloudconverter.chainLinks.*;

/**
 * Created by max on 08.02.18.
 */
public class Convert {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar <thisArchive>.jar <inFolder> <outFolder>");
            System.exit(1);
        }

        String in_folder = args[0];
        String out_folder = args[1];

        System.out.println("in_folder: " + in_folder);
        System.out.println("out_folder: " + out_folder);

        ChainLink chain = new SawnStringsJoiner(
                                new EncodingQuotedPrintableCharsetUTF8Filter(
                                        new QuotedPrintableCharsetUTF8Translator(
                                                new CVard21to30Updater(
                                                        new JoinerTerminator(out_folder)
                      ))));

        DirExplorer.exploreFiles(in_folder, chain);

        System.out.println("see result in: " + out_folder);

    }
}

