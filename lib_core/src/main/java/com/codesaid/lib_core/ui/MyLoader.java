package com.codesaid.lib_core.ui;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.codesaid.lib_core.R;
import com.codesaid.lib_core.utils.dimen.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Created By codesaid
 * On :2020-03-21 20:53
 * Package Name: com.codesaid.lib_core.ui
 * desc:
 */
public class MyLoader {

    // 缩放比
    private static final int LOADER_SIZE_SCALE = 8;
    // 偏移量
    private static final int LOADER_OFFSET_SCALE = 10;

    private static final ArrayList<AppCompatDialog> LOADERS =
            new ArrayList<>();

    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();;

    public static void showLoading(Context context, Enum<LoaderStyle> style) {
        showLoading(context, style.name());
    }

    /**
     * show dialog
     *
     * @param context context
     * @param type    loader style
     */
    public static void showLoading(Context context, String type) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);

        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(context, type);

        dialog.setContentView(avLoadingIndicatorView);

        int deviceWindth = DimenUtil.getScreenWidth();
        int deviceHeight = DimenUtil.getScreenHeight();

        final Window window = dialog.getWindow();

        if (window != null) {
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.width = deviceWindth / LOADER_SIZE_SCALE;
            layoutParams.height = deviceHeight / LOADER_SIZE_SCALE;
            layoutParams.height = layoutParams.height + deviceHeight / LOADER_OFFSET_SCALE;
            layoutParams.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    /**
     * show dialog
     *
     * @param context context
     */
    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    /**
     * stop dialog
     */
    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                }
            }
        }
    }
}
