package com.codesaid.lib_ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.codesaid.lib_core.delegates.CodeSaidDelegate;
import com.codesaid.lib_core.utils.timer.BaseTimerTask;
import com.codesaid.lib_core.utils.timer.ITimerListener;
import com.codesaid.lib_ec.R;
import com.codesaid.lib_ec.R2;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created By codesaid
 * On :2020-03-29 20:15
 * Package Name: com.codesaid.lib_ec.launcher
 * desc: 启动页
 */
public class LauncherDelegate extends CodeSaidDelegate implements ITimerListener {

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {

    }

    private Timer mTimer = null;
    private int mCount = 5;

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                        }
                    }
                }
            }
        });
    }
}
