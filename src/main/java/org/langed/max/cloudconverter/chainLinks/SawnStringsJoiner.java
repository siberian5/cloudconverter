package org.langed.max.cloudconverter.chainLinks;

import org.langed.max.cloudconverter.chainLinks.ChainLink;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by max on 08.02.18.
 */
public class SawnStringsJoiner extends ChainLink {

    public SawnStringsJoiner(ChainLink next) {
        super(next);
    }


    /**
     * Публичный метод выполняет работу поэтапно:
     *      - сперва загоняет байты в очередь, pushAndFilter(c),
     *          -- попутно просеивая их
     *      - затем списывает очередь на диск.
     * @param in
     */
    public void process(String[] in) {

        next.process(in);

//        System.out.print("Cleaning "  + in.getName());
//
//        File out = new File(outFolderName + in.getName());
//
//        try (FileInputStream fis = new FileInputStream(in);
//            FileOutputStream fos = new FileOutputStream(out)) {
//
//            int c;      // считываемый байт.
//            while ((c = fis.read()) != -1) {
//                pushAndFilter(c);
//            }
//
//            writeFiltered(fos);
//        }
//        catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//
//        System.out.println("  DONE!");
    }




    private Deque<Integer> deque = new LinkedList<>();
    private void pushAndFilter(int chr) {

        if (10==chr) {

            if (13==deque.peekLast()){

                deque.pollLast();

                if (61==deque.peekLast()) {
                    deque.pollLast();
                }
                else deque.addLast(chr);

            }
            else deque.addLast(chr);

        }
        else deque.addLast(chr);

    }

    private void writeFiltered(FileOutputStream fos) throws IOException {
        for (Iterator<Integer> iter = deque.iterator(); iter.hasNext();) {
            fos.write(iter.next());
        }
        deque.clear();
    }
}
