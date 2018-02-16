package org.langed.max.cloudconverter.chainLinks;

/**
 * Created by max on 08.02.18.
 */
public abstract class ChainLink {

    protected ChainLink next;

    public ChainLink(ChainLink next) {
        this.next = next;
    }

    abstract public void process(String[] chunk);
}
