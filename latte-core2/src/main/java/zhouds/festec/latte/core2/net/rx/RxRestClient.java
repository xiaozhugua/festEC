package zhouds.festec.latte.core2.net.rx;

import android.content.Context;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import io.reactivex.Observable;
import zhouds.festec.latte.core2.net.HttpMethod;
import zhouds.festec.latte.core2.net.RestCtreator;
import zhouds.festec.latte.core2.ui.LatteLoader;
import zhouds.festec.latte.core2.ui.LoadingStyle;

/**
 * 创建者 zds
 * 创建时间 2020/1/9 0009  14:42
 *
 * @描述
 **/
public class RxRestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCtreator.getParams();
    private final RequestBody BODY;
    private final Context CONTEXT;
    private final LoadingStyle LOADING_STYLE;

    private final File FILE;

    public RxRestClient(String url,
                        Map<String, Object> params,
                        RequestBody body,
                        Context context,
                        LoadingStyle loadingStyle,
                        File file) {
        this.URL = url;
        PARAMS.putAll(params);
        this.BODY = body;
        this.CONTEXT = context;
        this.LOADING_STYLE = loadingStyle;
        this.FILE = file;
    }

    public static RxRestClientBuilder builder() {
        return new RxRestClientBuilder();
    }

    private Observable<String> request(HttpMethod method) {
        final RxRestService service = RestCtreator.getRxRestService();

        Observable observable = null;

        if (LOADING_STYLE != null) {
            LatteLoader.showLoading(CONTEXT, LOADING_STYLE);
        }
        switch (method) {
            case GET:
                observable = service.get(URL, PARAMS);
                break;
            case POST:
                observable = service.post(URL, PARAMS);
                break;
            case POST_RAW:
                observable = service.postRaw(URL, BODY);
                break;
            case PUT:
                observable = service.put(URL, PARAMS);
                break;
            case PUT_RAW:
                observable = service.putRaw(URL, BODY);
                break;
            case DELETE:
                observable = service.delete(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body =
                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                observable = service.upload(URL, body);
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
                throw new RuntimeException("params must be null");
            }
            return request(HttpMethod.POST_RAW);
        }
    }

    public final Observable<String> put() {
        if (BODY == null) {
            return request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null");
            }
            return request(HttpMethod.PUT_RAW);
        }

    }

    public final Observable<String> delete() {
        return request(HttpMethod.DELETE);
    }

    public final Observable<ResponseBody> download() {
        return RestCtreator.getRxRestService().download(URL, PARAMS);
    }
}
