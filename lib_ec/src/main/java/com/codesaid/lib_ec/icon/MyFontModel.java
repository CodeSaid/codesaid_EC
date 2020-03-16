package com.codesaid.lib_ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Created By codesaid
 * On :2020-03-16 20:49
 * Package Name: com.codesaid.lib_ec.icon
 * desc: 自定义 字体图标 引入
 */
public class MyFontModel implements IconFontDescriptor {

    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return Icons.values();
    }
}
