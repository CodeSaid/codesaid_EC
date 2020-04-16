package com.codesaid.lib_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created By codesaid
 * On :2020-04-16 21:58
 * Package Name: com.codesaid.lib_annotations
 * desc:
 */

// 该注解是告诉编译器 我们 这个注解是 用在 类 上面的
@Target(ElementType.TYPE)
// 告诉编译器 在 源码阶段 处理
@Retention(RetentionPolicy.SOURCE)
public @interface PayEntryGenerator {

    String packageName();

    Class<?> payEntryTemplete();
}
