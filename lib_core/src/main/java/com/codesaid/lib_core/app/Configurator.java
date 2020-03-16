package com.codesaid.lib_core.app;

import java.util.WeakHashMap;

/**
 * Created By codesaid
 * On :2020-03-15 20:52
 * Package Name: com.codesaid.lib_core.app
 * desc: 配置文件的存储以及获取
 */
public class Configurator {

    @SuppressWarnings("SpellCheckingInspection")
    private static final WeakHashMap<String, Object> CODESAID_CONFIGS = new WeakHashMap<>();

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

    final WeakHashMap<String, Object> getCodesaidConfigs() {
        return CODESAID_CONFIGS;
    }

    /**
     * 配置结束调用，表示配置完毕
     */
    public final void configure() {
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

    private void checkConfiguration() {
        final boolean isReady = (boolean) CODESAID_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,please check Configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) CODESAID_CONFIGS.get(key.name());
    }
}