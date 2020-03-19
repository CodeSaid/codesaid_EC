package com.codesaid.lib_core.net;

import com.codesaid.lib_core.net.callback.IError;
import com.codesaid.lib_core.net.callback.IFailure;
import com.codesaid.lib_core.net.callback.IRequest;
import com.codesaid.lib_core.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.RequestBody;

/**
 * Created By codesaid
 * On :2020-03-18 21:31
 * Package Name: com.codesaid.lib_core.net
 * desc: 网络请求 具体实现类
 */
public class RestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    private final RequestBody BODY;

    public RestClient(String url,
                      WeakHashMap<String, Object> params,
                      IRequest request,
                      ISuccess success,
                      IError error,
                      IFailure failure,
                      RequestBody body) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.BODY = body;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }
}
