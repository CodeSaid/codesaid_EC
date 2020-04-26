package com.codesaid.lib_core.wechat;

import android.app.Activity;

import com.codesaid.lib_core.app.CodeSaid;
import com.codesaid.lib_core.app.ConfigType;
import com.codesaid.lib_core.wechat.callbacks.IWeChatSignInCallback;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created By codesaid
 * On :2020-04-22 20:35
 * Package Name: com.codesaid.lib_core.wechat
 * desc:
 */
public class MyWeChat {

    public static final String APP_ID = CodeSaid.getConfiguration(ConfigType.WE_CHAT_APP_ID);
    public static final String APP_SECRET = CodeSaid.getConfiguration(ConfigType.WE_CHAT_APP_SECRET);
    private final IWXAPI WXAPI;
    private IWeChatSignInCallback mSignInCallback = null;

    private static final class Holder {
        private static final MyWeChat INSTANCE = new MyWeChat();
    }

    public static MyWeChat getInstance() {
        return Holder.INSTANCE;
    }

    private MyWeChat() {
        final Activity activity = CodeSaid.getConfiguration(ConfigType.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity, APP_ID, true);
        WXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI() {
        return WXAPI;
    }

    public MyWeChat onSignSuccess(IWeChatSignInCallback callback) {
        this.mSignInCallback = callback;
        return this;
    }

    public IWeChatSignInCallback getSignInCallback() {
        return mSignInCallback;
    }

    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }
}
