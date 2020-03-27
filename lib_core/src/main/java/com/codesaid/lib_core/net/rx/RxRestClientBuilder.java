package com.codesaid.lib_core.net.rx;

import android.content.Context;

import com.codesaid.lib_core.net.RestCreator;
import com.codesaid.lib_core.ui.LoaderStyle;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created By codesaid
 * On :2020-03-19 20:29
 * Package Name: com.codesaid.lib_core.net
 * desc:
 */
public class RxRestClientBuilder {

    private Context mContext;
    private String mUrl = null;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private RequestBody mBody = null;
    private LoaderStyle mLoaderStyle = null;
    private File file = null;

    RxRestClientBuilder() {
    }

    /**
     * 请求地址
     *
     * @param url 请求地址
     */
    public final RxRestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    /**
     * 请求参数
     *
     * @param params 键值对以 map 形式传递
     */
    public final RxRestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    /**
     * 请求参数
     *
     * @param key   键
     * @param value 值
     */
    public final RxRestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RxRestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;character=UTF-8"), raw);
        return this;
    }

    /**
     * 发送请求时显示的 loader 样式
     *
     * @param context     context
     * @param loaderStyle loader 样式
     */
    public final RxRestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
        this.mContext = context;
        this.mLoaderStyle = loaderStyle;
        return this;
    }

    /**
     * 发送请求时显示的 默认的 loader 样式
     *
     * @param context context
     */
    public final RxRestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    /**
     * 上传文件
     *
     * @param file file
     */
    public final RxRestClientBuilder file(File file) {
        this.file = file;
        return this;
    }

    /**
     * 上传文件
     *
     * @param filePath file 路径
     */
    public final RxRestClientBuilder file(String filePath) {
        this.file = new File(filePath);
        return this;
    }

    public final RxRestClient build() {
        return new RxRestClient(mContext, mUrl, PARAMS, mBody, mLoaderStyle, file);
    }
}
