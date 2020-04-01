package com.codesaid.lib_core.utils.timer;

import java.util.TimerTask;

/**
 * Created By codesaid
 * On :2020-03-29 20:24
 * Package Name: com.codesaid.lib_core.utils.timer
 * desc:
 */
public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener timerListener) {
        this.mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}
