package org.langed.max.cloudconverter.chainLinks;

import org.langed.max.cloudconverter.Utils;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by max on 08.02.18.
 */
public class QuotedPrintableCharsetUTF8Translator extends ChainLink {

    private final Queue<String> translatedContents = new LinkedList<>();

    public QuotedPrintableCharsetUTF8Translator(ChainLink next) {
        super(next);
    }

    public String[] process(String[] in) {

        try {


            boolean utfSymbol = false;  // Резжим
            int got = 0;
            int[] parts = new int[4];
//            int c;      // считываемый символ, 16 бит.


            for (String line : in) {

                byte[] bytes = line.getBytes();
                byte[] resultBytes = new byte[bytes.length];
                int bytesCount = 0;

                for (byte current : bytes) {

                    if (!utfSymbol && current == 61) {
                        utfSymbol = true; // переключаем режим
                    } else if (utfSymbol && current == 61) {
                        // не делаем ничего. Это равно перед второй парой.
                    } else if (utfSymbol && current != 61) {
                        parts[got++] = current;
                        // собираем части символа. Полученный символ сваливаем на выход.
                        if (got == 4) {

                            String letter = translate(parts);
                            byte[] let = letter.getBytes();

                            Utils.addByteArray(resultBytes, let, bytesCount);
                            bytesCount += let.length;

                            got = 0;
                            utfSymbol = false;

                        }
                    } else {
                        resultBytes[bytesCount++] = current;
                    }

                }


                translatedContents.add(new String(Utils.truncate(resultBytes, bytesCount)));
            }

            return Utils.flushToStringAray(translatedContents);

        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
            return null;
        }
    }

    /**
     * @param chr
     * @return
     * @throws UnsupportedEncodingException
     */
    private String translate(int[] chr) throws UnsupportedEncodingException {

/*
    Прилетело:
        68(0x44)    D
        48(0x30)    0
        57(0x39)    9
        58(0x34)    4

    Нужно получить символ, записываемый через утф-8 как "d094", т.е. 'Д'
*/

        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte) chr[i];
        }
        String letter0 = new String(Arrays.copyOfRange(bytes, 0, 1), "UTF8");
        String letter1 = new String(Arrays.copyOfRange(bytes, 1, 2), "UTF8");
        String letter2 = new String(Arrays.copyOfRange(bytes, 2, 3), "UTF8");
        String letter3 = new String(Arrays.copyOfRange(bytes, 3, 4), "UTF8");

        String let01 = letter0 + letter1;
        String let23 = letter2 + letter3;

        int let0Int = Integer.parseInt(let01, 16);  //208
        int let1Int = Integer.parseInt(let23, 16);  //148
        byte[] newBytes = new byte[2];
        newBytes[0] = (byte) let0Int;                  //-48
        newBytes[1] = (byte) let1Int;                  //-108

        return new String(newBytes, "UTF8");

    }
}
