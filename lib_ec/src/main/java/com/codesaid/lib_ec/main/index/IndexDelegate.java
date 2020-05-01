package com.codesaid.lib_ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.codesaid.lib_core.delegates.bottom.BottomItemDelegate;
import com.codesaid.lib_ec.R;

/**
 * Created By codesaid
 * On :2020-04-30 21:49
 * Package Name: com.codesaid.lib_ec.main.index
 * desc: 主页
 */
public class IndexDelegate extends BottomItemDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
