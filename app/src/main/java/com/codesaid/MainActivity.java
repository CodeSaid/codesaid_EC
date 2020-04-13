package com.codesaid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.codesaid.lib_core.activitys.ProxyActivity;
import com.codesaid.lib_core.delegates.CodeSaidDelegate;
import com.codesaid.lib_ec.sign.SignUpDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public CodeSaidDelegate setRootDelegate() {
        return new SignUpDelegate();
    }
}
