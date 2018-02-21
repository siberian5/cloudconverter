package org.langed.max.cloudconverter.chainLinks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.langed.max.cloudconverter.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class JoinerTerminatorTest {

    File tmpDir;

    @Before
    public void setUp() throws Exception {

        String userDir = System.getProperty("user.dir");
        long rand = System.currentTimeMillis();

        File f = new File(userDir + "/" + rand);
        if (!f.mkdir()) throw new Exception("can't create temporary dir");
        tmpDir = f;
    }

    @After
    public void tearDown() throws Exception {
//        Queue<File> toDel = new LinkedList<>();
        for (File f : tmpDir.listFiles()) f.delete();
        tmpDir.delete();
    }

    @Test
    public void testProcessLast() throws Exception {


        JoinerTerminator jt = new JoinerTerminator(tmpDir.getAbsolutePath() + "/");

        String[] one = {"BEGIN:VCARD",
                "VERSION:3.0",
                "N:Шлюз Ателье;;;;",
                "TEL;VOICE;PREF:+71234567890",
                "FN:Шлюз Ателье",
                "END:VCARD"};

        String[] two = {"BEGIN:VCARD",
                "VERSION:3.0",
                "N:Шлюз Ателье;;;;",
                "TEL;VOICE;PREF:+71234567890",
                "FN:Шлюз Ателье",
                "END:VCARD"};

        jt.processLast(one);
        jt.processLast(two);

        String[] mustBe = {"BEGIN:VCARD",
                "VERSION:3.0",
                "N:Шлюз Ателье;;;;",
                "TEL;VOICE;PREF:+71234567890",
                "FN:Шлюз Ателье",
                "END:VCARD",
                "BEGIN:VCARD",
                "VERSION:3.0",
                "N:Шлюз Ателье;;;;",
                "TEL;VOICE;PREF:+71234567890",
                "FN:Шлюз Ателье",
                "END:VCARD"};

        List<String> fileContents = new LinkedList<>();

        try (BufferedReader vCardStrings = new BufferedReader(new FileReader(tmpDir + "/" + JoinerTerminator.OUTFILE))) {

            String line;
            while ((line = vCardStrings.readLine()) != null) {

                fileContents.add(line);
            }
        } catch (IOException ioe) {
            throw new Exception(ioe);
        }

        String[] got = new String[fileContents.size()];
        fileContents.toArray(got);

        assertArrayEquals(mustBe, got);
    }
}