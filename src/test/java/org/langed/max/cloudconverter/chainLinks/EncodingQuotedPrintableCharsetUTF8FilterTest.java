package org.langed.max.cloudconverter.chainLinks;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncodingQuotedPrintableCharsetUTF8FilterTest {

    @Test
    public void testProcess() throws Exception {
        EncodingQuotedPrintableCharsetUTF8Filter filter = new EncodingQuotedPrintableCharsetUTF8Filter(null);

        String[] data = {"TITLE;ENCODING=QUOTED-PRINTABLE;CHARSET=utf-8:=D0=94.=D1=80. 16 =D0=BC=D0=B0=D1=8F","two"};
        String[] mustBe = {"TITLE:=D0=94.=D1=80. 16 =D0=BC=D0=B0=D1=8F","two"};
        String[] got = filter.process(data);

        assertArrayEquals(mustBe, got);
    }
}
