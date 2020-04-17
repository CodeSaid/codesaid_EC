package com.codesaid.generate;

import com.codesaid.lib_annotations.AppRegisterGenerator;
import com.codesaid.lib_core.wechat.AppRegisterTemplate;

/**
 * Created By codesaid
 * On :2020-04-17 21:54
 * Package Name: com.codesaid.generate
 * desc:
 */

@AppRegisterGenerator(
        packageName = "com.codesaid",
        registerTemplete = AppRegisterTemplate.class
)
public interface AppRsgister {
}
