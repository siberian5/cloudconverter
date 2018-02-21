package org.langed.max.cloudconverter.chainLinks;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class SawnStringsJoinerTest {

    @Test
    public void testProcess() throws Exception {
        SawnStringsJoiner ssj = new SawnStringsJoiner(null);

        String[] data = {"one","two=","three"};
        String[] mustBe = {"one","twothree"};
        String[] got = ssj.process(data);

        assertArrayEquals(mustBe, got);
    }
}