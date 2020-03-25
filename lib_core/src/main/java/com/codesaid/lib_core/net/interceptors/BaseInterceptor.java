package com.codesaid.lib_core.net.interceptors;

import java.util.LinkedHashMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * Created By codesaid
 * On :2020-03-25 20:43
 * Package Name: com.codesaid.lib_core.net.interceptors
 * desc:
 */
public abstract class BaseInterceptor implements Interceptor {

    protected LinkedHashMap<String, String> getUrlParameters(Chain chain) {
        final HttpUrl httpUrl = chain.request().url();
        int size = httpUrl.querySize();
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            params.put(httpUrl.queryParameterName(i), httpUrl.queryParameterValue(i));
        }
        return params;
    }

    protected String getUrlParameters(Chain chain, String key) {
        final Request request = chain.request();
        return request.url().queryParameter(key);
    }

    protected LinkedHashMap<String, String> getBodyParameers(Chain chain) {
        final FormBody formBody = (FormBody) chain.request().body();
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();

        int siz = formBody.size();
        for (int i = 0; i < siz; i++) {
            params.put(formBody.name(i), formBody.value(i));
        }

        return params;
    }

    protected String getBodyParameers(Chain chain, String key) {
        return getBodyParameers(chain).get(key);
    }
}
