package com.codesaid.lib_core.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.codesaid.lib_core.app.CodeSaid;
import com.codesaid.lib_core.net.RestClient;
import com.codesaid.lib_core.net.callback.IError;
import com.codesaid.lib_core.net.callback.IFailure;
import com.codesaid.lib_core.net.callback.ISuccess;

/**
 * Created By codesaid
 * On :2020-05-01 20:37
 * Package Name: com.codesaid.lib_core.ui.refresh
 * desc:下拉刷新 辅助类
 */
public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;

    public RefreshHandler(SwipeRefreshLayout refresh_layout) {
        this.REFRESH_LAYOUT = refresh_layout;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);
        CodeSaid.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                REFRESH_LAYOUT.setRefreshing(false);
            }
        }, 2000);
    }

    public void firstPage(String url) {
        RestClient.builder()
                .url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(CodeSaid.getApplication(), response, Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Toast.makeText(CodeSaid.getApplication(), "failure", Toast.LENGTH_SHORT).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Toast.makeText(CodeSaid.getApplication(), msg, Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .get();

    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
