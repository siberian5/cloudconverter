package org.langed.max.cloudconverter.chainLinks;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuotedPrintableCharsetUTF8TranslatorTest {

    @Test
    public void testProcess() throws Exception {

        QuotedPrintableCharsetUTF8Translator translator = new QuotedPrintableCharsetUTF8Translator(null);

        String[] data = {"TITLE:=D0=94.=D1=80. 16 =D0=BC=D0=B0=D1=8F","two"};
        String[] mustBe = {"TITLE:Д.р. 16 мая","two"};
        String[] got = translator.process(data);

        assertArrayEquals(mustBe, got);
    }
}