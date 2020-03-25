package com.codesaid.lib_core.net;

import com.codesaid.lib_core.app.CodeSaid;
import com.codesaid.lib_core.app.ConfigType;

import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created By codesaid
 * On :2020-03-18 21:43
 * Package Name: com.codesaid.lib_core.net
 * desc:
 */
public final class RestCreator {

    /**
     * 参数容器
     */
    private static final class ParamsHolder {
        private static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }

    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    /**
     * 初始化 Retrofit
     */
    private static final class RetrofitHolder {
        private static final String BASE_URL =
                (String) CodeSaid.getConfigurations().get(ConfigType.API_HOST.name());
        @SuppressWarnings("ConstantConditions")
        private static final Retrofit RETROFIT_CLIENT =
                new Retrofit
                        .Builder()
                        .baseUrl(BASE_URL)
                        .client(OKHttpHolder.OK_HTTP_CLIENT)
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .build();
    }

    /**
     * 初始化 OkHttpClient
     */
    private static final class OKHttpHolder {
        private static final int TIME_OUT = 60;

        private static final OkHttpClient.Builder BUILDER = new OkHttpClient.Builder();

        private static final ArrayList<Interceptor> INTERCEPTORS =
                CodeSaid.getConfiguration(ConfigType.INTERCEPTOR);

        private static OkHttpClient.Builder addInterceptor() {
            if (INTERCEPTORS != null && !INTERCEPTORS.isEmpty()) {
                for (Interceptor interceptor : INTERCEPTORS) {
                    BUILDER.addInterceptor(interceptor);
                }
            }
            return BUILDER;
        }

        private static final OkHttpClient OK_HTTP_CLIENT =
                addInterceptor()
                        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                        .build();

    }

    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);

    }
}
