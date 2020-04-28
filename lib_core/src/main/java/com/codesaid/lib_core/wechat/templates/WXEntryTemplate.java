package com.codesaid.lib_core.wechat.templates;

import com.codesaid.lib_core.wechat.BaseWXEntryActivity;
import com.codesaid.lib_core.wechat.MyWeChat;

/**
 * Created By codesaid
 * On :2020-04-17 21:49
 * Package Name: com.codesaid.lib_core.wechat
 * desc:
 */
public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        MyWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
