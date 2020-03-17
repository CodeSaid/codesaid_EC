package com.codesaid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.codesaid.lib_core.delegates.CodeSaidDelegate;

/**
 * Created By codesaid
 * On :2020-03-17 21:06
 * Package Name: com.codesaid
 * desc:
 */
public class MainDelegate extends CodeSaidDelegate {

    @Override
    public Object setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
