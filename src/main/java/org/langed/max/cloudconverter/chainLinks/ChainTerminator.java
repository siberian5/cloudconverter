package org.langed.max.cloudconverter.chainLinks;

/**
 * Created by max on 17.02.18.
 */
abstract public class ChainTerminator extends ChainLink{
    public ChainTerminator() {
        super(null);
    }

    public String[] process(String[] chunk) {
        processLast(chunk);
        return null;
    }

    abstract public void processLast(String[] chunk);
}
