package com.codesaid.lib_core.delegates.bottom;

import java.util.LinkedHashMap;

/**
 * Created By codesaid
 * On :2020-04-29 01:23
 * Package Name: com.codesaid.lib_core.delegates.bottom
 * desc:
 */
public final class ItemBuilder {

    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();

    static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public final ItemBuilder addItem(BottomTabBean bean, BottomItemDelegate delegate) {
        ITEMS.put(bean, delegate);
        return this;
    }

    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean, BottomItemDelegate> items) {
        ITEMS.putAll(items);
        return this;
    }

    public final LinkedHashMap<BottomTabBean,BottomItemDelegate> build() {
        return ITEMS;
    }
}
