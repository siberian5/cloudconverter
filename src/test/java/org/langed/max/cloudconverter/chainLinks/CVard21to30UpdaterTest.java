package org.langed.max.cloudconverter.chainLinks;

import org.junit.Test;

import static org.junit.Assert.*;

public class CVard21to30UpdaterTest {

    @Test
    public void testProcess() throws Exception {
        CVard21to30Updater updater = new CVard21to30Updater(null);

        String[] data = {"BEGIN:VCARD",
                         "VERSION:2.1",
                         "N:Шлюз Ателье;;;;",
                         "TEL;VOICE;PREF:+71234567890",
                         "END:VCARD"};


        String[] mustBe = {"BEGIN:VCARD",
                "VERSION:3.0",
                "N:Шлюз Ателье;;;;",
                "TEL;VOICE;PREF:+71234567890",
                "FN:Шлюз Ателье",
                "END:VCARD"};

        String[] got = updater.process(data);

        assertArrayEquals(mustBe, got);
    }
}