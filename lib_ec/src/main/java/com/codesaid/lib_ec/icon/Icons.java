package com.codesaid.lib_ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created By codesaid
 * On :2020-03-16 20:50
 * Package Name: com.codesaid.lib_ec.icon
 * desc:
 */
public enum Icons implements Icon {
    icon_scan('\ue602'),
    icon_ali_pay('\ue606');

    private char character;

    Icons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
