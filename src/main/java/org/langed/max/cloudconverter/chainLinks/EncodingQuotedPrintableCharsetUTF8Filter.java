package org.langed.max.cloudconverter.chainLinks;

import org.langed.max.cloudconverter.chainLinks.ChainLink;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by max on 08.02.18.
 */
public class EncodingQuotedPrintableCharsetUTF8Filter extends ChainLink {

    public static final Pattern PATTERN = Pattern.compile(";ENCODING=QUOTED-PRINTABLE;CHARSET=utf-8");
    public static final String EMPTY = "";


    public EncodingQuotedPrintableCharsetUTF8Filter(ChainLink next) {
        super(next);
    }


    public void process(String[] in) {

        List<String> filteredContents = new ArrayList<>(in.length);

        for (String line : in) {
            filteredContents.add(filter(line));
        }
        System.out.println("\t\t\tcharset headings deleted");


        String[] strings = new String[filteredContents.size()];
        strings = filteredContents.toArray(strings);

        next.process(strings);

    }


/*
    public static void main(String[] args) {
        EncodingCharsetFilter test = new EncodingCharsetFilter("");

        System.out.println("TITLE;ENCODING=QUOTED-PRINTABLE;CHARSET=utf-8:=D0=94.=D1=80. 16 =D0=BC=D0=B0=D1=8F  ->");
        System.out.println(test.filter("TITLE;ENCODING=QUOTED-PRINTABLE;CHARSET=utf-8:=D0=94.=D1=80. 16 =D0=BC=D0=B0=D1=8F"));
    }
*/

    private String filter(String str) {

        Matcher matcher =
                PATTERN.matcher(str);

        return matcher.replaceAll(EMPTY);

    }
}
