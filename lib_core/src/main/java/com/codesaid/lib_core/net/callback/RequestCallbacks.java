package com.codesaid.lib_core.net.callback;

import android.os.Handler;
import android.util.Log;

import com.codesaid.lib_core.ui.LoaderStyle;
import com.codesaid.lib_core.ui.MyLoader;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created By codesaid
 * On :2020-03-19 21:17
 * Package Name: com.codesaid.lib_core.net.callback
 * desc:
 */
public class RequestCallbacks implements Callback<String> {

    private final IRequest mIRequest;
    private final ISuccess mISuccess;
    private final IError mIError;
    private final IFailure mIFailure;
    private final LoaderStyle mLoaderStyle;

    private static final Handler mHandler = new Handler();

    public RequestCallbacks(IRequest IRequest,
                            ISuccess ISuccess,
                            IError IError,
                            IFailure IFailure,
                            LoaderStyle loaderStyle) {
        this.mIRequest = IRequest;
        this.mISuccess = ISuccess;
        this.mIError = IError;
        this.mIFailure = IFailure;
        this.mLoaderStyle = loaderStyle;
    }


    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) { // 请求成功
            if (call.isExecuted()) {
                if (mISuccess != null) {
                    mISuccess.onSuccess(response.body());

                }
            }
        } else { // 请求失败
            if (mIError != null) {
                mIError.onError(response.code(), response.message());
            }
        }

        stopLoading();
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (mIFailure != null) {
            mIFailure.onFailure();
            Log.e("TAG", t.getMessage());
        }

        if (mIRequest != null) {
            mIRequest.onRequestEnd();
        }

        stopLoading();
    }

    private void stopLoading() {
        if (mLoaderStyle != null) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    MyLoader.stopLoading();
                }
            }, 2000);
        }
    }
}
