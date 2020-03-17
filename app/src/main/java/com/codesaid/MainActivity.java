package com.codesaid;

import com.codesaid.lib_core.activitys.ProxyActivity;
import com.codesaid.lib_core.delegates.CodeSaidDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public CodeSaidDelegate setRootDelegate() {
        return new MainDelegate();
    }
}
