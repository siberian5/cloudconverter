package org.langed.max.cloudconverter;

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


    static public void addByteArray(byte[] target, byte[] source, int startIndex) {
        for (int i = 0; i < source.length; i++) {
            target[i+startIndex] = source[i];
        }
    }

    static public byte[] truncate(byte[] source, int volume) {
        byte[] result = new byte[volume];
        for (int i = 0; i < volume; i++) {
            result[i] = source[i];
        }
        return result;
    }

//    public static void main(String[] args) {
//        byte[] arrA = {1,2,3,4};
//        byte[] arrB = {5,6};
//
//        addByteArray(arrA, arrB , 1);
//
//        System.out.println(arrA);
//    }

}
