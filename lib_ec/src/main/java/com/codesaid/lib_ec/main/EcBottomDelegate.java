package com.codesaid.lib_ec.main;

import android.graphics.Color;

import com.codesaid.lib_core.delegates.bottom.BaseBottomDelegate;
import com.codesaid.lib_core.delegates.bottom.BottomItemDelegate;
import com.codesaid.lib_core.delegates.bottom.BottomTabBean;
import com.codesaid.lib_core.delegates.bottom.ItemBuilder;
import com.codesaid.lib_ec.main.cart.ShopCartDelegate;
import com.codesaid.lib_ec.main.discover.DiscoverDelegate;
import com.codesaid.lib_ec.main.index.IndexDelegate;
import com.codesaid.lib_ec.main.personal.PersonalDelegate;
import com.codesaid.lib_ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Created By codesaid
 * On :2020-04-30 21:48
 * Package Name: com.codesaid.lib_ec.main
 * desc:
 */
public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new DiscoverDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new ShopCartDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new PersonalDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickColor() {
        return Color.parseColor("#ffff8800");
    }
}
