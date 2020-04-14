package com.codesaid.lib_ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codesaid.lib_core.app.AccountManager;
import com.codesaid.lib_ec.database.DatabaseManager;
import com.codesaid.lib_ec.database.UserProfile;

/**
 * Created By codesaid
 * On :2020-04-07 21:02
 * Package Name: com.codesaid.lib_ec.sign
 * desc:
 */
public class SignHandler {

    public static void onSignUp(String response,ISignListener listener) {
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);

        // 保存用户状态
        AccountManager.setSignState(true);
        listener.onSignUpSuccess();
    }
}
