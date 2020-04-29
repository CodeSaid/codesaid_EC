package com.codesaid.lib_core.delegates.bottom;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;

import com.codesaid.lib_core.delegates.CodeSaidDelegate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created By codesaid
 * On :2020-04-29 01:08
 * Package Name: com.codesaid.lib_core.delegates.bottom
 * desc:
 */
public abstract class BaseBottomDelegate extends CodeSaidDelegate {

    private final ArrayList<BottomItemDelegate> ITEM_DELEGATES = new ArrayList<>();
    private final ArrayList<BottomTabBean> TAB_BEANS = new ArrayList<>();
    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();

    // 计数
    private int mCurrentDelegate = 0;
    // 默认展示的 delegate
    private int mIndexDelegate = 0;
    // icon 点击之后改变的颜色
    private int mClickColor = Color.RED;

    public abstract LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder);

    public abstract int setIndexDelegate();

    @ColorInt
    public abstract int setClickColor();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndexDelegate = setIndexDelegate();
        if (setClickColor() != 0) {
            mClickColor = setClickColor();
        }

        final ItemBuilder builder = ItemBuilder.builder();
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = setItems(builder);
        ITEMS.putAll(items);

        for (Map.Entry<BottomTabBean, BottomItemDelegate> item : ITEMS.entrySet()) {
            final BottomTabBean key = item.getKey();
            final BottomItemDelegate value = item.getValue();
            TAB_BEANS.add(key);
            ITEM_DELEGATES.add(value);
        }
    }
}
