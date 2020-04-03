package com.codesaid.lib_core.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created By codesaid
 * On :2020-04-02 20:50
 * Package Name: com.codesaid.lib_core.ui.launcher
 * desc:
 */
public class LauncherHolderCreator implements CBViewHolderCreator<LauncherHolder> {

    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
