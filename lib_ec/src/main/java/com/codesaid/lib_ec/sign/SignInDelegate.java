package com.codesaid.lib_ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;

import com.codesaid.lib_core.delegates.CodeSaidDelegate;
import com.codesaid.lib_core.net.RestClient;
import com.codesaid.lib_core.net.callback.ISuccess;
import com.codesaid.lib_core.wechat.MyWeChat;
import com.codesaid.lib_core.wechat.callbacks.IWeChatSignInCallback;
import com.codesaid.lib_ec.R;
import com.codesaid.lib_ec.R2;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created By codesaid
 * On :2020-04-07 21:02
 * Package Name: com.codesaid.lib_ec.sign
 * desc: 登录
 */
public class SignInDelegate extends CodeSaidDelegate {

    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn() {
        if (checkForm()) {
            RestClient.builder()
                    .url("http://10.0.2.2:8080/data/user_profile.json")
                    .params("email", mEmail.getText().toString())
                    .params("password", mPassword.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            SignHandler.onSignIn(response, mISignListener);
                        }
                    })
                    .build()
                    .post();
        }
    }

    /**
     * 微信登录
     */
    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWeChat() {
        MyWeChat.getInstance().onSignSuccess(new IWeChatSignInCallback() {
            @Override
            public void onSignInSuccess(String userInfo) {

            }
        }).signIn();
    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink() {
        start(new SignUpDelegate());
    }

    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sing_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
