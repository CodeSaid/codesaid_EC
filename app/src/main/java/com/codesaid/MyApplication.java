package com.codesaid;

import android.app.Application;

import com.codesaid.lib_core.app.CodeSaid;
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
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
