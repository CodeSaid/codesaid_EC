package com.codesaid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.codesaid.lib_core.activitys.ProxyActivity;
import com.codesaid.lib_core.delegates.CodeSaidDelegate;
import com.codesaid.lib_ec.sign.ISignListener;
import com.codesaid.lib_ec.sign.SignUpDelegate;

public class MainActivity extends ProxyActivity implements ISignListener {

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

    @Override
    public void onSignInSuccess() {

    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }
}
