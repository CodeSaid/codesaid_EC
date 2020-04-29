package com.codesaid.lib_core.delegates.bottom;

/**
 * Created By codesaid
 * On :2020-04-29 01:20
 * Package Name: com.codesaid.lib_core.delegates.bottom
 * desc:
 */
public final class BottomTabBean {

    private final CharSequence ICON;
    private final CharSequence TITLE;

    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }
}
