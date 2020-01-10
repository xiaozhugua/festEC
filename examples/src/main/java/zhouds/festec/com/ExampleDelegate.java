package zhouds.festec.com;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import zhouds.festec.latte.core2.delegate.LatteDelegate;
import zhouds.festec.latte.core2.net.RestClient;
import zhouds.festec.latte.core2.net.callback.IError;
import zhouds.festec.latte.core2.net.callback.IFailure;
import zhouds.festec.latte.core2.net.callback.IRequest;
import zhouds.festec.latte.core2.net.callback.ISuccess;

/**
 * 创建者 zds
 * 创建时间 2020/1/8 0008  16:21
 *
 * @描述
 **/
public class ExampleDelegate extends LatteDelegate {


    @Override
    public void onBindView(@NonNull Bundle savedInstanceState, View rootView) {

    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    private void testRestClient() {

        RestClient.builder()
                .url("")
                .params("", "")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

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
                .build();
    }
}
