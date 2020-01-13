package zhouds.festec.latte.core2.net.rx;

import android.content.Context;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import zhouds.festec.latte.core2.net.RestCtreator;
import zhouds.festec.latte.core2.ui.LoadingStyle;

/**
 * 创建者 zds
 * 创建时间 2020/1/9 0009  17:37
 *
 * @描述
 **/
public class RxRestClientBuilder {

    private String mUrl = null;
    private static final WeakHashMap<String, Object> PARAMS = RestCtreator.getParams();
    private RequestBody mBody = null;
    private Context mContext = null;
    private LoadingStyle mLoadingStyle = null;
    private File mFile = null;

    RxRestClientBuilder() {
    }

    public final RxRestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final RxRestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RxRestClientBuilder loaderDialog(Context context, LoadingStyle loadingStyle) {
        this.mContext = context;
        this.mLoadingStyle = loadingStyle;
        return this;
    }

    public final RxRestClientBuilder loaderDialog(Context context) {
        this.mContext = context;
        this.mLoadingStyle = LoadingStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RxRestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RxRestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RxRestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RxRestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }


    public final RxRestClient build() {
        return new RxRestClient(mUrl, PARAMS, mBody, mContext, mLoadingStyle, mFile);
    }
}
