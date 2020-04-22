package com.codesaid.lib_core.app;

import android.app.Activity;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Interceptor;

/**
 * Created By codesaid
 * On :2020-03-15 20:52
 * Package Name: com.codesaid.lib_core.app
 * desc: 配置文件的存储以及获取
 */
public class Configurator {

    @SuppressWarnings("SpellCheckingInspection")
    private static final HashMap<Object, Object> CODESAID_CONFIGS = new HashMap<>();

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList();

    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    private Configurator() {
        // 表示开始配置
        CODESAID_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    @SuppressWarnings("WeakerAccess")
    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<Object, Object> getCodesaidConfigs() {
        return CODESAID_CONFIGS;
    }

    /**
     * 配置结束调用，表示配置完毕
     */
    public final void configure() {
        initIcons();
        CODESAID_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    /**
     * 配置 api host
     *
     * @param host api host
     */
    public final Configurator withApiHost(String host) {
        CODESAID_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    /**
     * 初始化字体图标
     */
    private void initIcons() {
        if (ICONS.size() > 0) {
            // 初始化 第 0 个
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    /**
     * 添加字体图标
     *
     * @param descriptor 字体图标
     */
    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    /**
     * 添加 loader 延迟
     *
     * @param delayed 秒
     */
    public final Configurator withLoaderDelayed(long delayed) {
        CODESAID_CONFIGS.put(ConfigType.LOADER_DELAYED, delayed);
        return this;
    }

    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        CODESAID_CONFIGS.put(ConfigType.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(List<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        CODESAID_CONFIGS.put(ConfigType.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withWeChatAppId(String appId) {
        CODESAID_CONFIGS.put(ConfigType.WE_CHAT_APP_ID, appId);
        return this;
    }

    public final Configurator withWeChatAppSecret(String appSecret) {
        CODESAID_CONFIGS.put(ConfigType.WE_CHAT_APP_SECRET, appSecret);
        return this;
    }

    public final Configurator withActivity(Activity activity) {
        CODESAID_CONFIGS.put(ConfigType.ACTIVITY, activity);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) CODESAID_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,please check Configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = CODESAID_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) CODESAID_CONFIGS.get(key);
    }
}