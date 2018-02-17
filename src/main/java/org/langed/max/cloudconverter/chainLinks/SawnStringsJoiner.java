package org.langed.max.cloudconverter.chainLinks;

import org.langed.max.cloudconverter.Utils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by max on 08.02.18.
 */
public class SawnStringsJoiner extends ChainLink {

    public static final String EQ = "=";

    public SawnStringsJoiner(ChainLink next) {
        super(next);
    }

    private final Deque<String> deque = new LinkedList<>();

    public String[] process(String[] in) {

        for (String line : in) {
            if (deque.isEmpty()) {
                deque.addLast(line);
            } else {
                if (deque.peekLast().endsWith(EQ)) {
                    String prevLine = deque.pollLast();
                    String combinedLine = prevLine.substring(0, prevLine.length() - 1) + line;
                    deque.addLast(combinedLine);
                } else {
                    deque.addLast(line);
                }
            }
        }

        return Utils.flushToStringAray(deque);
    }
}
