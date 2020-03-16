package com.codesaid.lib_core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created By codesaid
 * On :2020-03-15 20:52
 * Package Name: com.codesaid.lib_core.app
 * desc: 配置文件的存储以及获取
 */
public class Configurator {

    @SuppressWarnings("SpellCheckingInspection")
    private static final HashMap<String, Object> CODESAID_CONFIGS = new HashMap<>();

    private static final List<IconFontDescriptor> ICONS = new ArrayList();

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

    final HashMap<String, Object> getCodesaidConfigs() {
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