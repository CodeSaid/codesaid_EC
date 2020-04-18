package com.codesaid.lib_core.wechat;

/**
 * Created By codesaid
 * On :2020-04-18 21:28
 * Package Name: com.codesaid.lib_core.wechat
 * desc:
 */
public abstract class BaseWXEntryActivity extends BaseWXActivity {

    /**
     * 用户登录成功后回调
     *
     * @param userInfo 用户信息
     */
    protected abstract void onSignInSuccess(String userInfo);
}
