package com.codesaid.lib_ec.sign;

/**
 * Created By codesaid
 * On :2020-04-07 21:02
 * Package Name: com.codesaid.lib_ec.sign
 * desc:
 */
public interface ISignListener {

    /**
     * 登录成功回调
     */
    void onSignInSuccess();

    /**
     * 注册成功回调
     */
    void onSignUpSuccess();
}
