package zhouds.festec.latte.core2.net;

import android.content.Context;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import zhouds.festec.latte.core2.net.callback.IError;
import zhouds.festec.latte.core2.net.callback.IFailure;
import zhouds.festec.latte.core2.net.callback.IRequest;
import zhouds.festec.latte.core2.net.callback.ISuccess;
import zhouds.festec.latte.core2.ui.LoadingStyle;

/**
 * 创建者 zds
 * 创建时间 2020/1/9 0009  17:37
 *
 * @描述
 **/
public class RestClientBuilder {

    private String mUrl = null;
    private static final WeakHashMap<String, Object> PARAMS = RestCtreator.getParams();
    private IRequest mRequest = null;
    private ISuccess mSuccess = null;
    private IFailure mFailure = null;
    private IError mError = null;
    private RequestBody mBody = null;
    private Context mContext = null;
    private LoadingStyle mLoadingStyle = null;
    private File mFile = null;
    private String mDOWNLOAD_DIR = null;
    private String mEXTENSION = null;
    private String mNAME = null;

    RestClientBuilder() {
    }

    public final RestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final RestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RestClientBuilder dir(String downloadDir) {
        this.mDOWNLOAD_DIR = downloadDir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.mEXTENSION = extension;
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.mNAME = name;
        return this;
    }

    public final RestClientBuilder loaderDialog(Context context, LoadingStyle loadingStyle) {
        this.mContext = context;
        this.mLoadingStyle = loadingStyle;
        return this;
    }

    public final RestClientBuilder loaderDialog(Context context) {
        this.mContext = context;
        this.mLoadingStyle = LoadingStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mSuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder faliure(IFailure iFailure) {
        this.mFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mError = iError;
        return this;
    }

    public final RestClientBuilder request(IRequest iRequest) {
        this.mRequest = iRequest;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mDOWNLOAD_DIR, mEXTENSION, mNAME, mRequest, mSuccess, mFailure, mError, mBody, mContext, mLoadingStyle, mFile);
    }
}
