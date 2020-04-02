package com.codesaid;

import com.codesaid.lib_core.activitys.ProxyActivity;
import com.codesaid.lib_core.delegates.CodeSaidDelegate;
import com.codesaid.lib_ec.launcher.LauncherDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public CodeSaidDelegate setRootDelegate() {
        return new LauncherDelegate();
    }
}
