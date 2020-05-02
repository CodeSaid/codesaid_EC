package com.codesaid;

import android.app.Application;

import com.codesaid.lib_core.app.CodeSaid;
import com.codesaid.lib_core.net.interceptors.DebugInterceptor;
import com.codesaid.lib_ec.database.DatabaseManager;
import com.codesaid.lib_ec.icon.MyFontModel;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created By codesaid
 * On :2020-03-16 21:04
 * Package Name: com.codesaid
 * desc:
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CodeSaid.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new MyFontModel())
                .withLoaderDelayed(1000)
                .withApiHost("http://10.0.2.2:8080/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .withWeChatAppId("你的微信AppKey")
                .withWeChatAppSecret("你的微信AppSecret")
                .configure();

        // 初始化 数据库
        DatabaseManager.getInstance().init(this);
    }
}
