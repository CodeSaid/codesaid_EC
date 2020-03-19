package com.codesaid.lib_core.net.callback;

import android.util.Log;

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

    private IRequest mIRequest;
    private ISuccess mISuccess;
    private IError mIError;
    private IFailure mIFailure;

    public RequestCallbacks(IRequest IRequest,
                            ISuccess ISuccess,
                            IError IError,
                            IFailure IFailure) {
        mIRequest = IRequest;
        mISuccess = ISuccess;
        mIError = IError;
        mIFailure = IFailure;
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
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (mIFailure != null) {
            mIFailure.onFailure();
            Log.e("TAG",t.getMessage());
        }

        if (mIRequest != null) {
            mIRequest.onRequestEnd();
        }
    }
}
