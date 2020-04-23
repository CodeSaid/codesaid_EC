package com.codesaid.generate;

import com.codesaid.lib_annotations.EntryGenerator;
import com.codesaid.lib_core.wechat.templates.WXEntryTemplate;

/**
 * Created By codesaid
 * On :2020-04-17 21:51
 * Package Name: com.codesaid.generate
 * desc:
 */

@EntryGenerator(
        packageName = "com.codesaid",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}
