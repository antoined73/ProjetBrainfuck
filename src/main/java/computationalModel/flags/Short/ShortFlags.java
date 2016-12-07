package computationalModel.flags.Short;

import computationalModel.flags.Flags;

/**
 * Created by Thomas TETU on 04/12/2016.
 */

public abstract class ShortFlags implements Flags {

    String filePath;

    public ShortFlags(String filePath){
        this.filePath = filePath;
    }

    protected ShortFlags() {
    }
}
