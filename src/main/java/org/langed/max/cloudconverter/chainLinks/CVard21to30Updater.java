package org.langed.max.cloudconverter.chainLinks;

import org.langed.max.cloudconverter.Utils;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by max on 08.02.18.
 */
public class CVard21to30Updater extends ChainLink {

    public static final String OLD_VERSION = "VERSION:2.1";
    public static final String NEW_VERSION = "VERSION:3.0";

    private final Queue<String> updatedContents = new LinkedList<>();
    public static final Pattern PATTERN = Pattern.compile("N:([^;]*);.*");

    public CVard21to30Updater(ChainLink next) {
        super(next);
    }

    public String[] process(String[] in) {

            boolean fnExists = false;
            String fn = null;

        for (String line : in) {

                if(line.equals(OLD_VERSION)) {
                    updatedContents.add(NEW_VERSION);
                }

                else if (line.startsWith("N:")) {

                    Matcher matcher =
                            PATTERN.matcher(line);

                    if (matcher.matches()) fn = matcher.group(1);
                    updatedContents.add(line);
                }
                else if (line.startsWith("FN:")) {                  // флаг вставляем
                    fnExists = true;
                    updatedContents.add(line);
                }
                else if (line.startsWith("END:") && !fnExists ) {   // если поле "FN" так и не появилось — генерируем и вставляем.
                    updatedContents.add("FN:"+fn);
                    updatedContents.add(line);
                }
                else updatedContents.add(line);              // в остальных случаях пропускаем строку как есть

        }

        return Utils.flushToStringAray(updatedContents);
    }

}
