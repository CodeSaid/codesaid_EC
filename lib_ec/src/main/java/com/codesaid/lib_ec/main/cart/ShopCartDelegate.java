package com.codesaid.lib_ec.main.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.codesaid.lib_core.delegates.bottom.BottomItemDelegate;
import com.codesaid.lib_ec.R;

/**
 * Created By codesaid
 * On :2020-04-30 21:56
 * Package Name: com.codesaid.lib_ec.main.cart
 * desc: 购物车
 */
public class ShopCartDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_shop_cart;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
