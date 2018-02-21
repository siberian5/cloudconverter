package org.langed.max.cloudconverter.chainLinks;

import org.langed.max.cloudconverter.Utils;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by max on 08.02.18.
 */
public class EncodingQuotedPrintableCharsetUTF8Filter extends ChainLink {

    public static final Pattern PATTERN = Pattern.compile(";ENCODING=QUOTED-PRINTABLE;CHARSET=utf-8");
    public static final String EMPTY = "";
    private final Queue<String> filteredContents = new LinkedList<>();

    public EncodingQuotedPrintableCharsetUTF8Filter(ChainLink next) {
        super(next);
    }


    /**
     * Из пачки вырезает ";ENCODING=QUOTED-PRINTABLE;CHARSET=utf-8"
     * @param in
     * @return
     */
    public String[] process(String[] in) {

        for (String line : in) {
            filteredContents.add(filter(line));
        }
        System.out.println("\t\t\tcharset headings deleted");

        return Utils.flushToStringAray(filteredContents);

    }

    private String filter(String str) {

        Matcher matcher =
                PATTERN.matcher(str);

        return matcher.replaceAll(EMPTY);

    }
}
