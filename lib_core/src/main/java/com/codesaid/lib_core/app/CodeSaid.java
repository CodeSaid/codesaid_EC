package com.codesaid.lib_core.app;

import android.content.Context;
import android.os.Handler;

import java.util.HashMap;

/**
 * Created By codesaid
 * On :2020-03-15 20:50
 * Package Name: com.codesaid.lib_core.app
 * desc: APP init 配置
 */
public final class CodeSaid {

    public static Configurator init(Context context) {
        Configurator
                .getInstance()
                .getCodesaidConfigs()
                .put(ConfigType.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<Object, Object> getConfigurations() {
        return Configurator.getInstance().getCodesaidConfigs();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigType.HANDLER);
    }

    public static Context getApplication() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT);
    }
}
