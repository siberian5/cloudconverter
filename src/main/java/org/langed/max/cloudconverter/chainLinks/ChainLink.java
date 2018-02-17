package org.langed.max.cloudconverter.chainLinks;

/**
 * Created by max on 08.02.18.
 */
public abstract class ChainLink {

    protected ChainLink next;

    public ChainLink(ChainLink next) {
        this.next = next;
    }

    public void doChain(String[] chunk) {
        String[] nextChunk = process(chunk);
        if(null!=next) next.doChain(nextChunk);
    }

    abstract public String[] process(String[] chunk);
}
