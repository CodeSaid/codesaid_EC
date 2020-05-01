package com.codesaid.lib_ec.main.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.codesaid.lib_core.delegates.bottom.BottomItemDelegate;
import com.codesaid.lib_ec.R;

/**
 * Created By codesaid
 * On :2020-04-30 21:55
 * Package Name: com.codesaid.lib_ec.main.discover
 * desc: 发现
 */
public class DiscoverDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_discover;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
