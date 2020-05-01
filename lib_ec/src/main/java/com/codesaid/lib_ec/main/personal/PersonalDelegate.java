package com.codesaid.lib_ec.main.personal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.codesaid.lib_core.delegates.bottom.BottomItemDelegate;
import com.codesaid.lib_ec.R;

/**
 * Created By codesaid
 * On :2020-04-30 21:56
 * Package Name: com.codesaid.lib_ec.main.personal
 * desc: 个人中心
 */
public class PersonalDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_personal;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
