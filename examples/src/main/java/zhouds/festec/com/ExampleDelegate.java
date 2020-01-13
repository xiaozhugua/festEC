package zhouds.festec.com;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.WeakHashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import zhouds.festec.latte.core2.delegate.LatteDelegate;
import zhouds.festec.latte.core2.net.RestClient;
import zhouds.festec.latte.core2.net.RestCtreator;
import zhouds.festec.latte.core2.net.callback.IError;
import zhouds.festec.latte.core2.net.callback.IFailure;
import zhouds.festec.latte.core2.net.callback.IRequest;
import zhouds.festec.latte.core2.net.callback.ISuccess;
import zhouds.festec.latte.core2.net.rx.RxRestClient;

/**
 * 创建者 zds
 * 创建时间 2020/1/8 0008  16:21
 *
 * @描述
 **/
public class ExampleDelegate extends LatteDelegate {

    private static final String TAG = "zds";


    @Override
    public void onBindView(@NonNull Bundle savedInstanceState, View rootView) {

//        testRestClient();
//        onCallRxGet();

        onCallRxGet2();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    //TODO 测试方法 没什么用 方法二
    public void onCallRxGet2() {
        RxRestClient.builder()
                .url("/index")
                .build()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("zds2", "onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //TODO 测试方法 没什么用 方法一
    public void onCallRxGet() {
        final String url = "/index";
        final WeakHashMap<String, Object> params = new WeakHashMap<>();
        final Observable<String> observable = RestCtreator.getRxRestService().get(url, params);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("zds", "onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void testRestClient() {
        RestClient.builder()
                .url("index")
                .loaderDialog(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Log.i(TAG, "onSuccess: " + response);
                    }
                })
                .faliure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .request(new IRequest() {
                    @Override
                    public void onRequestStart() {

                    }

                    @Override
                    public void onRequestEnd() {

                    }
                })
                .build()
                .get();
    }
}
