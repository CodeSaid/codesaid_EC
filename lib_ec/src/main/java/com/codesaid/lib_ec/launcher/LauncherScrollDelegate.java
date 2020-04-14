package com.codesaid.lib_ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.codesaid.lib_core.app.AccountManager;
import com.codesaid.lib_core.app.IUserChecker;
import com.codesaid.lib_core.delegates.CodeSaidDelegate;
import com.codesaid.lib_core.ui.launcher.ILauncherListener;
import com.codesaid.lib_core.ui.launcher.LauncherHolderCreator;
import com.codesaid.lib_core.ui.launcher.OnLauncherFinishTag;
import com.codesaid.lib_core.ui.launcher.ScrollLauncherTag;
import com.codesaid.lib_core.utils.storage.CodeSaidPreference;
import com.codesaid.lib_ec.R;

import java.util.ArrayList;

/**
 * Created By codesaid
 * On :2020-04-02 20:41
 * Package Name: com.codesaid.lib_ec.launcher
 * desc: 启动页 轮播图
 */
public class LauncherScrollDelegate extends CodeSaidDelegate {

    private ConvenientBanner<Integer> mConvenientBanner = null;
    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

    private ILauncherListener mILauncherListener = null;

    private void initBanners() {
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        INTEGERS.add(R.mipmap.launcher_05);
        mConvenientBanner
                .setPages(new LauncherHolderCreator(), INTEGERS) // 设置数据
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus}) // 小圆点
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL) // 小圆点位置
                .setOnItemClickListener(new OnItemClickListener() { // 点击事件
                    @Override
                    public void onItemClick(int position) {
                        // 点击的是最后一个
                        if (position == INTEGERS.size() - 1) {
                            CodeSaidPreference.setAppFlag(ScrollLauncherTag.HAS_FIRST__LAUNCHER_APP.name(), true);
                            // TODO 检查用户是否已经登录
                            AccountManager.checkAccount(new IUserChecker() {
                                @Override
                                public void onSignIn() {
                                    if (mILauncherListener != null) {
                                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                                    }
                                }

                                @Override
                                public void onNotSignIn() {
                                    if (mILauncherListener != null) {
                                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
                                    }
                                }
                            });

                        }
                    }
                })
                .setCanLoop(false); // 是否可以循环
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener) {
            mILauncherListener = (ILauncherListener) activity;
        }
    }

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanners();
    }
}
