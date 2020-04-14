package com.codesaid.lib_core.app;

import com.codesaid.lib_core.utils.storage.CodeSaidPreference;

/**
 * Created By codesaid
 * On :2020-04-14 19:59
 * Package Name: com.codesaid.lib_core.app
 * desc: 管理用户信息
 */
public class AccountManager {

    private enum SignTag {
        SIGN_TAG
    }

    /**
     * 设置用户登录状态,登录后调用
     *
     * @param state true 已经登录
     */
    public static void setSignState(boolean state) {
        CodeSaidPreference.setAppFlag(SignTag.SIGN_TAG.name(), state);
    }

    /**
     * 判断用户是否已经登录
     *
     * @return true 登录
     */
    private static boolean isSignIn() {
        return CodeSaidPreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker) {
        if (isSignIn()) {
            checker.onSignIn();
        } else {
            checker.onNotSignIn();
        }
    }
}
