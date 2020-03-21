package com.codesaid.lib_core.utils.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.codesaid.lib_core.app.CodeSaid;

/**
 * Created By codesaid
 * On :2020-03-21 21:04
 * Package Name: com.codesaid.lib_core.utils.dimen
 * desc: 屏幕 相关 工具类
 */
public final class DimenUtil {

    /**
     * 获取屏幕的 宽
     *
     * @return 屏幕的 宽
     */
    public static int getScreenWidth() {
        final Resources resources = CodeSaid.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取屏幕的 高
     *
     * @return 屏幕的 高
     */
    public static int getScreenHeight() {
        final Resources resources = CodeSaid.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
