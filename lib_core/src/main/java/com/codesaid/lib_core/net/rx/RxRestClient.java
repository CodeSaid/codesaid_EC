package com.codesaid.lib_core.net.rx;

import android.content.Context;

import com.codesaid.lib_core.net.HttpMethod;
import com.codesaid.lib_core.net.RestClientBuilder;
import com.codesaid.lib_core.net.RestCreator;
import com.codesaid.lib_core.net.RestService;
import com.codesaid.lib_core.net.callback.IError;
import com.codesaid.lib_core.net.callback.IFailure;
import com.codesaid.lib_core.net.callback.IRequest;
import com.codesaid.lib_core.net.callback.ISuccess;
import com.codesaid.lib_core.net.callback.RequestCallbacks;
import com.codesaid.lib_core.net.download.DownloadHandler;
import com.codesaid.lib_core.ui.LoaderStyle;
import com.codesaid.lib_core.ui.MyLoader;

import java.io.File;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created By codesaid
 * On :2020-03-18 21:31
 * Package Name: com.codesaid.lib_core.net
 * desc: 网络请求 具体实现类
 */
public class RxRestClient {

    private final Context CONTEXT;
    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final RequestBody BODY;
    private final LoaderStyle LOADER_STYLE;
    private final File FILE;

    public RxRestClient(Context context,
                        String url,
                        WeakHashMap<String, Object> params,
                        RequestBody body,
                        LoaderStyle loaderStyle,
                        File file) {
        this.CONTEXT = context;
        this.URL = url;
        PARAMS.putAll(params);

        this.BODY = body;
        this.LOADER_STYLE = loaderStyle;
        this.FILE = file;
    }

    public static RxRestClientBuilder builder() {
        return new RxRestClientBuilder();
    }

    private Observable<String> request(HttpMethod method) {
        final RxRestService service = RestCreator.getRxRestService();

        Observable<String> observable = null;


        if (LOADER_STYLE != null) {
            MyLoader.showLoading(CONTEXT, LOADER_STYLE);
        }

        switch (method) {
            case GET:
                observable = service.get(URL, PARAMS);
                break;
            case POST:
                observable = service.post(URL, PARAMS);
                break;
            case DELETE:
                observable = service.delete(URL, PARAMS);
                break;
            case PUT:
                observable = service.put(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody = RequestBody
                        .create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part part =
                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                observable = service.upload(URL, part);
                break;
            case POST_RAW:
                observable = service.postRaw(URL, BODY);
                break;
            case PUT_RAW:
                observable = service.putRaw(URL, BODY);
                break;
            default:
                break;
        }

        return observable;
    }

    public final Observable<String> get() {
        return request(HttpMethod.GET);
    }

    public final Observable<String> post() {
        if (BODY == null) {
            return request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            return request(HttpMethod.POST_RAW);
        }
    }

    public final Observable<String> put() {
        if (BODY == null) {
            return request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            return request(HttpMethod.PUT_RAW);
        }
    }

    public final Observable<String> delete() {
        return request(HttpMethod.DELETE);
    }

    public final Observable<String> upload() {
        return request(HttpMethod.UPLOAD);
    }

    public final Observable<ResponseBody> download() {
        return RestCreator.getRxRestService().download(URL, PARAMS);
    }
}
