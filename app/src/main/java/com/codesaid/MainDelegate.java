package com.codesaid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.codesaid.lib_core.delegates.CodeSaidDelegate;
import com.codesaid.lib_core.net.RestClient;
import com.codesaid.lib_core.net.RestCreator;
import com.codesaid.lib_core.net.callback.IError;
import com.codesaid.lib_core.net.callback.IFailure;
import com.codesaid.lib_core.net.callback.ISuccess;

import java.util.WeakHashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created By codesaid
 * On :2020-03-17 21:06
 * Package Name: com.codesaid
 * desc:
 */
public class MainDelegate extends CodeSaidDelegate {

    @Override
    public Object setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        test();
    }

    private void test() {
        RestClient.builder()
                .url("http://10.0.2.2:8080/index.json")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                        Log.e("Success", response);
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .build()
                .get();
    }

    private void testRx() {
        String url = "http://127.0.0.1/index";
        WeakHashMap<String, Object> params = new WeakHashMap<>();
        Observable<String> observable = RestCreator.getRxRestService().get(url, params);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        // 获取数据

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
