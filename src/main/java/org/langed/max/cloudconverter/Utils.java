package org.langed.max.cloudconverter;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * Created by max on 17.02.18.
 */
public class Utils {

/*    static public String[] toStringAray(List<String> list) {
        String[] strings = new String[list.size()];

        int i = 0;
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); i++) {
            strings[i] = iterator.next();
        }

        return strings;

    }*/

    static public String[] flushToStringAray(Queue<String> queue) {
        String[] strings = new String[queue.size()];

        for (int i = 0; i< strings.length; i++){
            strings[i] = queue.poll();
        }

        return strings;
    }

}
