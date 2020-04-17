package com.codesaid.generate;

import com.codesaid.lib_annotations.PayEntryGenerator;
import com.codesaid.lib_core.wechat.WXPayEntryTemplate;

/**
 * Created By codesaid
 * On :2020-04-17 21:51
 * Package Name: com.codesaid.generate
 * desc:
 */

@PayEntryGenerator(
        packageName = "com.codesaid",
        payEntryTemplete = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
