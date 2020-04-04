package com.codesaid.lib_core.net;

import android.content.Context;

import com.codesaid.lib_core.net.callback.IError;
import com.codesaid.lib_core.net.callback.IFailure;
import com.codesaid.lib_core.net.callback.IRequest;
import com.codesaid.lib_core.net.callback.ISuccess;
import com.codesaid.lib_core.ui.loader.LoaderStyle;

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
public class RestClientBuilder {

    private Context mContext;
    private String mUrl = null;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IError mIError = null;
    private IFailure mIFailure = null;
    private RequestBody mBody = null;
    private LoaderStyle mLoaderStyle = null;
    private File file = null;
    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;

    RestClientBuilder() {
    }

    /**
     * 请求地址
     *
     * @param url 请求地址
     */
    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    /**
     * 请求参数
     *
     * @param params 键值对以 map 形式传递
     */
    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    /**
     * 请求参数
     *
     * @param key   键
     * @param value 值
     */
    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;character=UTF-8"), raw);
        return this;
    }

    /**
     * 网络请求 成功 回调
     */
    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    /**
     * 网络请求 失败 回调
     */
    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    /**
     * 网络请求 出错 回调
     *
     * @param iFailure
     */
    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    /**
     * 发送请求时显示的 loader 样式
     *
     * @param context     context
     * @param loaderStyle loader 样式
     */
    public final RestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
        this.mContext = context;
        this.mLoaderStyle = loaderStyle;
        return this;
    }

    /**
     * 发送请求时显示的 默认的 loader 样式
     *
     * @param context context
     */
    public final RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    /**
     * 上传文件
     *
     * @param file file
     */
    public final RestClientBuilder file(File file) {
        this.file = file;
        return this;
    }

    /**
     * 下载文件的的文件后缀名
     *
     * @param extension 文件后缀名
     */
    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }

    /**
     * 下载文件时 文件的存放目录
     *
     * @param downloadDir 文件的存放目录
     */
    public final RestClientBuilder dir(String downloadDir) {
        this.mDownloadDir = downloadDir;
        return this;
    }

    /**
     * 下载的 文件名
     *
     * @param name 文件名
     */
    public final RestClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    /**
     * 上传文件
     *
     * @param filePath file 路径
     */
    public final RestClientBuilder file(String filePath) {
        this.file = new File(filePath);
        return this;
    }

    public final RestClient build() {
        return new RestClient(mContext, mUrl, PARAMS, mIRequest,
                mISuccess, mIError, mIFailure, mBody, mLoaderStyle, file, mDownloadDir, mExtension, mName);
    }
}
