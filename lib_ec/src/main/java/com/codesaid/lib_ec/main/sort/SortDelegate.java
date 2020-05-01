package com.codesaid.lib_ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.codesaid.lib_core.delegates.bottom.BottomItemDelegate;
import com.codesaid.lib_ec.R;

/**
 * Created By codesaid
 * On :2020-04-30 21:54
 * Package Name: com.codesaid.lib_ec.main.sort
 * desc: 分类
 */
public class SortDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        
    }
}
