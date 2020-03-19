package com.codesaid.lib_core.net.callback;

/**
 * Created By codesaid
 * On :2020-03-19 20:47
 * Package Name: com.codesaid.lib_core.net.callback
 * desc:
 */
public interface IError {
    void onError(int code, String msg);
}
