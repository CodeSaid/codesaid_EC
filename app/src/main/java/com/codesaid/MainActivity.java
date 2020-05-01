package com.codesaid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.codesaid.lib_core.activitys.ProxyActivity;
import com.codesaid.lib_core.app.CodeSaid;
import com.codesaid.lib_core.delegates.CodeSaidDelegate;
import com.codesaid.lib_core.ui.launcher.ILauncherListener;
import com.codesaid.lib_core.ui.launcher.OnLauncherFinishTag;
import com.codesaid.lib_ec.launcher.LauncherDelegate;
import com.codesaid.lib_ec.main.EcBottomDelegate;
import com.codesaid.lib_ec.sign.ISignListener;
import com.codesaid.lib_ec.sign.SignInDelegate;

public class MainActivity extends ProxyActivity implements ILauncherListener, ISignListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        CodeSaid.getConfigurator().withActivity(this);
    }

    @Override
    public CodeSaidDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this, "启动结束，用户登录", Toast.LENGTH_SHORT).show();
                startWithPop(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this, "启动结束，用户未登录", Toast.LENGTH_SHORT).show();
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
