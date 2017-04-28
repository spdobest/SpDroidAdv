package spdroid_adv.nstech.spdroid_adv.eventBos;

import org.greenrobot.eventbus.EventBus;
 
public class GlobalBus {
    private static EventBus sBus;
    public static EventBus getBus() {
        if (sBus == null)
            sBus = EventBus.getDefault();
        return sBus;
    }
}